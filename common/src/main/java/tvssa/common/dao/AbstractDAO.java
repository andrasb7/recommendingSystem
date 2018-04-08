package tvssa.common.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tvssa.common.entities.AbstractEntity;

public class AbstractDAO<E extends AbstractEntity> implements DataAcessObject<E> {

	protected EntityManager em;
	protected EntityTransaction transaction;
	protected Class<E> entityClass;
	protected EntityManagerFactory factory;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void fillEntityClass() {	
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	public synchronized E create(final E entity) {
		setupEM();
		transaction.begin();
		if (em.contains(entity)) {
			return em.merge(entity);
		}
		em.persist(entity);
		transaction.commit();
		closeEM();
		return entity;
	}

	public void update(final E entity) {
		setupEM();
		transaction.begin();
		em.merge(entity);
		transaction.commit();
	}

	public void delete(final E entity) {
		setupEM();
		transaction.begin();
		if (em.contains(entity)) {
			em.remove(entity);
		}
		transaction.commit();
	}

	public E findByID(Object id) {
		return em.find(entityClass, id);
	}
	
	protected void setupEM() {
		factory = Persistence.createEntityManagerFactory("tvssa");
        em = factory.createEntityManager();
        transaction = em.getTransaction();
	}
	protected void closeEM() {
		
		em.close();
		factory.close();
	}
}

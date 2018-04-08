package tvssa.common.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import tvssa.common.entities.CategoryE;

@Stateless
public class CategoryDAO extends AbstractDAO<CategoryE> {

	@SuppressWarnings("unchecked")
	public CategoryE findByName(String name) {
		setupEM();
		Query q = em.createNamedQuery(CategoryE.FIND_BY_NAME, CategoryE.class);
		q.setParameter("name", name);

		try {
			List<CategoryE> list = (List<CategoryE>) q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for Category name = " + name);
			return null;
		} finally {
			closeEM();
		}

	}
	@SuppressWarnings("unchecked")
	public CategoryE findById(Long id) {
		setupEM();
		Query q = em.createNamedQuery(CategoryE.FIND_BY_ID, CategoryE.class);
		q.setParameter("id", id);

		try {
			List<CategoryE> list = (List<CategoryE>) q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for Category ID = " + id);
			return null;
		} finally {
			closeEM();
		}

	}

}

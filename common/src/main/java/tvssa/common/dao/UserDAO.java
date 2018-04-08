package tvssa.common.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tvssa.common.entities.UserE;

@Stateless
public class UserDAO extends AbstractDAO<UserE> {
	
	public UserE findByUserName(String name) {
		setupEM();
		TypedQuery<UserE> q = em.createNamedQuery(UserE.FIND_BY_USER_NAME, UserE.class);
		q.setParameter("userName", name);

		try {
			List<UserE> list = (List<UserE>) q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for UserE userName = " + name);
			return null;
		} finally {
			closeEM();
		}

	}
	
	public UserE findByUserNameAndPassword(String name, String password) {
		setupEM();
		TypedQuery<UserE> q = em.createNamedQuery(UserE.FIND_BY_USER_NAME_AND_PASSWORD, UserE.class);
		q.setParameter("userName", name);
		q.setParameter("password", password);

		try {
			
			List<UserE> list = q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for UserE userName = " + name);
			return null;
		} finally {
			closeEM();
		}

	}
	
	public UserE findById(Long id) {
		setupEM();
		TypedQuery<UserE> q = em.createNamedQuery(UserE.FIND_BY_ID, UserE.class);
		q.setParameter("id", id);

		try {
			List<UserE> list = q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for UserE ID = " + id);
			return null;
		} finally {
			closeEM();
		}
	}
	
}

package tvssa.common.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tvssa.common.dao.helper.DAOHelper;
import tvssa.common.entities.SeriesE;
import tvssa.common.entities.UserE;

@Stateless
public class SeriesDAO extends AbstractDAO<SeriesE> {


	public SeriesE findByName(String name) {
		setupEM();
		TypedQuery<SeriesE> q = em.createNamedQuery(SeriesE.FIND_BY_NAME, SeriesE.class);
		q.setParameter("name", name);

		try {
			List<SeriesE> list = q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for SeriesE name = " + name);
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
		}

	}

	public SeriesE findById(Long id) {
		setupEM();
		TypedQuery<SeriesE> q = em.createNamedQuery(SeriesE.FIND_BY_ID, SeriesE.class);
		q.setParameter("id", id);

		try {
			List<SeriesE> list = q.getResultList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for SeriesE ID = " + id);
			return null;
		} finally {
		}
	}

	public List<SeriesE> findAllByName(String name) {
		setupEM();
		TypedQuery<SeriesE> q = em.createNamedQuery(SeriesE.FIND_ALL_BY_NAME, SeriesE.class);
		q.setParameter("name", "%" + name.toLowerCase() + "%");

		try {
			List<SeriesE> list = q.getResultList();
			if (!list.isEmpty()) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for SeriesE name = " + name);
			return null;
		} finally {
		}
	}

	@SuppressWarnings("unchecked")
	public List<SeriesE> findAllByUserId(Long id) {
		setupEM();
		Query q = null;
		List<String> fields = new ArrayList<>();
		fields.add(UserE.TABLE_NAME + "_ID");
		String nativeQuery = DAOHelper.createNativeForConnectTable(UserE.TABLE_NAME, SeriesE.TABLE_NAME, fields);

		if (nativeQuery != null) {
			q = em.createNativeQuery(nativeQuery);
			q.setParameter(1, id);
		} else {
			System.out.println("Error while looking creating query...");
			return null;
		}

		try {
			List<String> idList = q.getResultList();
			System.out.println("ID: " + idList);
			List<SeriesE> seriesList = new ArrayList<>();
			idList.forEach(ID -> seriesList.add(findById(Long.valueOf(ID))));
			System.out.println("Series: " + seriesList);
			if (!seriesList.isEmpty()) {
				return seriesList;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error while looking for SeriesE by UserE = " + id);
			return null;
		} finally {
		}
	}

}

package tvssa.common.dao.helper;

import java.util.List;

import javax.ejb.Singleton;

@Singleton
public class DAOHelper {
	
public static String createNativeForConnectTable (String tableNameFirst, String tableNameSecond, List <String> fields) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT ");
		sb.append(tableNameSecond);
		sb.append("_ID ");
		sb.append("FROM ");
		sb.append(tableNameFirst);
		sb.append("_");
		sb.append(tableNameSecond);
		
		if (fields.size() > 0) {
			sb.append(" WHERE ");
			
			if (fields.size() == 1) {
				sb.append(fields.get(0));
				sb.append(" = ?");
				sb.append(1);	
			} else {
				for (int i = 0; i < fields.size() - 1; ++i) {
					sb.append(fields.get(i));
					sb.append(" = ?");
					sb.append(Integer.valueOf(i + 1));
					sb.append(" AND ");
				}
				sb.append(fields.get(fields.size() - 1));
				sb.append(" = ?");
				sb.append(fields.size() - 1);
			}
		}

		System.out.println(sb.toString());
		if (sb!= null & sb.length() > 0) {
			return sb.toString();
		}
		return null;
	}

}

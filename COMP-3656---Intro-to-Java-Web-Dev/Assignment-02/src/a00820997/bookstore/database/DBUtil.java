package a00820997.bookstore.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static boolean tableExists(Connection connection, String tableName) throws SQLException {
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getTables(connection.getCatalog(), "%", "%", null);
		String name = null;
		while (resultSet.next()) {
			name = resultSet.getString("TABLE_NAME");
			if (name.equalsIgnoreCase(tableName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Private Constructor
	 */
	private DBUtil() {

	}

}

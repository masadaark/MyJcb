package Connection;

import java.sql.*;
import com.alibaba.fastjson2.JSONObject;
import com.zaxxer.hikari.*;

public abstract class PgQuery {
    private static final HikariDataSource dataSource;
    private static final JSONObject dbConfig;

    static {
        dbConfig = Config.getEnvConfig();
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbConfig.getString("url"));
        config.setUsername(dbConfig.getString("user"));
        config.setPassword(dbConfig.getString("password"));
        config.setMaximumPoolSize(10); // set maximum number of connections in the pool
        config.setConnectionTimeout(1000); // set connection timeout
        dataSource = new HikariDataSource(config);
    }

    public static JSONObject execute(String query) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            boolean flagResultSet = statement.execute();
            JSONObject result = new JSONObject();
            if (flagResultSet) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    int rowCount = 0;
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int limitColumn = metaData.getColumnCount();
                    while (resultSet.next()) {
                        JSONObject row = new JSONObject();
                        for (int i = 1; i <= limitColumn; i++) {
                            row.put(metaData.getColumnName(i), resultSet.getObject(i));
                        }
                        result.put(Integer.toString(rowCount), row);
                        rowCount++;
                    }
                    if (rowCount == 0) {
                        return null;
                    }
                }
            } else {
                return null;
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return "PgQuery return to FastJson JSONObject.";
    }
}
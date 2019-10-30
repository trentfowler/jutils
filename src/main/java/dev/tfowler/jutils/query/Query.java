package dev.tfowler.jutils.query;

import dev.tfowler.jutils.ResultSetMapper;
import dev.tfowler.jutils.datasource.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Query {
  private static final Query INSTANCE = new Query(); // eagerly initialized singleton

  private DataSource dataSource;

  private Query() {} // prevent instantiation

  public static Query with(final DataSource dataSource) {
    INSTANCE.dataSource = dataSource;

    return INSTANCE;
  }

  public <T> T fetch(Class<T> cl, String sql) throws Exception {
    if (dataSource == null) {
      throw new SQLException("Unable to fetch records. DataSource must not be null.");
    }
    try (Connection con = dataSource.getConnection()) {
      Statement stmt = con.createStatement();
      ResultSet rset = stmt.executeQuery(sql);
      return ResultSetMapper.mapToEntity(rset, cl);
    }
  }

  public <T> List<T> fetchList(Class<T> cl, String sql) throws Exception {
    if (dataSource == null) {
      throw new SQLException("Unable to fetch records. DataSource must not be null.");
    }
    try (Connection con = dataSource.getConnection()) {
      Statement stmt = con.createStatement();
      ResultSet rset = stmt.executeQuery(sql);
      return ResultSetMapper.mapToList(rset, cl);
    }
  }

  public <T> Set<T> fetchSet(Class<T> cl, String sql) throws Exception {
    return new HashSet<T>(fetchList(cl, sql));
  }
}

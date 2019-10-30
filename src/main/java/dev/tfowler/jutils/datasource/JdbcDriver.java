package dev.tfowler.jutils.datasource;

/**
 * Provides a list of popular JDBC drivers and their corresponding class names. For use in a
 * DriverManager-based configuration to set the {@code driverClass} property to desired
 * database.
 *
 * @see <a href="http://www.sql-workbench.net/manual/jdbc-setup.html"></a>
 * @see <a href="http://jdbc.postgresql.org"></a>
 * @see <a href="http://www.firebirdsql.org/"></a>
 * @see <a href="http://www.h2database.com"></a>
 * @see <a href="http://hsqldb.sourceforge.net"></a>
 * @see <a href="http://db.apache.org/derby/"></a>
 * @see <a href="http://www-01.ibm.com/software/data/db2/linux-unix-windows/download.html"></a>
 * @see <a href="http://jt400.sourceforge.net/"></a>
 * @see <a href="https://github.com/Microsoft/mssql-jdbc"></a>
 * @see <a href="http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html"></a>
 * @see <a href="http://www.mysql.com/downloads/connector/j"></a>
 * @see <a href="https://downloads.mariadb.org/connector-java"></a>
 */
public enum JdbcDriver {
    POSTGRESQL("org.postgresql.Driver"),
    FIREBIRD("org.firebirdsql.jdbc.FBDriver"),
    H2("org.h2.Driver"),
    HSQLDB("org.hsqldb.jdbcDriver"),
    DERBY(""),
    DB2("com.ibm.db2.jcc.DB2Driver"),
    AS400("com.ibm.as400.access.AS400JDBCDriver"),
    MSSQL("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    ORACLE("oracle.jdbc.OracleDriver"),
    MARIADB("org.mariadb.jdbc.Driver"),
    MYSQL("com.mysql.jdbc.Driver");

    private final String className;

    JdbcDriver(final String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}

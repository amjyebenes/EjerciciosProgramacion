package capitulo07.gestionVentaCoches.modelo.controladores;

import com.mysql.jdbc.Connection;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManagerV2 {

    private static String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
    private static String user = JDBCPropiedades.getProperty("JDBC_USER");
    private static String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
    private static String host = JDBCPropiedades.getProperty("JDBC_HOST");
    private static String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");

    private static PoolDataSource pds =
            PoolDataSourceFactory.getPoolDataSource();

    private static int MAX_INTENTOS_CONEXION = 4;

    /**
     * @return
     * @throws SQLException
     */
    public static Connection getConexion() throws SQLException, ImposibleConectarException {

        com.mysql.jdbc.Connection conexion;

        int intentos = 0;

        do {
            pds.setConnectionFactoryClassName(driver);

            pds.setURL("jdbc:mysql://" + host + "/" + schema);
            pds.setUser(user);
            pds.setPassword(password);
            conexion = (Connection) pds.getConnection();
            intentos++;
        } while (!conexion.isValid(5) && intentos <= MAX_INTENTOS_CONEXION);

        if (!conexion.isValid(1) && intentos >= MAX_INTENTOS_CONEXION) {
            throw new ImposibleConectarException("Tiempo agotado, imposible conectar");
        }


        return conexion;
    }

}

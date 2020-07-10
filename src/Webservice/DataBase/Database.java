package Webservice.DataBase;

import java.sql.*;

/**
 * @author Keller Thompson
 */
public class Database
{
    private static Connection conexion;  //Objeto que establece la conexion
    private static Statement sentenciaSQL; //Objeto que almacena la sentencia que ejecuta la consulta
    private static ResultSet resultSet; //Objeto que guarda los resultados de la consulta

    private static final String dataBaseName = "bfkbonwrvl7atwiehbto";
    private static final String url_db = "jdbc:mysql://usk3refbtwbe3fdm:ivccxIR52fMqzS8F6gsm@bfkbonwrvl7atwiehbto-mysql.services.clever-cloud.com:3306/bfkbonwrvl7atwiehbto?useSSL=false";
    private static final String user = "usk3refbtwbe3fdm";
    private static final String password = "ivccxIR52fMqzS8F6gsm";

    /**
     * Inicia la conexion con la base de datos.
     * @author Keller Thompson
     */
    public static void conectar()
    {
        try
        {
            System.out.println("Conectando...");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url_db, user, password); // SET GLOBAL time_zone = '-6:00';
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Conexion exitosa");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Termina la conexion con la base de datos.
     * @author Keller Thompson
     */
    public static void cerrarConexion()
    {
        try
        {
            System.out.println("Cerrar Conexion");
            if(resultSet != null) resultSet.close();
            if(sentenciaSQL != null) sentenciaSQL.close();
            if(conexion != null) conexion.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Metodo que inserta nuevos registros en la base de datos.
     * @param tabla : Nombre de la tabla.
     * @param columnas : Nombre de las columnas. Cada columna debe estar separada por ", "
     * @param valores : Valores a ingresar. Cada valor debe estar separada por "', '"
     *                  y en el orden correspondiente a las columnas.
     * Ejemplo Database.insertarEnTabla( "User", "username, password", psUsername + "', '" + psPassword);
     * @author Keller Thompson
     */
    public static void insertarEnTabla(String tabla, String columnas, String valores)
    {
        try
        {
            sentenciaSQL.executeUpdate("INSERT INTO " + dataBaseName + "." + tabla + " (" + columnas+ ") VALUES ('" + valores + "')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo que actualiza un registro especifico.
     * @param psTablas : Nombre de la tabla
     * @param psColumnas : Nombre de la columna
     * @param psValores : Nuevo valor para asignar
     * @param primaryKey : Nombre de la columna del PrimaryKey
     * @param psID : primarykey del registro a actualizar
     * @author Keller Thompson
     * @throws SQLException
     */
    public void actualizarCampo (String psTablas, String psColumnas, String psValores, String primaryKey, String psID) throws SQLException
    {
        try
        {
            sentenciaSQL.executeUpdate("UPDATE " + this.dataBaseName + "." + psTablas + " SET " + psColumnas + " = '" + psValores + "' WHERE (" + primaryKey + "= '" + psID + "')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    /**
     * Metodo que borra un registro especificado por su id
     * @param tabla: Nombre de la tabla donde se encuentra el registro
     * @param primaryKey : Nombre asignado a la primarykey
     * @param idValue : valor del primarykey asignado al registro que desea borrar
     * @author Keller Thompson
     */
    public static void borrarRegistro (String tabla, String primaryKey, String idValue)
    {
        try
        {
            sentenciaSQL.execute("DELETE FROM " + dataBaseName + "." + tabla + " WHERE (" + primaryKey + " = " + idValue + ");");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo con el cual buscar un campo especifico en una tabla y columna especifica
     * @param table : Nombre de la tabla.
     * @param columna : Columna en la que se quiere buscar.
     * @param subcad : subcadena a buscar.
     * @author Keller Thompson
     * @return Verdadero si lo encuentra, o un Falso en caso contrario.
     */
    public static boolean existeEnColumna(String table, String columna, String subcad)
    {
        try
        {
            resultSet = sentenciaSQL.executeQuery("SELECT * FROM " + dataBaseName + "." + table + " WHERE (" + columna + " = " + "'" + subcad + "')");
            resultSet.beforeFirst();
            if(resultSet.next())
                return true;
            else
                return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * Metodo que obtiene un registro especifico.
     * @param celda : nombre de la columna del dato que se desea
     * @param table : nombre de la tabla
     * @param primaryKey : nombre de la columna que se usa para la clausula "where"
     * @param idValue : valor de la primaryKey que se usa en la clausula "where"
     * @return El resultado de la consulta en un String
     * @author Keller Thompson
     */
    public static String getStringAt(String celda, String table, String primaryKey, String idValue)
    {
        try
        {
            resultSet = sentenciaSQL.executeQuery("SELECT " + celda + " FROM " + dataBaseName + "." + table + " WHERE (" + primaryKey + " = " + "'" + idValue + "')");
            resultSet.first();
            return resultSet.getString(1);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static int getIntegerAt(String celda, String table, String primaryKey, String idValue)
    {
        try
        {
            resultSet = sentenciaSQL.executeQuery("SELECT " + celda + " FROM " + dataBaseName + "." + table + " WHERE (" + primaryKey + " = " + "'" + idValue + "')");
            resultSet.first();
            return resultSet.getInt(1);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     * NOTA: La sentencia debe tener la sintaxis correcta para la consulta a realizar
     * Metodo que realiza una consulta especificada.
     * @param psSentencia : La consulta a realizar
     * @author Keller Thompson
     */
    public static void sentenciaQuery(String psSentencia)
    {
        try
        {
            resultSet = sentenciaSQL.executeQuery(psSentencia);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * NOTA: Es necesario haber iniciado una consulta antes con el metodo sentenciaQuery()
     * Metodo que cre una matriz String con los datos del ResultSet actual.
     * @return Una matriz String
     * @author Keller Thompson
     */
    public static String[][] obtenerDatosTabla()
    {
        String [][] tabla = new String[1][1];

        try
        {
            int nColumnas = resultSet.getMetaData().getColumnCount();
            resultSet.last();
            int nFilas = resultSet.getRow();

            tabla = new String[nFilas][nColumnas];

            resultSet.first();

            for(int i = 0; i <= nFilas-1; i++)
            {
                for(int e = 0; e <= nColumnas-1; e++)
                {
                    tabla[i][e] = resultSet.getString(e+1);
                }
                resultSet.next();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return tabla;
    }
}
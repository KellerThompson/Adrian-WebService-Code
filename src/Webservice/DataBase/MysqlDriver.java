package Webservice.DataBase;

import java.sql.*;

public class MysqlDriver
{
    private Connection conection;
    private ResultSet resultSet;

    //private static final String dataBaseName = "bcqabama9eb7jxgrv4n8";
    private static final String url_db = "jdbc:mysql://uw53bw8z2yx7pql9:wQxhfbVtavvCMnk7peJe@bcqabama9eb7jxgrv4n8-mysql.services.clever-cloud.com:3306/bcqabama9eb7jxgrv4n8?useSSL=false";
    private static final String user = "uw53bw8z2yx7pql9";
    private static final String password = "wQxhfbVtavvCMnk7peJe";

    public void conectar()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(url_db, user, password);
            System.out.println("Conexion exitosa");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }

    public Connection getConection() {
        return conection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void cerrarConexion()
    {
        try
        {
            if(resultSet != null) resultSet.close();
            if(conection != null) conection.close();
            System.out.println("Cerrar Conexion");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
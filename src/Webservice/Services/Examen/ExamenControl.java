package Webservice.Services.Examen;

import Webservice.Constant.LinkState;
import Webservice.DataBase.MysqlDriver;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class ExamenControl
{

    public static String examenLink(String titulo)
    {
        String response = LinkState.TO_SEARCH;
        MysqlDriver mysql = new MysqlDriver();

        try
        {
            mysql.conectar();
            String query = "select link from Examen where titulo = ?;";
            PreparedStatement preparedStatement = mysql.getConection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, titulo);
            mysql.setResultSet(preparedStatement.executeQuery());

            if(mysql.getResultSet().next())
            {
                response = mysql.getResultSet().getString(1);
            }
            else
            {
                response = LinkState.TITLE_INVALID;
            }
        }
        catch (Exception ex)
        {
            response = LinkState.ERROR;
        }
        finally
        {
            mysql.cerrarConexion();
            return response;
        }
    }
}

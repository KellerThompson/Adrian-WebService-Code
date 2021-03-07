package Webservice.Services.Usuaio;

import Webservice.DataBase.MysqlDriver;
import Webservice.Utileria.UtilK;

import java.sql.PreparedStatement;
import java.sql.Statement;

public final class UserControl
{
    public static int Aunthentication(String username, String password)
    {
        int response = UserState.TO_VALIDATE;
        MysqlDriver mysql = new MysqlDriver();

        try
        {
            if((UtilK.validString(username) && UtilK.validString(password)))
            {
                mysql.conectar();
                String query = "select username, password from User where username = ?;";
                PreparedStatement preparedStatement = mysql.getConection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, username);
                mysql.setResultSet(preparedStatement.executeQuery());

                if(mysql.getResultSet().next())
                {
                    if(mysql.getResultSet().getString(2).equals(password))
                    {
                        response = UserState.VALID;
                    }
                    else
                    {
                        response = UserState.PASSWORD_INVALID;
                    }
                }
                else
                {
                    response = UserState.USERNAME_INVALID;
                }
            }
            else
            {
                response = UserState.USERNAME_OR_PASSWORD_WRONG_FORMAT;
            }
        }
        catch (Exception ex)
        {
            response = UserState.ERROR;
        }
        finally
        {
            mysql.cerrarConexion();
            return response;
        }
    }
}

package Webservice.Services.Usuaio;

import Webservice.Constant.UserState;
import Webservice.DataBase.MysqlDriver;
import Webservice.Utileria.UtilK;

import java.sql.PreparedStatement;
import java.sql.Statement;

public final class UserControl
{
    public static String Aunthentication(String username, String password)
    {
        int userState = UserState.TO_VALIDATE;
        int id = -1;
        MysqlDriver mysql = new MysqlDriver();

        try
        {
            if((UtilK.validString(username) && UtilK.validString(password)))
            {
                mysql.conectar();
                String query = "select idUser, username, password from User where username = ?;";
                PreparedStatement preparedStatement = mysql.getConection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, username);
                mysql.setResultSet(preparedStatement.executeQuery());

                if(mysql.getResultSet().next())
                {
                    if(mysql.getResultSet().getString(3).equals(password))
                    {
                        userState = UserState.VALID;
                        id = mysql.getResultSet().getInt(1);
                    }
                    else
                    {
                        userState = UserState.PASSWORD_INVALID;
                    }
                }
                else
                {
                    userState = UserState.USERNAME_INVALID;
                }
            }
            else
            {
                userState = UserState.USERNAME_OR_PASSWORD_WRONG_FORMAT;
            }
        }
        catch (Exception ex)
        {
            userState = UserState.ERROR;
        }
        finally
        {
            mysql.cerrarConexion();
            return userState + "," + id;
        }
    }
}

package Webservice.Services.Usuaio;

import Webservice.DataBase.Database;
import Webservice.Utileria.UtilK;
import Webservice.Model.User.User;

public class UserControl
{
    public static int userAunthentication(String username, String password)
    {
        User user = new User(username, password);
        if ((!username.equals("") && !password.equals("")) &&
                (UtilK.validString(username) && UtilK.validString(password)))
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "select User.idUser, User.password from bfkbonwrvl7atwiehbto.User " +
                    "where User.username = '"+username+"';");
            String[][] stringUser = db.obtenerDatosTabla();
            db.cerrarConexion();
            try
            {
                if(password.equals(stringUser[0][1]))
                {
                    user.idUser = Integer.parseInt(stringUser[0][0]);
                }
            }
            catch (Exception ex)
            {
                user = new User(username, password);
            }
        }
        return (user.idUser);
    }
}

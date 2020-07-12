package Webservice.Services.UserService;

import Webservice.DataBase.Database;
import Webservice.Utileria.UtilK;
import Webservice.Core.User.User;

public class UserControl
{
    private static final String userTable = "User";
    private static final String userPrimaryKey = "idUser";
    private static final String usernameColumn = "username";
    private static final String passwordColumn = "password";
    private static final String examenColumn = "examen";

    public static User userAunthentication(String username, String password)
    {
        User user = new User(username, password);
        if
        (
                (user.username != null && user.password != null) &&
                (!user.username.equals("") && !user.password.equals("")) &&
                (UtilK.validString(user.username) && UtilK.validString(user.password))
        )
        {
            Database.conectar();
            Database.sentenciaQuery("SELECT * FROM "+Database.dataBaseName+"."+userTable+" where "+usernameColumn+" = '" + user.username +"';");
            String[][] stringUser = Database.obtenerDatosTabla();
            Database.cerrarConexion();

            try
            {
                if(user.password.equals(stringUser[0][2]))
                {
                    user.idUser = Integer.parseInt(stringUser[0][0]);
                    user.examen = Integer.parseInt(stringUser[0][3]);
                }
            }
            catch (Exception ex)
            {
                user = new User(username, password);
            }
        }
        return user;
    }
}

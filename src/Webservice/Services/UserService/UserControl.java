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

    public static User userAunthentication(String username, String password)
    {
        User user = new User(username, password);
        Database.conectar();
        if
        (
                (user.username != null && user.password != null) &&
                (!user.username.equals("") && !user.password.equals("")) &&
                (UtilK.validString(user.username) && UtilK.validString(user.password)) &&
                Database.existeEnColumna(userTable, usernameColumn, user.username) &&
                user.password.equals(Database.getStringAt(passwordColumn, userTable, usernameColumn, user.username))
        )
        {
            user.idUser = Database.getIntegerAt(userPrimaryKey, userTable, usernameColumn, user.username);
        }
        Database.cerrarConexion();
        System.out.println(user.toString());
        return user;
    }
}

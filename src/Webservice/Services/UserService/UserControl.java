package Webservice.Services.UserService;

import Webservice.DataBase.Database;
import Webservice.Utileria.UtilK;
import Webservice.Core.User.User;

import static Webservice.DataBase.Database.dataBaseName;

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
        if ((!username.equals("") && !password.equals("")) &&
                (UtilK.validString(username) && UtilK.validString(password)))
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "SELECT * FROM "+ dataBaseName +"."+userTable+" " +
                            "where "+usernameColumn+" = '" + username +"';");
            String[][] stringUser = db.obtenerDatosTabla();
            db.cerrarConexion();
            try
            {
                if(password.equals(stringUser[0][3]))
                {
                    user.idUser = Integer.parseInt(stringUser[0][0]);
                    user.examen = Integer.parseInt(stringUser[0][4]);
                }
            }
            catch (Exception ex)
            {
                user = new User(username, password);
            }
        }
        return user;
    }

    public static void setExamenState(String idUser, String examState)
    {
        Database db = new Database();
        db.conectar();
        db.actualizarCampo(userTable, examenColumn, examState, userPrimaryKey, idUser);
        db.cerrarConexion();
    }
}

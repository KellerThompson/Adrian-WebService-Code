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
        if
        (
                (user.username != null && user.password != null) &&
                (!user.username.equals("") && !user.password.equals("")) &&
                (UtilK.validString(user.username) && UtilK.validString(user.password))
        )
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "SELECT * FROM "+ dataBaseName +"."+userTable+" " +
                            "where "+usernameColumn+" = '" + user.username +"';");
            String[][] stringUser = db.obtenerDatosTabla();
            db.cerrarConexion();
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

    public static void setExamenState(String idUser, String examState)
    {
        Database db = new Database();
        db.conectar();
        db.actualizarCampo(userTable, examenColumn, examState, userPrimaryKey, idUser);
        db.cerrarConexion();
    }

    public static void registerUser(String username, String password)
    {
        Database db = new Database();
        db.conectar();
        if(!db.existeEnColumna(userTable, usernameColumn, username))
        {
            db.executeInsert(
                    "insert into "+dataBaseName+"."+userTable+" " +
                            "("+usernameColumn+", "+passwordColumn+", "+examenColumn+") " +
                            "values ('"+username+"', '"+password+"', 0);");
        }
        db.cerrarConexion();
    }
}

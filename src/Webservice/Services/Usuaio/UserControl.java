package Webservice.Services.Usuaio;

import Webservice.DataBase.Database;
import Webservice.Utileria.UtilK;

public final class UserControl
{
    public static String Aunthentication(String username, String password, String examen)
    {
        String response = "";

        if((UtilK.validString(username) && UtilK.validString(password)))
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "select User.idUser, User.username, User.password, Asignacion.estado, Examen.link from User " +
                    "inner join Asignacion on User.idUser = Asignacion.idUser " +
                    "inner join Examen on Asignacion.idExamen = Examen.idExamen " +
                    "where User.username = '"+username+"' " +
                    "and User.password = '"+password+"' " +
                    "and Examen.titulo = '"+examen+"';");
            db.cerrarConexion();
            String[][] resultSet = db.obtenerDatosTabla();
            try
            {
                if(username.equals(resultSet[0][1]) && password.equals(resultSet[0][2]) && resultSet[0][3].equals("0"))
                {
                    response = resultSet[0][0] + "," + resultSet[0][4];
                }
                else
                {
                    response = "-1,no_link";
                }
            }
            catch (Exception ex)
            {
                response = "-1,no_link";
            }
        }
        return response;
    }
}

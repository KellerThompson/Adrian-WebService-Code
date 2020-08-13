package Webservice.Services.Usuaio;

import Webservice.DataBase.Database;
import Webservice.Utileria.UtilK;

public final class UserControl
{
    public static String Aunthentication(String username, String password, String examen)
    {
        String response = "-1,no_link";

        if((UtilK.validString(username) && UtilK.validString(password)))
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "select User.idUser, Asignacion.estado, Examen.link from User " +
                    "inner join Asignacion on User.idUser = Asignacion.idUser " +
                    "inner join Examen on Asignacion.idExamen = Examen.idExamen " +
                    "where User.username = '" + username + "' " +
                    "and User.password = '" + password + "' " +
                    "and Examen.titulo = '" + examen + "';");
            String[][] resultSet = db.obtenerDatosTabla();
            db.cerrarConexion();
            try
            {
                if(resultSet[0][1].equals("0"))
                {
                    response = resultSet[0][0] + "," + resultSet[0][2];
                }
            }
            catch (Exception ex)
            {
                //System.out.println("UserControl: " + ex);
            }
        }
        return response;
    }
}

package Webservice.Services.Asignacion;

import Webservice.DataBase.Database;

public class AsignacionControl
{
    public static int getEstado(int idUser, String tituloExamen)
    {
        int respuesta;
        try
        {

            Database db = new Database();
            db.conectar();
            int idExamen = db.getIntegerAt("idExamen", "Examen", "titulo", tituloExamen);
            String query =
                    "SELECT estado FROM bfkbonwrvl7atwiehbto.Asignacion " +
                            "where Asignacion.idUser = "+idUser+" and Asignacion.idExamen = "+idExamen+";";
            db.sentenciaQuery(query);
            String[][] stringExamen = db.obtenerDatosTabla();
            db.cerrarConexion();
            respuesta = Integer.parseInt(stringExamen[0][0]);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            respuesta = -1;
        }
        return respuesta;
    }
}

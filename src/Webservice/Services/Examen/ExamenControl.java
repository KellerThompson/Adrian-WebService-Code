package Webservice.Services.Examen;

import Webservice.DataBase.Database;

public class ExamenControl
{
    public static void examenFinalizado(int idUser, String tituloExamen)
    {
        Database db = new Database();
        db.conectar();
        String insert =
                "update bfkbonwrvl7atwiehbto.Asignacion set estado = 1 " +
                        "where idUser = "+idUser+" and idExamen = " +
                            "(select Examen.idExamen from bfkbonwrvl7atwiehbto.Examen " +
                            "where Examen.titulo = '"+tituloExamen+"');";
        db.executeInsert(insert);
        db.cerrarConexion();
    }
}

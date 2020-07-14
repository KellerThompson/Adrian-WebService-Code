package Webservice.Services.ResultService;

import Webservice.DataBase.Database;

import static Webservice.DataBase.Database.dataBaseName;

public class ResultControl
{
    private static final String columnas12 = "idUser, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12";
    private static final String columnas16 = "idUser, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16";

    public static void registerResult(int idUser, String materia, String results)
    {
        Database db = new Database();
        db.conectar();
        if(results.split(",").length == 12)
        {
            db.executeInsert(createSentencia(materia, columnas12, idUser + "," + results));
        }
        else
        {
            db.executeInsert(createSentencia(materia, columnas16, idUser + "," + results));
        }
        db.cerrarConexion();
    }

    private static String createSentencia(String materia, String columnas, String values)
    {
        return ("INSERT INTO " + dataBaseName + "." + materia + " (" + columnas+ ") VALUES (" + values + ")");
    }
}

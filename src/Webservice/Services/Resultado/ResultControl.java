package Webservice.Services.Resultado;

import Webservice.DataBase.Database;

import static Webservice.DataBase.Database.dataBaseName;

public class ResultControl
{
    private static final String materiaTable = "Materias";
    private static final String materiaPrimaryKey = "idMaterias";
    private static final String materiaColumn = "Materia";

    private static final String[] materias = new String[]{
            "habilidad_verbal", "espanol",
            "habilidad_matematica", "matematicas",
            "fisica", "quimica", "biologia",
            "historia", "geografia",
            "formacion_civica_etica"
    };

    public static void registerResult(int idUser, String tituloExamen,
                                      String habilidad_verbal, String espanol,
                                      String habilidad_matematica, String matematicas,
                                      String fisica, String quimica, String biologia,
                                      String historia, String geografia, String formacion_civica_etica)
    {
        String[] resultados = new String[]{
                habilidad_verbal, espanol,
                habilidad_matematica, matematicas,
                fisica, quimica, biologia,
                historia, geografia,
                formacion_civica_etica
        };

        Database db = new Database();
        db.conectar();
        int idExamen = db.getIntegerAt("idExamen", "Examen", "titulo", tituloExamen);
        for(int i = 0; i < materias.length; i++)
        {
            int idMateria = db.getIntegerAt(materiaPrimaryKey, materiaTable, materiaColumn, materias[i]);
            String[] result = resultados[i].split(",");
            for(int e = 0; e < result.length; e++)
            {
                db.executeInsert(createSentencia(idUser + "," + idExamen + "," + idMateria + "," + (e + 1) + "," + result[e]));
            }
        }

        String update =
                "update bfkbonwrvl7atwiehbto.Asignacion set estado = 1 " +
                        "where idUser = "+idUser+" and idExamen = " +
                        "(select Examen.idExamen from bfkbonwrvl7atwiehbto.Examen " +
                        "where Examen.titulo = '"+tituloExamen+"');";
        db.executeInsert(update);

        db.cerrarConexion();
    }

    private static String createSentencia(String values)
    {
        return ("INSERT INTO " + dataBaseName + ".Resultados" +
                " (idUser, idExamen,idMateria,numPregunta,resultado) " +
                "VALUES (" + values + ")");
    }
}

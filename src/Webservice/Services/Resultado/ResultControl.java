package Webservice.Services.Resultado;

import Webservice.DataBase.Database;

import static Webservice.DataBase.Database.dataBaseName;

public class ResultControl
{
    private static final String materiaTable = "Materias";
    private static final String materiaPrimaryKey = "idMaterias";
    private static final String materiaColumn = "Materia";

    public static void registerResult(int idUser, int idExamen, String materia, String resultadosString)
    {
        String[] resultados = resultadosString.split(",");

        Database db = new Database();
        db.conectar();
        int idMateria = db.getIntegerAt(materiaPrimaryKey, materiaTable, materiaColumn, materia);
        for(int i = 0; i < resultados.length; i++)
        {
            db.executeInsert(createSentencia(idUser + "," + idExamen + "," + idMateria + "," + (i + 1) + "," + resultados[i]));
        }
        db.cerrarConexion();
    }

    private static final String ResultadosTable = "Resultados";
    private static final String idUserColumn = "idUser";
    private static final String idExamenColumn = "idExamen";
    private static final String idMateriaColumn = "idMateria";
    private static final String numPreguntaColumn = "numPregunta";
    private static final String resultadoColumn = "resultado";

    private static String createSentencia(String values)
    {
        return ("INSERT INTO " + dataBaseName + "." + ResultadosTable +
                " (" + idUserColumn + "," + idExamenColumn + "," + idMateriaColumn + "," + numPreguntaColumn + "," + resultadoColumn + ") " +
                "VALUES (" + values + ")");
    }
}

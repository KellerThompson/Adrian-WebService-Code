package Webservice.Services.Asignacion;

import Webservice.Constant.AsignacionState;
import Webservice.Constant.ExamenState;
import Webservice.DataBase.MysqlDriver;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class AsignacionControl
{
    public static String asignacion(int idUser, String tituloExamen)
    {
        int asignacionState = AsignacionState.TO_VALIDATE;
        int examenState = ExamenState.UNDEFINED;
        int idExamen = -1;
        int idAsigancion = -1;

        MysqlDriver mysql = new MysqlDriver();

        try
        {
            mysql.conectar();
            String query = "select idExamen from Examen where titulo = ?;";
            PreparedStatement preparedStatement = mysql.getConection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tituloExamen);
            mysql.setResultSet(preparedStatement.executeQuery());

            if(mysql.getResultSet().next())
            {
                idExamen = mysql.getResultSet().getInt(1);
                String query2 = "select idAsignacion, estado from Asignacion where (idUser = ? && idExamen = ?);";
                PreparedStatement preparedStatement2 = mysql.getConection().prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                preparedStatement2.setInt(1, idUser);
                preparedStatement2.setInt(2, idExamen);
                mysql.setResultSet(preparedStatement2.executeQuery());

                if(mysql.getResultSet().next())
                {
                    asignacionState = AsignacionState.ASSIGNED;
                    idAsigancion = mysql.getResultSet().getInt(1);
                    if(mysql.getResultSet().getInt(2) == 0)
                    {
                        examenState = ExamenState.UNSOLVED;
                    }
                    else
                    {
                        examenState = ExamenState.SOLVED;
                    }
                }
                else
                {
                    asignacionState = AsignacionState.NOT_ASSIGNED;
                }
            }
            else
            {
                asignacionState = AsignacionState.EXAMEN_INVALID;
            }
        }
        catch (Exception ex)
        {
            asignacionState = AsignacionState.ERROR;
        }
        finally
        {
            mysql.cerrarConexion();
            return asignacionState + "," + examenState + "," + idAsigancion;
        }

    }
}

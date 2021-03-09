package Webservice.Services.Aciertos;

import Webservice.DataBase.MysqlDriver;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;

public class AciertosControl
{
    public static void aciertos(int idAsignacion, int aciertos)
    {
        MysqlDriver mysql = new MysqlDriver();
        try
        {
            mysql.conectar();
            String insert = "insert into Aciertos (idAsignacion, aciertos, fechaRegistro) values(?, ?, ?);";
            PreparedStatement preparedStatement = mysql.getConection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idAsignacion);
            preparedStatement.setInt(2, aciertos);
            preparedStatement.setTimestamp(3, Timestamp.from(Instant.now()));
            preparedStatement.executeUpdate();

            String update = "update Asignacion set estado = ? where idAsignacion = ?;";
            PreparedStatement preparedStatement2 = mysql.getConection().prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(2, idAsignacion);
            preparedStatement2.executeUpdate();
        }
        catch (Exception ex)
        {

        }
        finally
        {
            mysql.cerrarConexion();
        }
    }
}

package Webservice.Services.Resultado;

import javax.ws.rs.*;

@Path("/Result")
public class ResultService
{
    @POST
    @Path("{idUser}/{tituloExamen}/{materia}/{resultados}")
    public void setResult(@PathParam("idUser") int idUser,
                          @PathParam("tituloExamen") String tituloExamen,
                          @PathParam("materia") String materia,
                          @PathParam("resultados") String resultados)
    {
        ResultControl.registerResult(idUser, tituloExamen, materia, resultados);
    }
}

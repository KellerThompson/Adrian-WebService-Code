package Webservice.Services.Examen;

import javax.ws.rs.*;

@Path("/Examen")
public class ExamenService
{
    @POST
    @Path("{idUser}/{tituloExamen}")
    public void ExamenService(@PathParam("idUser") int idUser, @PathParam("tituloExamen") String tituloExamen)
    {
        ExamenControl.examenFinalizado(idUser, tituloExamen);
    }
}

package Webservice.Services.Examen;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Examen")
public class ExamenService
{
    @GET
    @Path("{tituloExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getExamenLink(@PathParam("tituloExamen") String tituloExamen)
    {
        return ExamenControl.getLink(tituloExamen);
    }

    @POST
    @Path("{idUser}/{tituloExamen}")
    public void setExamenFinish(@PathParam("idUser") int idUser, @PathParam("tituloExamen") String tituloExamen)
    {
        ExamenControl.setExamenFinish(idUser, tituloExamen);
    }
}

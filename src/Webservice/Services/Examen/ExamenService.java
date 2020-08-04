package Webservice.Services.Examen;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Examen")
public class ExamenService
{
    @GET
    @Path("{idExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getExamenLink(@PathParam("idExamen") int idExamen)
    {
        return ExamenControl.getLink(idExamen);
    }

    @POST
    @Path("{idUser}/{idExamen}")
    public void setExamenFinish(@PathParam("idUser") int idUser, @PathParam("idExamen") int idExamen)
    {
        ExamenControl.setExamenFinish(idUser, idExamen);
    }
}

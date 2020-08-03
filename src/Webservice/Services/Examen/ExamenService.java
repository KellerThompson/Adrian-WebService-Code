package Webservice.Services.Examen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}

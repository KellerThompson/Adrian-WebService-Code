package Webservice.Services.Examen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ExamenService")
public class ExamenService
{
    @GET
    @Path("{tituloExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ExamenLink(@PathParam("tituloExamen") String tituloExamen)
    {
        return ExamenControl.examenLink(tituloExamen);
    }
}

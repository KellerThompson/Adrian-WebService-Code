package Webservice.Services.Asignacion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AsignacionService")
public class AsignacionService
{
    @GET
    @Path("{idUser}/{examentitulo}")
    @Produces(MediaType.TEXT_PLAIN)
    public String asignacion(@PathParam("idUser") int idUser, @PathParam("examentitulo") String tituloExamen)
    {
        return AsignacionControl.asignacion(idUser, tituloExamen);
    }
}

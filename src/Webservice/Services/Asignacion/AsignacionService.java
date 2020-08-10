package Webservice.Services.Asignacion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Asignacion")
public class AsignacionService
{
    @GET
    @Path("{idUser}/{TituloExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getIdCompra(@PathParam("idUser") int idUser, @PathParam("TituloExamen") String TituloExamen)
    {
        return AsignacionControl.getEstado(idUser, TituloExamen);
    }
}
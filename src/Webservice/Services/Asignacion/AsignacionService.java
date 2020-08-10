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
    @Path("{idUser}/{tituloExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getIdCompra(@PathParam("idUser") int idUser, @PathParam("tituloExamen") String tituloExamen)
    {
        return AsignacionControl.getEstado(idUser, tituloExamen);
    }
}
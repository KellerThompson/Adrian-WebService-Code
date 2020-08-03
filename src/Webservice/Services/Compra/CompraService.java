package Webservice.Services.Compra;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Compra")
public class CompraService
{
    @GET
    @Path("{idUser}/{idExamen}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getIdCompra(@PathParam("idUser") int idUser, @PathParam("idExamen") int idExamen)
    {
        return CompraControl.isValid(idUser, idExamen);
    }
}
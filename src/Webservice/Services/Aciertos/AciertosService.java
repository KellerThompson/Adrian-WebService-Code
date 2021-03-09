package Webservice.Services.Aciertos;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/AciertosService")
public class AciertosService
{
    @POST
    @Path("{idAsignacion}/{aciertos}")
    public void aciertos(@PathParam("idAsignacion") int idAsignacion, @PathParam("aciertos") int aciertos)
    {
        AciertosControl.aciertos(idAsignacion, aciertos);
    }
}

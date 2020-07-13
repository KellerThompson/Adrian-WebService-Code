package Webservice.Services.ResultService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Result")
public class ResultService
{
    @POST
    @Path("{idUser}/{materia}/{resultados}")
    public void setResult(@PathParam("idUser") int idUser,
                            @PathParam("materia") String materia,
                            @PathParam("resultados") String resultados)
    {
        ResultControl.registerResult(idUser, materia, resultados);
    }
}

package Webservice.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Inicio
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String saludo()
    {
        return "WebService 2.0";
    }
}

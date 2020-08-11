package Webservice.Services.Usuaio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService
{
    @GET
    @Path("{username}/{password}/{Examen}")
    @Produces(MediaType.TEXT_PLAIN)
    public String UserAunthentication(
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("Examen") String Examen)
    {
        return UserControl.Aunthentication(username, password, Examen);
    }
}

package Webservice.Services.Usuaio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService
{
    @GET
    @Path("{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public int UserAunthentication(@PathParam("username") String username, @PathParam("password") String password)
    {
        return UserControl.Aunthentication(username, password);
    }
}

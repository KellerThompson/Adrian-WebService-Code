package Webservice.Services.UserService;

import Webservice.Core.User.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService
{
    @GET
    @Path("{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserAunthentication(@PathParam("username") String username, @PathParam("password") String password)
    {
        User user = UserControl.userAunthentication(username, password);
        return (user.idUser + "," + user.examen);
    }

    @POST
    @Path("{username}/{password}")
    public void portRegisterUser(@PathParam("username") String username, @PathParam("password") String password)
    {
        UserControl.registerUser(username, password);
    }
}

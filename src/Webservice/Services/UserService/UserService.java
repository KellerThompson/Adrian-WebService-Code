package Webservice.Services.UserService;

import Webservice.Core.User.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService
{
    @GET
    @Path("{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage(@PathParam("username") String username, @PathParam("password") String password)
    {
        User user = UserControl.userAunthentication(username, password);
        System.out.println(user);
        return (user.idUser + "," + user.examen);
    }
}

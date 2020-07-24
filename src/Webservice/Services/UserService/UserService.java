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
    public String UserAunthentication(@PathParam("username") String username, @PathParam("password") String password)
    {
        User user = UserControl.userAunthentication(username, password);
        return (user.idUser + "," + user.examen);
    }

    @POST
    @Path("Exam/{idUser}/{examState}")
    public void UserFinishExam(@PathParam("idUser") String idUser, @PathParam("examState") String examState)
    {
        UserControl.setExamenState(idUser, examState);
    }
}

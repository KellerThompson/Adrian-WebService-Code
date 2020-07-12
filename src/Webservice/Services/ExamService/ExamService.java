package Webservice.Services.ExamService;

import Webservice.Services.UserService.UserControl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Exam")
public class ExamService
{
    @POST
    @Path("{idUser}/{examState}")
    public void setUserExameState(@PathParam("idUser") String idUser, @PathParam("examState") String examState)
    {
        UserControl.setExamenState(idUser, examState);
    }
}

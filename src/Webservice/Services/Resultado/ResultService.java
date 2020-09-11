package Webservice.Services.Resultado;

import javax.ws.rs.*;

@Path("/Result")
public class ResultService
{
    @POST
    @Path("{idUser}/{tituloExamen}" +
            "/{habilidad_verbal}/{espanol}/{habilidad_matematica}/{matematicas}" +
            "/{fisica}/{quimica}/{biologia}" +
            "/{historia}/{geografia}/{formacion_civica_etica}")
    public void setResult(@PathParam("idUser") int idUser,
                          @PathParam("tituloExamen") String tituloExamen,
                          @PathParam("habilidad_verbal") String habilidad_verbal,
                          @PathParam("espanol") String espanol,
                          @PathParam("habilidad_matematica") String habilidad_matematica,
                          @PathParam("matematicas") String matematicas,
                          @PathParam("fisica") String fisica,
                          @PathParam("quimica") String quimica,
                          @PathParam("biologia") String biologia,
                          @PathParam("historia") String historia,
                          @PathParam("geografia") String geografia,
                          @PathParam("formacion_civica_etica") String formacion_civica_etica)
    {
        ResultControl.registerResult(idUser, tituloExamen,
                habilidad_verbal, espanol, habilidad_matematica, matematicas,
                fisica, quimica, biologia,
                historia, geografia, formacion_civica_etica);
    }
}

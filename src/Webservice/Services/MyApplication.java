package Webservice.Services;

import Webservice.Services.Aciertos.AciertosService;
import Webservice.Services.Asignacion.AsignacionService;
import Webservice.Services.Examen.ExamenService;
import Webservice.Services.Resultado.ResultService;
import Webservice.Services.Usuaio.UserService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application
{
    @Override
    public Set<Class<?>> getClasses()
    {
        HashSet hashSet = new HashSet<Class<?>>();
        hashSet.add(UserService.class);
        hashSet.add(AsignacionService.class);
        hashSet.add(ExamenService.class);
        hashSet.add(AciertosService.class);
        //hashSet.add(ResultService.class);
        hashSet.add(Inicio.class);
        return hashSet;
    }
}
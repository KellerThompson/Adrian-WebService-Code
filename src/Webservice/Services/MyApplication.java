package Webservice.Services;

import Webservice.Services.ExamService.ExamService;
import Webservice.Services.ResultService.ResultService;
import Webservice.Services.UserService.UserService;

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
        hashSet.add(ExamService.class);
        hashSet.add(ResultService.class);
        return hashSet;
    }
}
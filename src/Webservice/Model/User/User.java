package Webservice.Model.User;

import java.sql.Date;

public class User
{
    public int idUser;
    public int idPersona;
    public String username;
    public String password;
    public Date fechaRegistro;

    public User()
    {

    }

    public User(String username, String password)
    {
        this.idUser = -1;
        this.idPersona = -1;
        this.username = username;
        this.password = password;
    }

    public boolean isValid()
    {
        if(idUser > 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

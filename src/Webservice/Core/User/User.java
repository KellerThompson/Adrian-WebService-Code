package Webservice.Core.User;

public class User
{
    public String username;
    public String password;
    public int idUser;
    public int examen;

    public User()
    {

    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.idUser = -1;
        this.examen = -1;
    }

    public boolean isValid()
    {
        if(idUser > 0)
            return true;
        else
            return false;
    }

    public boolean examen()
    {
        if(examen > 0)
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
                ", examen='" + examen + '\'' +
                '}';
    }
}

package Validators;
import Movies.MovieSource;

public class Validator
{
    public static String error;

    public static void valremove(String name)
    {
        if(name.equals("")) error="Please enter a name!";
        else if(name.length()>30) error="Enter a name with less than 30 characters!";
        else if(MovieSource.exists(name)) error="No such movie!";
        else error="no";
    }

    public static void valadd(String name, String director, String genre, String year)
    {
        if(name.equals("") || director.equals("") || genre.equals("") || year.equals("")) error="Please enter in all of the spaces!";
        else if(name.length()>30 || director.length()>30 || genre.length()>30 || year.length()>30) error="Enter values with less than 30 characters!";
        else if(!MovieSource.exists(name)) error="Such movie already exists in the list!";
        else error="no";
    }
}
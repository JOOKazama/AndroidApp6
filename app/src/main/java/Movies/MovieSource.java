package Movies;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieSource
{
    static ArrayList<Movie>m=new ArrayList<>();

    public static ArrayList<Movie>list() { return m; }

    public static void delete(String name)
    {
        Iterator<Movie>itr=m.iterator();
        while (itr.hasNext())
        {
            Movie movie=itr.next();
            if (movie.getName().equals(name)) { itr.remove(); }
        }
    }

    public static boolean exists(String name)
    {
        int count=0;
        for(Movie movie:m)
        { if(!movie.getName().equals(name)) count++; }
        return count==m.size();
    }

    public static void add(Movie movie) { m.add(movie); }
}
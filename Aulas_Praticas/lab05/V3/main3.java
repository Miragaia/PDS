import java.util.ArrayList;
import java.util.List;

public class main3 {
    public static void main(String[] args) {
        Movie.Builder builder = new Movie.Builder("The Matrix: Reloaded", 1999);

        List<Place> location = new ArrayList<Place>();
        location.add(new Place("San Francisco"));
        location.add(new Place("Los Angeles"));
        location.add(new Place("New York"));

        builder.director(new Person("Lana", "Wachowski"));
        builder.writer(new Person("Lilly", "Wachowski"));
        builder.locations(location);

        List<String> languages = new ArrayList<String>();
        languages.add("English");
        languages.add("Japanese");
        languages.add("French");

        builder.series("The Matrix");

        List<Person> cast = new ArrayList<Person>();
        cast.add(new Person("Keanu", "Reeves"));
        cast.add(new Person("Laurence", "Fishburne"));
        cast.add(new Person("Carrie-Anne", "Moss"));
        builder.cast(cast);

        List<String> genres = new ArrayList<String>();
        genres.add("Action");
        genres.add("Adventure");
        genres.add("Sci-Fi");
        builder.genres(genres);

        builder.isNetflix(true);
        builder.isIndependent(false);
        builder.isTelevision(false);

        Movie movie = builder.build();

        System.out.println(movie);
    }
}

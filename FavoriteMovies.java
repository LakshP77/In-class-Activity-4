import java.util.ArrayList;

public class FavoriteMovies {
    public static void main(String[] args) {

        // 1. Implement an ArrayList of type String
        ArrayList<String> movies = new ArrayList<>();

        // 2. Add at least 5 movie titles
        movies.add("Inception");
        movies.add("Interstellar");
        movies.add("The Dark Knight");
        movies.add("Avengers: Endgame");
        movies.add("Parasite");

        // 3. Print all movie names and total number of movies
        System.out.println("Favorite Movies List:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
        System.out.println("Total movies: " + movies.size());
        // Instrument used: a **for-each loop** to print elements and the `.size()` method to count them.

        // 4. Remove one movie by name
        movies.remove("Parasite"); 
        // Method used: `.remove(Object o)`

        // 5. Search for a movie by its name
        String searchTitle = "Inception";
        if (movies.contains(searchTitle)) {
            System.out.println("\nFound the movie: " + searchTitle);
        } else {
            System.out.println("\nMovie not found: " + searchTitle);
        }
        // Method used: `.contains(Object o)`

        // 6. Replace one movie by a new title
        int index = movies.indexOf("The Dark Knight");
        if (index != -1) {
            movies.set(index, "The Batman");
        }
        // Method used: `.set(int index, E element)`

        // 7. Display the updated list
        System.out.println("\n🎥 Updated Movie List:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }

        // 8. Clear the list and display again
        movies.clear(); // Method used: `.clear()`
        System.out.println("\n🗑️ After clearing the list: " + movies);
    }
}

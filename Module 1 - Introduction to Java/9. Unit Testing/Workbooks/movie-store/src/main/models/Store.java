package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

    public boolean contains(Movie movie) {
        return this.movies.contains(movie);
    }

    public void sellMovie(String nameMovie) {

//        for (int i = 0; i < this.movies.size(); i++) {
//            if(this.movies.get(i).getName().equals(nameMovie)){
//                this.movies.remove(i);
//            }
//        }

//        this.movies.removeIf((movie) -> {
//            return movie.getName().equals(nameMovie);
//        });

        if(this.movies.get(getMovieIndex(nameMovie)).isAvailable()){
            this.movies.removeIf((movie) ->  movie.getName().equals(nameMovie));
        }else{
            throw new IllegalStateException("Cannot sell rented movie");
        }



    }

    public void rentAMovie(String nameMovie) {

            this.movies.get(getMovieIndex(nameMovie)).setAvailable(false);
    }

    /**
     * Function name: getMovieIndex
     * @param name (String)
     * @return (int)
     *
     * Inside the function:
     *     1. returns index if it finds a movie.
     *     2. returns -1000 otherwise.
     *
     */

    public int getMovieIndex(String name){

//        for (int i = 0; i < this.movies.size(); i++) {
//            if (this.movies.get(i).getName().equals(name)) {
//                return i;
//            }
//        }
//
//        return -1000;

        return IntStream.range(0,this.movies.size())
                .filter( (i) -> this.movies.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1000);

    }

    public void returnAMovie(String nameMovie) {

        this.movies.get(getMovieIndex(nameMovie)).setAvailable(true);
    }
}

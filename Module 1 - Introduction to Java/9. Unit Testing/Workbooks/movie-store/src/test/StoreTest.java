package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.models.Movie;
import src.main.models.Store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StoreTest {

    Store store;

    @Before
    public void setup(){
        store = new Store();
        store.addMovie(new Movie("The Batman", "Blue-Ray", 9.2));
        store.addMovie(new Movie("Aquaman", "Blue-Ray", 8.7));
    }

    // Adding a movie
    // Test if the store contains the movie
    // after it's added
    @Test
    public void addANewMovieTest(){
        assertTrue(store.contains(new Movie("The Batman","Blue-Ray",9.2)));
    }


    // Selling the movie
    // test if the movie gets removed after being sold.
    // Test for an illegalStateException for selling a rented movie.
    @Test
    public void sellMovieTest(){
        store.sellMovie("Aquaman");

        assertFalse(store.contains(new Movie("Aquaman", "Blue-Ray", 8.7)));

    }
    // Renter the movie
    // test if the movie become rented

    @Test
    public void rentMovieTest(){

        store.rentAMovie("Aquaman");

        assertFalse(this.store.getMovie(1).isAvailable());


    }

    // Returning a movie
    // test if the is avaliable again
    /**
     * Function name: returnMovie
     * @param name (String)
     *
     * Inside the function:
     *    //nothing
     */
    @Test
    public void returnMovieTest(){

        store.rentAMovie("Aquaman");
        store.returnAMovie("Aquaman");
        assertTrue(this.store.getMovie(1).isAvailable());

    }


    /// Movie not in stock
    @Test(expected = IllegalStateException.class)
    public void movieNotInStock(){

        store.rentAMovie("The Batman");
        store.sellMovie("The Batman");

    }

}

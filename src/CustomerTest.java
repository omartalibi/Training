import kata.movierental.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static kata.movierental.Customer.customer;
import static kata.movierental.DayRented.dayRented;
import static kata.movierental.Movie.movie;
import static kata.movierental.Name.name;
import static kata.movierental.Rental.rental;

public class CustomerTest {
    //TODO make test for price breaks in code.

    @Test
    public void customer_without_rental() throws Exception {
        Customer cc =  customer(name("toto"));
        Assert.assertEquals(
                "Rental Record for toto\n" +
                        "Amount owed is 0.0\n" +
                        "You earned 0 frequent renter points",
                cc.statement());
    }

    @Test
    public void customer_with_one_rental() throws Exception {
        Movie movie = movie(name("le diner de cons"), MovieCategorie.regular);
        Customer cc = customer(name("toto"), rental(movie, dayRented(10)));

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points", cc.statement());
    }

    @Test
    public void customer_with_no_valid_rental_days() throws Exception {
        Movie movie = movie(name("le diner de cons"), MovieCategorie.regular);
        Customer cc = customer(name("toto"), rental(movie, dayRented(-999)));

        Assert.assertEquals("No valid daysRented!", cc.statement());
    }

    //By CodePrice
    @Test
    public void customer_with_priceCode_children() throws Exception {
        Movie movie = movie(name("le diner de cons"), MovieCategorie.children);
        Customer cc = customer(name("toto"), rental(movie, dayRented(4)));

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", cc.statement());

    }

    @Test
    public void customer_with_priceCode_regular() throws Exception {
        Movie movie = movie(name("le diner de cons"), MovieCategorie.regular);
        Customer cc = customer(name("toto"), rental(movie, dayRented(4)));

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points", cc.statement());
    }

    @Test
    public void customer_with_priceCode_new_release() throws Exception {
        Movie movie =  movie(name("le diner de cons"), MovieCategorie.new_release);
        Customer cc = customer(name("toto"), rental(movie, new DayRented(4)));

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points", cc.statement());
    }


}

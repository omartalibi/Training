import kata.movierental.Customer;
import kata.movierental.Movie;
import kata.movierental.Rental;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    //TODO make test for price breaks in code.

    @Test
    public void customer_without_rental() {
        Customer cc = new Customer("toto");
        Assert.assertEquals(
                "Rental Record for toto\n" +
                        "Amount owed is 0.0\n" +
                        "You earned 0 frequent renter points",
                cc.statement());
    }

    @Test
    public void customer_with_one_rental(){
        Movie movie = new Movie("le diner de cons", 0);
        Rental rental = new Rental(movie, 10);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points", cc.statement());
    }

    @Test
    public void customer_with_no_valid_rental_days(){
        Movie movie = new Movie("le diner de cons", 0);
        Rental rental = new Rental(movie, -999);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("No valid daysRented!", cc.statement());
    }

    @Test
    public void customer_with_no_valid_movieCodePrice(){
        Movie movie = new Movie("le diner de cons", -999);
        Rental rental = new Rental(movie, 4);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("No valid priceCode!", cc.statement());
    }


    //By CodePrice
    @Test
    public void customer_with_priceCode_children(){
        Movie movie = new Movie("le diner de cons", 2);
        Rental rental = new Rental(movie, 4);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", cc.statement());
    }

    @Test
    public void customer_with_priceCode_regular(){
        Movie movie = new Movie("le diner de cons", 0);
        Rental rental = new Rental(movie, 4);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points", cc.statement());
    }

    @Test
    public void customer_with_priceCode_new_release(){
        Movie movie = new Movie("le diner de cons", 1);
        Rental rental = new Rental(movie, 4);
        Customer cc = new Customer("toto");
        cc.addRental(rental);

        Assert.assertEquals("Rental Record for toto\n" +
                "\tle diner de cons\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points", cc.statement());
    }

}

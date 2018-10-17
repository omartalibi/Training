package kata.movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private DayRented _daysRented;


    public static Rental rental(final Movie movie, final DayRented daysRented) {
        Rental rental = new Rental(movie, daysRented);
        return rental;
    }

    public Rental(Movie movie, DayRented daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented.getDayRented();
    }

    public String getTitle() {
        return _movie.getTitle();
    }

    public Movie getMovie() {
        return _movie;
    }

    public double charge() {
        return _movie.getMovieCategories().chargeFor(getDaysRented());
    }

    public int frequentPoints(){
        return _movie.getMovieCategories().frequentPoints(getDaysRented());

    }

}
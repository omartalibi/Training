package kata.movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private DayRented _daysRented;

    public Rental(Movie movie, DayRented daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented.getDayRented();
    }

    public Movie getMovie() {
        return _movie;
    }

    public double MovieRentPrice() throws Exception {
        double thisAmount = _movie.getMovieInitialPrice();

        switch (this._movie.getMovieCategorie()) {
            case regular:
                if (this.getDaysRented() > 2)
                    thisAmount += (this.getDaysRented() - 2) * 1.5;
                break;
            case new_release:
                thisAmount += this.getDaysRented() * 3;
                break;
            case children:
                if (this.getDaysRented() > 3)
                    thisAmount += (this.getDaysRented() - 3) * 1.5;
                break;
        }

        return thisAmount;
    }
}

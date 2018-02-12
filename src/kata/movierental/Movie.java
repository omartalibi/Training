package kata.movierental;

import kata.fizzbuzz.FizzBuzzOpenClosed;

public class Movie {

    private String _title;
    private MovieCategorie movieCategorie;

    public static Movie movie(Name name, MovieCategorie movieCategorie){
        Movie movie = new Movie(name, movieCategorie);
        return movie;
    }

    public Movie(Name name, MovieCategorie movieCategorie) {
        _title = name.toString();
        this.movieCategorie = movieCategorie;
    }

    public MovieCategorie getMovieCategorie(){
        return movieCategorie;
    }

    public double getMovieInitialPrice()  {
        for (final MovieCategorie movieCategorie : MovieCategorie.values()) {
            if (movieCategorie == this.movieCategorie) {
                return movieCategorie.getMoviePrice();
            }
        }
        return 0;
    }

    public double chargeFor(int dayRented)  {
        //return getMovieCategorie().chargeFor(dayRented);
        double thisAmount = getMovieInitialPrice();

        switch (this.getMovieCategorie()) {
            case regular:
                if (dayRented > 2)
                    thisAmount += (dayRented - 2) * 1.5;
                break;
            case new_release:
                thisAmount += dayRented * 3;
                break;
            case children:
                if (dayRented > 3)
                    thisAmount += (dayRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public String getTitle() {
        return _title;
    }
}
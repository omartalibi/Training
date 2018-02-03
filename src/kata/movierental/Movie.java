package kata.movierental;

import kata.fizzbuzz.FizzBuzzOpenClosed;

public class Movie {

    private String _title;
    private MovieCategorie movieCategorie;

    public Movie(Name name, MovieCategorie movieCategorie) {
        _title = name.toString();
        this.movieCategorie = movieCategorie;
    }

    public MovieCategorie getMovieCategorie(){
        return movieCategorie;
    }

    public double getMovieInitialPrice() throws Exception {
        for (final MovieCategorie movieCategorie : MovieCategorie.values()) {
            if (movieCategorie == this.movieCategorie) {
                return movieCategorie.getMoviePrice();
            }
        }


        throw new Exception("Error");
    }

    public String getTitle() {
        return _title;
    }
}
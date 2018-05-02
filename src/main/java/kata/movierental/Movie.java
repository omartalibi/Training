package kata.movierental;

public class Movie {

    private String _title;
    private MovieCategories movieCategories;

    public static Movie movie(Name name, MovieCategories movieCategories){
        Movie movie = new Movie(name, movieCategories);
        return movie;
    }

    public Movie(Name name, MovieCategories movieCategories) {
        _title = name.toString();
        this.movieCategories = movieCategories;
    }

    public MovieCategories getMovieCategories(){
        return movieCategories;
    }

    public double getMovieInitialPrice()  {
        for (final MovieCategories movieCategories : MovieCategories.values()) {
            if (movieCategories == this.movieCategories) {
                return movieCategories.getMoviePrice();
            }
        }
        return 0;
    }

    public double chargeFor(int dayRented)  {
        //return getMovieCategorie().chargeFor(dayRented);
        double thisAmount = getMovieInitialPrice();

        switch (this.getMovieCategories()) {
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
package kata.movierental;

public class DayRented {

    private int dayrented;

    public static DayRented dayRented(final int dayrented){

        DayRented dayRented = new DayRented(dayrented);

        return dayRented;
    }
    public DayRented(int dayrented){
        this.dayrented = dayrented;
    }

    //TODO GETTER

    public int getDayRented(){
        return dayrented;
    }
}

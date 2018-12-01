package movierental;

public enum MovieCategories {
    children(1.5) {
        public double chargeFor(int dayRented) {
            double thisAmount = 1.5;
            if (dayRented > 2) {
                thisAmount += (dayRented - 2) * 1.5;
            }
            return thisAmount;
        }

        public int frequentPoints(int dayRented) {
            return 1;
        }
    },
    regular(2) {
        public double chargeFor(int dayRented) {
            return 0;
        }

        public int frequentPoints(int dayRented) {
            return 1;
        }
    },
    new_release(0) {
        public double chargeFor(int dayRented) {
            return 0;
        }

        public int frequentPoints(int dayRented) {
            return dayRented > 1 ? 2 : 1;
        }
    };


    private double price;

    MovieCategories(double price) {
        this.price = price;
    }

    public double getMoviePrice() {
        return price;
    }

    public abstract double chargeFor(int dayRented);

    public abstract int frequentPoints(int dayRented);
}




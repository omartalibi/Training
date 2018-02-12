package kata.movierental;

public enum MovieCategorie {
        children(1.5) {
            public double chargeFor(int dayRented) {
                double thisAmount = 1.5;
                if (dayRented > 2) {
                    thisAmount += (dayRented - 2) * 1.5;
                }
                return thisAmount;
            }

            public int frequentPoints(int dayRented){
                //A revoir
                int frequentRenterPoints = 0;
                frequentRenterPoints++;

                return frequentRenterPoints;
            }
        },
        regular(2) {
            public double chargeFor(int dayRented) {
                return 0;
            }

            public int frequentPoints(int dayRented){
                //A revoir
                int frequentRenterPoints = 0;
                frequentRenterPoints++;

                return frequentRenterPoints;
            }
        },
        new_release(0) {
            public double chargeFor(int dayRented) {
                return 0;
            }
            public int frequentPoints(int dayRented){
                //A revoir
                int frequentRenterPoints = 0;
                frequentRenterPoints++;

                if (dayRented > 1)
                    frequentRenterPoints++;

                return frequentRenterPoints;

            }
        };


        private double price;

        MovieCategorie(double price){
            this.price = price;
    }

        public double getMoviePrice(){
            return price;
        }

        public abstract double chargeFor(int dayRented);

        public abstract  int frequentPoints(int dayRented);
}




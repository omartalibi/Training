package kata.movierental;

public enum MovieCategorie {
        children(1.5),
        regular(2),
        new_release(0);


        private double price;

        MovieCategorie(double price){
            this.price = price;
    }

        public double getMoviePrice(){
            return price;
        }
}




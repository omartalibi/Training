package kata.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Name _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public static Customer customer(final Name name, final Rental... rentals) {
        Customer customer = new Customer(name);
        for (Rental rental : rentals) {
            customer.addRental(rental);
        }
        return customer;
    }


    public Customer(Name name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public Name getName() {
        return _name;
    }

    public String statement() throws Exception {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {
            result += "\t" + rental.getTitle() + "\t" + String.valueOf(rental.charge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints = rental.frequentPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        return _rentals.stream().mapToDouble(Rental::charge).sum();
    }
}

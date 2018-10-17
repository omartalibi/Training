package projet.typage;

import projet.exception.IllegalFormatException;


public class Reference {
    private String reference;

    public static Reference Reference(final String value) throws IllegalFormatException {

        if(value.matches("^REF[0-9]{1,}"))
            return new Reference(value);


        throw new IllegalFormatException("The reference should have REFXXX format. X is a number");


    }

    public Reference(String reference){
        this.reference = reference;
    }

    public String getReferenceValue() {
        return reference;
    }

    @Override
    public String toString() {
        return reference;
    }


}

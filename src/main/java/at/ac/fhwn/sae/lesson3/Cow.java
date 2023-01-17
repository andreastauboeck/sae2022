package at.ac.fhwn.sae.lesson3;


public class Cow extends Animal {
    private static int counter = 0;
    private int id;

    public Cow(String name) {
        super();
        id = ++counter;
    }


//    public String getId() {
//        return "C"+id;
//    }

    @Override
    public String getID() {
        return null;
    }
}

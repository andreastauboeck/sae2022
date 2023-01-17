package at.ac.fhwn.sae.lesson3;

public abstract class Animal {
    protected static final String DEFAULT_ID = "0";

    protected String name;

//    public Animal(String name){
//        this.name = name;
//    }

    public abstract String getID();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

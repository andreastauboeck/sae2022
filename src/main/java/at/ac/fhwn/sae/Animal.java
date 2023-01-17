package at.ac.fhwn.sae;

abstract class Animal{
    private String name;
    public Animal(String name){this. name = name;}
    public abstract String getId();

    public String getName(){
        return name;
    }
}


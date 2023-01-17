package at.ac.fhwn.sae.lesson3;

public enum AnimalKind {
    COW(Cow.class),
    PIG(Pig.class),
    HORSE(Horse.class),
    CHICKEN(Chicken.class);

    private final Class<? extends Animal> animalClass;

    AnimalKind(Class<? extends Animal> animalClass) {
        this.animalClass = animalClass;
    }

    public Class<? extends Animal> getAnimalClass(){
        return animalClass;
    }
}

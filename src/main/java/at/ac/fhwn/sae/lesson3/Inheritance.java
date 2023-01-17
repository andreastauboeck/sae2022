package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inheritance {

    public static void main(String[] args) {
        Dog dog = new Dog("Rex");
        Dog noNameDog = new Dog();
        dog.setName("Hugo");
        System.out.println(dog.getName().charAt(0));
        System.out.println(noNameDog.getName());
        dog.bark();
        System.out.println(Dog.getCount() + " dogs created");

        Cat cat = new Cat();
        System.out.println(cat.getName());

        List<Animal> list = new ArrayList<>();
        list.add(dog);
        list.add(noNameDog);
        list.add(cat);


        Dog anoterDog = new Dog("Dolly");
        list.add(anoterDog);

//        for(int i = 0; i<list.size();i++){
//            System.out.println(list.get(i).name);
//        }
        for (Animal animal : list) {
            System.out.println(animal.name);
            if (animal instanceof Dog) {
                ((Dog) animal).bark();
            }
        }

        Person p = buildPerson(42, "Karl");

    }

    static Person buildPerson(int number, String name) {
        Person person = new Person(number, name);
        return person;
    }

//    static void printAniamls(List<Animal> animals, AnimalKind animalKind) {
//        List<Animal> animalOfKind = getAnimalKindList(animalKind);
//        if (animalKind == AnimalKind.COW) {
//            List<Cow> cows = getAnimalKindList()
//
//        }
//    }

    private static List<Animal> getAnimalKindList(List<Animal> animals, AnimalKind animalKind) {
        return animals.stream().filter(animal -> animalKind.getAnimalClass().isInstance(animal)).collect(Collectors.toList());
    }
}

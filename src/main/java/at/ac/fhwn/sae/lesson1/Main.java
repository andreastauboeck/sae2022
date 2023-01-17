package at.ac.fhwn.sae.lesson1;


import at.ac.fhwn.sae.lesson3.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int number = 2;//this is a comment

        System.out.println(number);

        int constantVariable = 1;

        constantVariable = 2;

        boolean result = !(number != constantVariable);

        System.out.println(result);

        if(number>2){
            System.out.println("number " + number + " is bigger than 2");
        }else {
            System.out.println("number " + number + " is smaller or equal 2");
        }

        double value = 56.32645734557658;

        System.out.println(String.format("value is %f %s %d",value, "Test", number));

        Scanner in = new Scanner(System.in);
        System.out.print("Enter something:");
        String input = in.next();

        System.out.println("You entered " + input);

        double enteredValue = Double.parseDouble(input);

        Dog dog = new Dog();
        dog.getName();
    }

    /**
     * Gets the maximum number of a datatype with the passed number of Bits.
     *
     * The datatype is considered to be unsigned.
     *
     * @param numberOfBits the number of Bits of the datatype
     * @return the maximum value of the datatype
     */
//    public static long getMaxOfBits(int numberOfBits){
//        return getMaxOfBits(1,numberOfBits);
//    }


}

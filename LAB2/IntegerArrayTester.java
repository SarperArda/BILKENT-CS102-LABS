/**
 * This class checks IntegerArrayList and IntegerArray
 * @SarperArdaBakır
 * @03/02/22
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {

    public static void main(String[] args){
        //Part 1 Checking
        IntegerArray a1 = new IntegerArray("0001000");
        IntegerArray a2 = new IntegerArray("100");


        System.out.print("\nNumber 1: ");
        for (int i = 0; i < a1.numberOfDigits();i++){
            System.out.print(a1.digits[i]);

        }


        System.out.print("\nNumber 2: ");
        for (int i = 0; i < a2.numberOfDigits();i++){
            System.out.print(a2.digits[i]);

        }

        System.out.println("\nLeast Important Digit (Number1): " +a1.LID());
        System.out.println("\nMost Important Digit(Number1): "+a1.MID());
        System.out.println("\nNumber Of digit of number 1: " + a1.numberOfDigits());
        //System.out.println("\nIndex 4 Of digit of number 1: " + a1.getDigit(4));

        if(a1.compareTo(a2) == 0) {
            System.out.println("They are same");
        }else{
        System.out.println("They are not same");
        }


        IntegerArray a3 = a1.add(a2);
        System.out.print("\nSum of number 1 and 2: ");
        for (int i = 0; i < a3.numberOfDigits();i++){
            System.out.print(a3.digits[i]);

        }


        System.out.print("\nSubtraction of number 1 and 2: ");
        IntegerArray a4 = a1.subtract(a2);
        for (int i = 0; i < a4.numberOfDigits();i++){
            System.out.print(a4.digits[i]);

        }


        System.out.println();
        ArrayList<String> arr = new ArrayList<>();
        String n = "13212";
        arr.add(n);
        IntegerArray d = new IntegerArray(n);
        arr.add("00056045");
        arr.add("13298192");
        arr.add("4120930");
        arr.add("3291092");
        IntegerArrayList ıarr = new IntegerArrayList(arr);
        System.out.println("Size of IntegerArrayList:" + ıarr.getSize());
        System.out.println("Digit 0 of Index 2 of IntegerArrayList: " + ıarr.getIntegerArrayAt(2).digits[0]);
        ıarr.addIntegerArray("1212");
        ıarr.removeIntegerArray(2);
        ıarr.removeIntegerArray(d);
        System.out.println("After removing, size of IntegerArrayList: " +ıarr.getSize());



        ////////////////////////////
        //Part2 Checking
        System.out.println();
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {

            System.out.println("\nPlease enter the filename: ");
            String filename = input.nextLine();

            IntegerArrayList arrayList = readIntegerArraysFromFile(filename);
            System.out.println("Output: ");

            System.out.println("\nstart index = " + 0);
            System.out.println("middle index = " + (arrayList.getSize() - 1) /2);
            System.out.println("end index = " + (arrayList.getSize() - 1) +"\n");

            System.out.println("Minimum of all the numbers: ");
            for (int x = 0; x < arrayList.min(0,(arrayList.getSize() - 1)).digits.length; x++) {
                System.out.print(arrayList.min(0, (arrayList.getSize() - 1)).digits[x]);
            }
            System.out.println();

            System.out.println("Minimum of the first half: ");
            for (int x = 0; x < arrayList.min(0,(arrayList.getSize()/2)).digits.length; x++) {
                System.out.print(arrayList.min(0, (arrayList.getSize()/2)).digits[x]);
            }
            System.out.println();

            System.out.println("Minimum of the second half: ");
            for (int x = 0; x < arrayList.min((arrayList.getSize()/2 + 1),(arrayList.getSize() - 1)).digits.length; x++) {
                System.out.print(arrayList.min((arrayList.getSize()/2 + 1), (arrayList.getSize() - 1)).digits[x]);
            }
            System.out.println();
        }



    }

    /**
     * This methods reads file and add numbers to IntegerArrayList
     * @param fileName
     * @return
     */
    public static IntegerArrayList readIntegerArraysFromFile( String fileName){
        ArrayList<String> numbers = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numbers.add(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return new IntegerArrayList(numbers);
    }


}

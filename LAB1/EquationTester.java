/**
 * This class is aim to test Equation class.
 * @SarperArdaBakır
 * @19February2022
 */

import java.util.Scanner;

public class EquationTester {

    public static void main(String[] args){

        //Equations
        Equation eq1 = new Equation(2431,102,595);
        Equation eq2 = new Equation(208,-368,1276);
        Equation eq3 = new Equation(-7038,2646,558);
        Equation eq4 = new Equation(28,3,25);

        //Reducing equations' coefficients
        eq1.reduceEquation();
        eq2.reduceEquation();
        eq3.reduceEquation();
        eq4.reduceEquation();

        //Display reduced equations
        System.out.println();
        System.out.println(eq1.toString());
        System.out.println(eq2.toString());
        System.out.println(eq3.toString());
        System.out.println(eq4.toString());

        Scanner input = new Scanner(System.in);

        //Getting the coefficients of the equation from the user
        System.out.print("\nEnter the value of a, b and c for first equation: ");

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        Equation eq5 = new Equation(a,b,c);

        System.out.print("\nEnter the value of a, b and c for second equation: ");

        int d = input.nextInt();
        int e = input.nextInt();
        int f = input.nextInt();

        Equation eq6 = new Equation(d,e,f);

        eq5.add(eq6);

        //Display adding result
        System.out.println("\nSum of the equations: " + eq5.toString());

        //Getting the coefficients of the equation from the user
        System.out.print("\nEnter the value of a, b and c for first equation: ");

        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        Equation eq7 = new Equation(a,b,c);

        System.out.print("\nEnter the value of a, b and c for second equation: ");

        d = input.nextInt();
        e = input.nextInt();
        f = input.nextInt();

        Equation eq8 = new Equation(d,e,f);

        eq7.subtract(eq8);

        //Display the result of the extraction process
        System.out.println("\nSubtraction of the equations: " + eq7.toString());

        //Testing equals() method
        /**
        System.out.println(eq5.equals(eq6));
        System.out.println(eq5);
        System.out.println(eq6);
         */
    }
}

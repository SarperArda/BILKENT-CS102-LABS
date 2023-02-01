/**
 * This class represents Equation class that represents equations of the form a = bx + c
 * @SarperArdaBakır
 * @19February2022
 */
public class Equation {

    //Private Variables
    private int a;
    private int b;
    private int c;

    //Constructor
    public Equation(int a, int b, int c) {

        if(b < 0){

            a = a * (-1);
            b = b * (-1);
            c = c * (-1);
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * This method simplifies the coefficients.
     */
    public void reduceEquation(){
        int divisor = gcd3(a,b,c);
        a = a / divisor;
        b = b / divisor;
        c = c / divisor;
    }

    /**
     * This method finds the greatest common divisor of two non-negative integers.
     * @param a
     * @param b
     * @return greatest common divisor
     */
    private int gcd(int a, int b){

        int gcd = 1;
        if(a == 0 || b == 0 ){
            return gcd;
        }
        if(a < 0){
            a = a * (-1);
        }

        if(b<0){
            b = b * (-1);
        }

        if(b > a){
            int c = a;
            a = b;
            b = c;
        }

        boolean condition = true;
        while (condition){
            if(a % b == 0){
                condition = false;
                gcd = b;
            }

            if (a % b != 0){
                int c = a;
                a = b;
                b = c % b;
            }
        }
        return gcd;
    }

    /**
     * This method takes three integers and finds their greatest common divisor.
     * @param a
     * @param b
     * @param c
     * @return greatest common divisor
     */
    private int gcd3(int a, int b, int c){

        if(c < 0){
            c = c * (-1);
        }

        if(c == 0 ){
            return gcd(a,b);
        }

        int gcd2 = gcd(a,b);

        return gcd(gcd2,c);
    }

    /**
     * This method returns a string representation of the equation.
     * @return Equation representation
     */
    public String toString(){

        if (b == 0){
            return a +" = " + c;
        }

        if(b == 1){

            if (c == 0){
                return a + " = " + "x";
            }

            if(c < 0) {
                return a + " = " + "x " + c;
            }

            return a + " = " + "x + " + c;
        }

        if (c == 0){
            return a + " = " + b + "x";
        }

        if(c < 0) {
            return a + " = " + b + "x " + c;
        }

        return a + " = " + b + "x + " + c;
    }

    /**
     * This method sums two linear equations (one is the equation for which the method is called (implicit parameter)
     * and the other is eq2) and return the result as a new equation in reduced form.
     * @param eq2
     * @return added Equation
     */
    public Equation add(Equation eq2){

        a = a + eq2.a;
        b = b + eq2.b;
        c = c + eq2.c;

        reduceEquation();

        return new Equation(a,b,c);
    }

    /**
     * This method subtracts eq2 from the equation for which the method is called on (implicit parameter)
     * and returns the result as an equation in reduced form.
     * @param eq2
     * @return reduced Equation
     */
    public Equation subtract(Equation eq2){

        a = a - eq2.a;
        b = b - eq2.b;
        c = c - eq2.c;

        if(b < 0){

            a = a * (-1);
            b = b * (-1);
            c = c * (-1);
        }

        reduceEquation();

        return new Equation(a,b,c);
    }

    /**
     * This method compares two equations and return boolean.
     * @param eq
     * @return boolean
     */
    public boolean equals(Equation eq){

        Equation compare1 = new Equation(this.a,this.b,this.c);
        Equation compare2 = new Equation(eq.a,eq.b,eq.c);
        compare1.reduceEquation();
        compare2.reduceEquation();

       return (compare1.a == compare2.a && compare1.b == compare2.b && compare1.c == compare2.c);
    }
}

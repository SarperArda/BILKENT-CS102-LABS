/**
 * This class represents IntegerArray
 * @SarperArdaBakır
 * @03/02/22
 */
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class IntegerArray implements Comparable<IntegerArray>{
    //Variables
    public int[] digits;
    private String number;
    private boolean isNegative = false;

    //Constructor
    public IntegerArray(String number) {

        int m = 0;
        int f = 0;
        boolean condition = true;

        this.number = number;

        digits = new int[number.length()];

        for(int i = 0; i < number.length();i++){
            char determine = number.charAt(i);
            if(determine == '-'){
                isNegative = true;
                i++;
                f++;
                digits = new int[number.length() - f];

            }
            String ch = number.substring(i,i+1);
            int x = parseInt(ch);
            if(x == 0 & condition){
                f++;
                digits = new int[number.length() - f];
                continue;

            }
            condition = false;
            digits[m] = x;
            m++;

        }

        if(isNegative){
            digits[0] = digits[0] * (-1);
        }

    }
    public IntegerArray(){

    }

    /**
     * This method returns number of digits.
     * @return
     */
    public int numberOfDigits(){
        return digits.length;
    }
    /**
     * This method returns most important digit
     * @return
     */
    public int MID(){

        return digits[0];
    }
    /**
     * This method returns least important digit
     * @return
     */
    public int LID(){
        return digits[digits.length - 1];
    }

    /**
     * This method returns desired digit
     * @param index
     * @return
     */
    public int getDigit(int index){
        int x = digits.length - index - 1;
        return digits[x];
    }

    /**
     * This method subtract two numbers
     * @param other
     * @return
     */
    public IntegerArray subtract(IntegerArray other){

        IntegerArray subtracted = new IntegerArray();
        int max = 0;
        int condition = 0;

        if(this.numberOfDigits() >= other.numberOfDigits()){
            max = this.numberOfDigits();
            condition = 1;

        }

        if(this.numberOfDigits() < other.numberOfDigits()){
            max = other.numberOfDigits();
            condition = 2;
        }

        if(this.numberOfDigits() == other.numberOfDigits() && this.digits[0] < other.digits[0]){
            max = other.numberOfDigits();
            condition = 2;
        }



        int m = 1;
        subtracted.digits = new int[max];
        boolean a = true;
        for (int i = 1; i <= max; i++ , m++){

            if (condition == 1){

                if(i <= other.numberOfDigits() ){
                    int s = this.digits[this.numberOfDigits() - m] - other.digits[other.numberOfDigits() - m];
                    if(s > 0) {
                        subtracted.digits[subtracted.numberOfDigits() - i] = s;
                    }
                    if(s < 0){
                        subtracted.digits[subtracted.numberOfDigits() - i] = s + 10;
                        int g = this.digits[this.numberOfDigits() - m - 1] = this.digits[this.numberOfDigits() - m - 1 ] - 1;

                    }

                }
                else{
                    int s = this.digits[this.numberOfDigits() - m];
                    subtracted.digits[subtracted.numberOfDigits() - i] = s;
                }
            }

            if (condition == 2){

                if(i <= this.numberOfDigits() ){

                    int s = other.digits[other.numberOfDigits() - m] - this.digits[this.numberOfDigits() - m];
                    if(s > 0) {
                        subtracted.digits[subtracted.numberOfDigits() - i] = s;
                    }
                    if(s < 0){
                        subtracted.digits[subtracted.numberOfDigits() - i] = s + 10;
                        int g = other.digits[other.numberOfDigits() - m - 1] = other.digits[other.numberOfDigits() - m - 1 ] - 1;

                    }

                }
                else{
                    int s = other.digits[other.numberOfDigits() - m];
                    subtracted.digits[subtracted.numberOfDigits() - i] = s;
                }
            }


        }

        if(subtracted.digits[0] == 0){
            IntegerArray exception = new IntegerArray();
            exception.digits = new int[subtracted.digits.length - 1];

            for(int i = 1; i < subtracted.digits.length;i++ ){
                exception.digits[i - 1] = subtracted.digits[i];
            }

            return exception;
        }


        return subtracted;
    }

    /**
     * This method adds two numbers
     * @param other
     * @return
     */
    public IntegerArray add(IntegerArray other) {

        IntegerArray sum = new IntegerArray();
        int max = 0;
        int condition = 0;
        if (this.numberOfDigits() >= other.numberOfDigits()) {
            max = this.numberOfDigits();
            condition = 1;
        }


        if (this.numberOfDigits() < other.numberOfDigits()) {
            max = other.numberOfDigits();
            condition = 2;
        }

        if(this.numberOfDigits() == other.numberOfDigits() && this.digits[0] < other.digits[0]){
            max = other.numberOfDigits();
            condition = 2;
        }


        int m = 1;
        sum.digits = new int[max];
        boolean a = true;
        int s;
        for (int i = 1; i <= max; i++, m++) {
            if (condition == 1) {

                if (i <= other.numberOfDigits()) {
                    s = this.digits[this.numberOfDigits() - m] + other.digits[other.numberOfDigits() - m];


                    if (s < 10 && !a && s + 1 < 10) {
                        sum.digits[sum.numberOfDigits() - i] = s + 1;
                        a = true;
                        continue;
                    }
                    if (s == 9 && !a) {
                        sum.digits[sum.numberOfDigits() - i] = 0;
                        a = false;
                        continue;
                    }
                    if (s > 9 && !a && s + 1 >= 10) {
                        sum.digits[sum.numberOfDigits() - i] = (s - 10) + 1;
                        a = true;
                        continue;
                    }
                    if (s < 10 && a) {
                        sum.digits[sum.numberOfDigits() - i] = s;
                        continue;
                    }
                    if (s > 9 && a) {
                        sum.digits[sum.numberOfDigits() - i] = (s - 10);
                        a = false;
                        continue;
                    }


                } else {
                    s = this.digits[this.numberOfDigits() - m];
                    if(!a){
                        s = s + 1;
                        if(s <= 9){
                            a = true;
                            continue;
                        }

                    }

                    sum.digits[sum.numberOfDigits() - i] = s;
                }
            }
            if (condition == 2) {

                if (i <= this.numberOfDigits()) {

                    s = this.digits[this.numberOfDigits() - m] + other.digits[other.numberOfDigits() - m];

                    if (s < 10 && a) {
                        sum.digits[sum.numberOfDigits() - i] = s;
                        continue;
                    }
                    if (s > 9 && a) {
                        sum.digits[sum.numberOfDigits() - i] = (s % 10);
                        a = false;
                        continue;
                    }

                    if (s < 10 && !a && s + 1 < 10) {
                        sum.digits[sum.numberOfDigits() - i] = s + 1;
                        a = true;
                        continue;
                    }
                    if (s == 9 && !a) {
                        sum.digits[sum.numberOfDigits() - i] = 0;
                        a = false;
                        continue;
                    }
                    if (s > 9 && !a && s + 1 > 10) {
                        sum.digits[sum.numberOfDigits() - i] = (s % 10) + 1;
                        a = true;
                        continue;
                    }

                } else {
                    s = other.digits[other.numberOfDigits() - m];
                    if(!a){
                        s = s + 1;
                        if(s < 9){
                            a = true;
                            continue;
                        }
                    }
                    sum.digits[sum.numberOfDigits() - i] = s;
                }

            }

        }
        return sum;
    }


    /**
     * This method
     * @param o
     * @return
     */
    @Override
    public int compareTo(IntegerArray o) {

        if(Arrays.equals(this.digits,o.digits)){
            return 0;
        }

        return -1;
    }


}

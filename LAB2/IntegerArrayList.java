/**
 * This class represents IntegerArrayList
 * @SarperArdaBakır
 * @03/02/22
 */

import java.util.ArrayList;

public class IntegerArrayList {
    //Variable
    ArrayList<IntegerArray> numbers;

    //Constructor
    public IntegerArrayList(ArrayList<String> number) {
        numbers = new ArrayList<IntegerArray>(number.size());
        for (String s : number) {
            IntegerArray a = new IntegerArray(s);
            this.numbers.add(a);
        }
    }

    /**
     * This method return size of numbers
     * @return
     */
    public int getSize(){
        return numbers.size();
    }

    /**
     * This method returns desired IntegerArray
     * @param index
     * @return
     */
    public IntegerArray getIntegerArrayAt(int index){
        return numbers.get(index);
    }
    /**
     * This method changes desired index
     */
    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.set(index,intArr);
    }

    /**
     * This method add new Integer Array
     * @param number
     */
    public void addIntegerArray(String number){
        IntegerArray a1 = new IntegerArray(number);
        numbers.add(a1);
    }

    /**
     * This methods remove desired index
     * @param index
     */
    public void removeIntegerArray(int index){
        numbers.remove(index);
    }

    /**
     * This methods remove desired IntegerArray
     * @param intArr
     */
    public void removeIntegerArray(IntegerArray intArr){
        for (int i = 0; i < numbers.size();i++){
            if(numbers.get(i).compareTo(intArr) == 0){
                numbers.remove(i);
                //break; if we want only one variable delete.
            }
        }
    }

    /**
     * This method finds minimum IntegerArray between desired indexs.
     * @param start
     * @param end
     * @return
     */
    public IntegerArray min(int start, int end){
        int x = end-start;
        IntegerArray min = numbers.get(start);
        for(int i = 1; i <= x; i++){

            if(min.numberOfDigits() < numbers.get(start+i).numberOfDigits()){
                continue;
            }

            if(min.numberOfDigits() > numbers.get(start+i).numberOfDigits()){
                min = numbers.get(start+i);
            }

            if(min.numberOfDigits() == numbers.get(start+i).numberOfDigits()) {

                for (int m = 0; m < min.numberOfDigits(); m++) {

                    if (min.digits[m] > numbers.get(start + i).digits[m]) {
                        min = numbers.get(start + i);
                    }

                    if (min.digits[m] < numbers.get(start + i).digits[m]) {
                        break;
                    }

                }
            }
        }

        return min;
    }


}


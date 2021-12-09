package br.ufsc.ine5429.pseudorandomnumbers;

public class Utils {
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i != 0 && i!= array.length){
                System.out.print(", "+ array[i]);
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }

    public static String transformArrayIntoString(int[] array) {
        String arrayString = "";
        for (int i = 0; i < array.length; i++) {
            arrayString += array[i];
        }
        return arrayString;
    }
}
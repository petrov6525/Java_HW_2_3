package Task1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseArray {
    protected int[] arr;

    public void printArray(){
        System.out.println(Arrays.toString(arr));
    }

    public void readFromConsole () {
        do{
            try{
                Scanner scanner = new Scanner(System.in);
                String text = "";
                System.out.println("Enter array by 'space'");
                if(scanner.hasNextLine()){
                    text = scanner.nextLine();
                }

                String[] text_arr = text.split(" ");
                int[] tmp = new int[text_arr.length];

                for (int i = 0; i < text_arr.length; i++) {
                    tmp[i] = Integer.parseInt(text_arr[i]);
                }
                arr = tmp;
                break;
            }
            catch (Exception ex){
                System.out.println("Error!");
            }
        }while(true);
    }

    public void fillRandoms (int size){
        int[] tmp = new int[size];

        for (int i = 0; i < size; i++) {
            tmp[i] = new Random().nextInt(-20, 20);
        }

        arr = tmp;
    }

    protected int binarySearch(int n){
        if (arr == null){
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}

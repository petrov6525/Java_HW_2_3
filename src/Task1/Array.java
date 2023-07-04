package Task1;

import java.util.Arrays;
import java.util.Random;

public class Array extends BaseArray{

    public Array (int size){
        arr = new int[size];
    }

    public Array (int[] arr){
        this.arr = arr.clone();
    }

    public Array () {

    }

    public void changeElem (int index, int n){
        if( arr == null || index >= arr.length){
            return;
        }

        int[] tmp = new int[arr.length];
        for (int i = 0; i < index; i++) {
            tmp[i] = arr[i];
        }
        tmp[index] = n;
        for (int i = index + 1; i < arr.length; i++) {
            tmp[i] = arr[i];
        }

        arr = tmp;
    }

    public int binarySearch(int n){
        sort();
        return super.binarySearch(n);
    }
    
    public void sortDesc () {
        int n = arr.length;
        for (int i = 0; i < n -1 ; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] < arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void sort () {
        Arrays.sort(arr);
    }

    public double getAvg () {
        int sum = 0;
        for(int n: arr){
            sum += n;
        }
        return sum / (double)arr.length;
    }

    public int getMax (){
        if(arr == null){
            return -1;
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

    public int getMin () {
        if(arr == null){
            return -1;
        }

        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > min){
                min = arr[i];
            }
        }

        return min;
    }

    public void fillRandoms(){
        if(arr == null){
            super.fillRandoms(new Random().nextInt(5, 11));
            return;
        }

        super.fillRandoms(arr.length);
    }
}

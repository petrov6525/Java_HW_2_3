package Task_2;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    protected int cols;
    protected int rows;
    protected int[][] arr;


    public Matrix(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        arr = new int[rows][cols];
    }

    public Matrix (int[][] arr){
        int cols = arr[0].length;
        int rows = arr.length;
        this.arr = new int[rows][cols];
        for (int i = 0; i < rows ; i++) {

            for (int j = 0; j < cols; j++) {
                this.arr[i][j] = arr[i][j];
            }
        }

        this.arr = arr.clone();
        this.rows = rows;
        this.cols = cols;
    }
    public Matrix () {

    }


    public int getMin(){
        if(arr == null){
            return -1;
        }

        int min = arr[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j] < min){
                    min  = arr[i][j];
                }
            }
        }

        return min;
    }

    public int getMax(){
        if(arr == null){
            return -1;
        }

        int max = arr[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j] > max){
                    max  = arr[i][j];
                }
            }
        }

        return max;
    }


    public Matrix mult (Matrix matrix){
        if(cols != matrix.rows){
            System.out.println("Error while multiple. Count cols left matrix must be equal to " +
                    "count rows right matrix");
            return null;
        }
        int[][] tmp_arr = new int[rows][matrix.cols];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < matrix.cols; j++) {

                int sum = 0;
                for (int k = 0; k < cols; k++) {

                    sum += arr[i][k] * matrix.arr[k][j];
                }
                tmp_arr[i][j] = sum;
            }
        }
        Matrix tmp = new Matrix(tmp_arr);
        return tmp;
    }

    public Matrix multScalar(int scalar){
        if(arr == null){
            return null;
        }
        Matrix tmp = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = arr[i][j] * scalar;
                tmp.setElementByIndex(j, i, n);
            }
        }
        return tmp;
    }

    public Matrix minus (Matrix matrix){
        if(cols != matrix.cols || rows != matrix.rows){
            return null;
        }
        Matrix tmp = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = arr[i][j] - matrix.getElemByIndex(j,i);
                tmp.setElementByIndex(j, i, n);
            }
        }
        return tmp;
    }

    public int getElemByIndex(int col, int row){
        if(arr == null){
            return -1;
        }

        return arr[row][col];
    }

    public void setElementByIndex (int col, int row, int n){
        arr[row][col] = n;
    }


    public Matrix plus (Matrix matrix){
        if(cols != matrix.cols || rows != matrix.rows){
            return null;
        }
        Matrix tmp = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = arr[i][j] + matrix.getElemByIndex(j,i);
                tmp.setElementByIndex(j, i, n);
            }
        }
        return tmp;
    }


    public void print () {
        if(arr == null){
            System.out.println("The matrix is empty");
            return;
        }

        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + "\t");
            }
        }
        System.out.println();
    }


    public void fillRandom () {
        if(arr == null){
            cols = new Random().nextInt(3, 6);
            rows = new Random().nextInt(3, 6);
            arr = new int[rows][cols];

            fillRandom(cols, rows);

            return;
        }

        fillRandom(cols, rows);

    }

    public void fillRandom(int cols, int rows){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = new Random().nextInt(1, 5);
            }
        }
    }
}

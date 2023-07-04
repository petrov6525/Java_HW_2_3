import Task1.Array;
import Task_2.Matrix;

public class Main {

    public static void Task1(){

        Array arr = new Array(4);
        arr.fillRandoms(10);

        Array arr1 = new Array(4);
        arr1.fillRandoms();

        Array arr2 = new Array();
        arr2.fillRandoms();

        Array arr3 = new Array();
        arr3.fillRandoms(8);

//        arr.readFromConsole();

        //arr.fillRandoms();
        arr = new Array(new int[]{4, 1, 5, 10, 11 ,6});
//        arr.sort();
        arr.printArray();
        arr.changeElem(4, 7);
        arr.printArray();

//        System.out.println(arr.binarySearch(1));
//        arr.sort();
//        arr.printArray();
//        arr.sortDesc();
//        arr.printArray();
//        arr1.printArray();
//        arr2.printArray();
//        arr3.printArray();
    }


    public static void Task2(){
        Matrix matrix1 = new Matrix(3,2);
        matrix1.fillRandom();

        Matrix matrix2 = new Matrix(2, 3);
        matrix2.fillRandom();

        Matrix matrix3 = matrix1.plus(matrix2);
        matrix3 = matrix2.minus(matrix1);
        matrix3 = matrix1.multScalar(2);
        matrix3 = matrix1.mult(matrix2);

        matrix1.print();
        matrix2.print();
        matrix3.print();

    }


    public static void main(String[] args) {

//        Task1();
        Task2();
    }
}
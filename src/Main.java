import java.util.Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to a program. First let create your array...");
        System.out.print("Enter your length of your array, a random element will appear in your array?! :");

        int l = sizeIn();
        int[] array = arrayRandomCreate(l);
        System.out.println("Your array has been created");
        programRun(array);

    }

    static void programRun(int[] array) {
        int action;
        do {
            Scanner sc = new Scanner(System.in);
            menuAction();
            System.out.println("What next?! Choose an action below: ");
            action = sc.nextInt();
            switch (action) {
                case 1:
                    arrayDisplay(array);break;
                case 2:
                    System.out.println("Largest even number: " + largestEvenNums(array));break;
                case 3:
                    System.out.print("###");
                    displayEven(array,evenNumber(array));break;
                case 4:
                    int sum = sumOfEven(array);
                    System.out.println("### Sum result = " + sum);
                    break;
                case 5:
                    System.out.println("#Enter a new item??? ");
                    int item = sc.nextInt();
                    System.out.println("#Add to where?? ");
                    int index = sc.nextInt();
                    int[] newArray = insertNewItem(array,item,index);
                    System.out.println("### New array : " +Arrays.toString(newArray));
                    break;
                case 6 :
                    System.out.println("Which one that you want to kill? :");
                    int deleteNums = sc.nextInt();
                    int indexOfNums = indexOfDeleteItem(array,deleteNums);
                    int[] newArr = deleteItem(array,deleteNums,indexOfNums);
                    System.out.println("### New array is :" + Arrays.toString(newArr));
                    break;
                case 7 :
                    reverseArray(array);
                    break;
                case 8 :
                    isPrimeDisplay(array);
                    break;
                case 9 :
                    sortArray(array);
                    break;
                case 10:
                    System.exit(0);
            }
        } while (action > 0 && action < 11) ;
    }

    static int sizeIn() {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        while (l >= 100) {
            System.out.print("Not available - Pls re-enter a length ");
            l = sc.nextInt();
        }
        return l;
    }

    static void menuAction() {
        System.out.println("Menu");
        System.out.println("1. Display your array");
        System.out.println("2. Find a largest even number in array");
        System.out.println("3. Display all even number in array");
        System.out.println("4. Sum of even number");
        System.out.println("5. Insert new item to array");
        System.out.println("6. Delete item in array");
        System.out.println("7. Reverse an array ");
        System.out.println("8. Prime number in array ");
        System.out.println("9. Sort array from max to min ");
        System.out.println("10. Exit");
    }

    static int[] arrayRandomCreate(int l) {
        int[] array = new int[l];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random()*99);
        }
        return array;
    }

    static void arrayDisplay(int[] array) {
        System.out.println("### Array : " + Arrays.toString(array));
    }

    static int largestEvenNums(int[] array) {
        int maxEven = 0;
        for (int j : array) {
            if (j > maxEven)
                if (j % 2 == 0)
                    maxEven = j;
        }
        return maxEven;
    }

    static boolean evenNumber(int[] array) {
        for (int i = 0;i< array.length;i++) {
                if (array[i] % 2 == 0)
                    return true;
            }
        return false;
    }

    static void displayEven(int[] array, boolean evenNumber) {
            for (int i = 0; i < array.length;i++) {
                if(evenNumber)
                    System.out.println(array[i] + ", ");
            }
        }

    static int sumOfEven(int[] array) {
        int sum = 0;
        for(int i = 0;i<array.length;i++) {
            if(evenNumber(array)) {
                sum+= array[i];
            }
        }
        return sum;
    }

    static int[] insertNewItem(int[] array,int item, int index) {
        int[] newArray = new int[array.length + 1];
        for(int i = 0; i < index; i++) {
            newArray[i] = array[i];
            newArray[index] = item;
        }
        for (int i = index + 1;i < newArray.length;i++) {
            newArray[i] = array[i-1];
        }
        return newArray;
    }

    static int indexOfDeleteItem(int[] array, int deleteNums) {
        int indexOfDelItem = -1;
        for (int i=0; i < array.length;i++) {
            if (array[i] == deleteNums) {
                indexOfDelItem = i;
            }
        }
        return indexOfDelItem;
    }

    static int[] deleteItem(int[] array, int deleteNums, int indexOfDelItem) {
        int [] newArr = new int[array.length - 1];
            for (int i = 0;i < indexOfDelItem ;i++) {
                newArr[i] = array[i];
            }
            for (int i = indexOfDelItem; i < newArr.length; i++) {
                newArr[i] = array[i+1];
        }  return newArr;
    }

    static void reverseArray(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("New array " + Arrays.toString(array));

    }

    static boolean isPrime(int number) {
        if (number < 2)
            return false;
        else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        }
    }

    static void isPrimeDisplay(int[] array) {
        for( int i : array) {
            if(isPrime(i)) {
                System.out.print("A prime is : "+ i + "\t");
            }
        }
    }

    static void sortArray(int[] array){
        for(int i =0; i < array.length;i++) {
            for (int j = i + 1;j < array.length;j++) {
                int temp = 0;
                if(array[i]<array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println("##Array : " + Arrays.toString(array));

    }
}

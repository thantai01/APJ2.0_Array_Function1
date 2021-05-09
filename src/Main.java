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
                    displayEven(array,evenNumber(array));break;
                case 4:
                    sumOfEven(array);break;
                case 5:

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
        System.out.println("9. Filter array from max to min ");
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
        System.out.println(Arrays.toString(array));
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

    static void sumOfEven(int[] array) {
        int sum = 0;
        for(int i = 0;i<array.length;i++) {
            if(evenNumber(array)) {
                sum+= array[i];
            }
        }
        System.out.println("Sum of even = " + sum);
    }

}

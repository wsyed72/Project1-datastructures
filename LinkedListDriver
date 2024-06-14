import java.util.Scanner;
public class LinkedListDriver {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        if(args.length == 0){
            System.out.print("Please provide a path to a plain text file as a command-line parameter");
            return;
        }

        String input;
        boolean exit = false;

        while (!exit){
            System.out.println("Commands:\n"
                    + "(i) - Insert value\n"
                    + "(d) - Delete value\n"
                    + "(s) - Search value\n"
                    + "(n) - Print next iterator value\n"
                    + "(r) - Reset iterator\n"
                    + "(a) - Delete alternate nodes\n"
                    + "(m) - Merge lists\n"
                    + "(t) - Find intersection\n"
                    + "(p) - Print list\n"
                    + "(l) - Print length\n"
                    + "(q) - Quit program\n");

            System.out.println();
            System.out.print("Enter a command: ");
            input = scan.next().toLowerCase();

            boolean valid = false;
            while(valid) {
                switch (input) {

                    case "i":                   // Insert Value
                        valid = true;
                        int insert;

                        System.out.print("Enter a number to insert: ");
                        insert = scan.nextInt();


                        break;




                    case "d":                   //Delete Value
                        valid = true;
                        int delete;

                        System.out.print("Enter a number to delete: ");
                        delete = scan.nextInt();


                        break;






                    case "s":                   // Search Value
                        valid = true;
                        int key;

                        System.out.print("Enter a number to search");
                        key = scan.nextInt();

                        break;







                    case "n":                   // Print next Iterator Value
                        valid = true;


                        break;







                    case "r":                   // Reset iterator
                        valid = true;

                        System.out.print("Iterator is reset");
                        break;






                    case "a":                   // Delete alternate nodes
                        valid = true;

                        System.out.print("Original List: ");
                        System.out.print("Modified List: ");
                        break;






                    case "m":                   // Merge Lists
                        valid = true;
                        int length;
                        System.out.print("Enter the length of the new list: ");
                        length = scan.nextInt();

                        System.out.print("Enter the numbers: ");
                        break;







                    case "t":                   // Find Intersection
                        valid = true;
                        int newLength;
                        String numbers;

                        System.out.print("Enter the length of the new list: ");
                        newLength = scan.nextInt();
                        System.out.print("Enter the numbers: ");
                        numbers = scan.nextLine();
                        System.out.println("The list 1: ");

                        System.out.println("The list 2: ");

                        System.out.print("Intersection of lists");
                        break;






                    case "p":                   // Print List
                        valid = true;

                        System.out.print("Original list : ");
                        break;





                    case "l":                   // Print Length
                        valid = true;
                        break;






                    case "q":                   // Quit Program
                    valid = true;
                    System.exit(0);
                        break;

                    default:                   // Invalid input

                        System.out.print("Invalid command try again: ");
                        input = scan.next();
                        break;
                } // switch
            }

        } // while








    } // main

} // LinkedListDriver

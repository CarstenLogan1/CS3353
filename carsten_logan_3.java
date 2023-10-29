/* Homework #3, Carsten Logan */

import java.util.Scanner;
import java.util.LinkedList;

class carsten_logan_3{
	
	/**
    Program that takes decimal(integer) user input
    and changes into equivalent binary, octal, and
    hexadecimal value using a stack implemented
    through Java's LinkedList
     */

    private static final Scanner keyboard = new Scanner(System.in);
    static StackLList<Integer> stack = new StackLList<>();
    
    
    public static void main(String[] args) throws Exception {
        menuDriver();

    }


    static void menuDriver() throws Exception {

        int option = 0;
        int el = 0;
        String input;
        String[] ins;
        displayMenu();

        do{

            input = keyboard.nextLine();
            ins = input.split(" ");
            if(ins.length >= 1){
                try{
                    option = Integer.parseInt(ins[0]);
                    if(ins.length == 2){
                        el = Integer.parseInt(ins[1]);
                    }
                } catch(NumberFormatException e){
                    // set option to -1 so default case runs when invalid input
                    option = -1;
                    el = -1;
                    System.out.println("Invalid input. Enter integer(s) separated by a space");
                    System.out.println("\n");
                }

            } else {
                // set option to -1 so default case runs when invalid input
                option = -1;
                el = -1;
                System.out.println("Invalid input. Enter integer(s) separated by a space");
                System.out.println("\n");
            }


            switch (option) {
                case 0:
                    toBinary(el);
                    menuDriver();
                    break;
                case 1:
                    toOctal(el);
                    menuDriver();
                    break;
                case 2:
                    toHex(el);
                    menuDriver();
                    break;
                case 3:
                    System.exit(0);
                default:
                    menuDriver();
            }

        } while (true);


    }


    static void toHex(int el) throws Exception {

        if( el == 0){
            System.out.println("0");
            stack.clear();
        } else {
            //push remainders into stack
            for (int i = el; i > 0; i /= 16) {
                stack.push(i % 16);
            }
            do {
                //store top value in tmp variable for comparison
                int value = stack.pop();
                //runs method to get according letter
                if (value >= 10) {
                    System.out.print(hexLetter(value) + " ");
                } else {
                    System.out.print(value + " ");
                }
            } while (!(stack.isEmpty()));
            System.out.println("\n");

            stack.clear();
        }
    }

    static char hexLetter(int el){
        //returns corresponding letter with remainder
        return switch (el) {
            case 10 -> 'A';
            case 11 -> 'B';
            case 12 -> 'C';
            case 13 -> 'D';
            case 14 -> 'E';
            case 15 -> 'F';
            default -> '0';
        };

    }
    static void toOctal(int el) throws Exception {

        if( el == 0){
            System.out.println("0");
            stack.clear();
        } else {
            //pushes remainders into stack
            for (int i = el; i > 0; i /= 8) {
                stack.push(i % 8);
            }
            do {
                //can directly pop and print values bc no intermediate comparison
                System.out.print(stack.pop() + " ");
            } while (!(stack.isEmpty()));
            System.out.println("\n");

            //ensure stack is empty before next operation
            stack.clear();
        }
    }

    static void toBinary(int el) throws Exception {

        if( el == 0){
            System.out.println("0");
            stack.clear();
        } else {


            //push remainders into stack
            for (int i = el; i > 0; i /= 2) {
                stack.push(i % 2);
            }

            do {
                //print elements directly
                System.out.print(stack.pop() + " ");
                //while elements still in stack
            } while (!(stack.isEmpty()));
            System.out.println("\n");

            //ensure empty stack
            stack.clear();
        }
    }

    static void displayMenu(){
        //menu display method for conciseness in main()
        System.out.println("MENU");
        System.out.println("Please Enter option then desired integer value!");
        System.out.println("Binary(0), Octal(1), Hexadecimal(2)");
        System.out.println("Exit Program(3)");

    }

}

class StackLList<E>{
    /*Java LList provides several methods already for
    using LList for stack implementation
     */
    private LinkedList<E> stack = new LinkedList<E>();

    StackLList(){
    }
    void clear(){
        //clears stack
        stack.clear();
    }

    boolean isEmpty(){
        //checks is stack is empty; uses LList built in isEmpty()
        return stack.isEmpty();
    }

    void push(E e){
        //pushes to top of stack; uses push() from built in LList for stack implementation
        stack.push(e);
    }

    E pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty List");
        }
        //pops top element from stack; uses pop() from built in LList for stack implementation
        return stack.pop();
    }

    E topEl() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty List");
        }
        //return top value without removing element
        return stack.peekLast();
    }
	
	
}

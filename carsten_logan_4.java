/* Carsten Logan CS3353 Homework 4 */

import java.util.Scanner;

public class carsten_logan_4 {
	
	
	private static final Scanner keyboard = new Scanner(System.in);
    static int M = 0;
    static int N = 0;

    public static void main(String[] args) throws Exception {

        menuDriver();

    }

    private static void discovery(int [][] grid, int m, int n, String route) {
        //Base case: if at end of grid, add current location and print path
        //Return then backtracks to previous square/ previous recursive call
        if( (m == M - 1) && (n == N - 1)){
            route = "[ " + route + grid[m][n] + " ]";
            System.out.println(route);
            return;

        }

        route += grid[m][n] + ", ";

        if(m + 1 < M){
        //If still rows to go, move down one square
            discovery(grid, m+1, n, route);
        }

        if(n + 1 < N){
        //If still columns to go, move right one square
            discovery(grid, m, n+1, route);
        }

        if((n + 1 < N) && (m + 1 < M)){
        //Diagonal Right = down and right 1
        //Check if room to go down and right one square each
            discovery(grid, m+1, n+1, route);
        }

    }

    public static int[][] generateGridArray(int x, int y) {
        /*
        This method generates the number grid
        so that all paths can be represented
        by the integer value of the square
        rather than the x-y coordinates
         */
        int[][] grid = new int[x][y];
        int num = 1;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = num;
                num++;
            }
        }

        return grid;
    }








    public static void displayMenu(){
        System.out.println("          MENU          ");
        System.out.println(" Horizontal Axis(0), Vertical Axis(1), ");
        System.out.println(" Discovery(2), Quit(3)");


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
                    if(option != 0 && option != 1 && option != 2 && option != 3){
                        System.out.println("Invalid menu option");
                    }
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
                    M = el;
                    menuDriver();
                    break;
                case 1:
                    N = el;
                    menuDriver();
                    break;
                case 2:
                    int m = 0;
                    int n = 0;
                    String route = "";
                    discovery(generateGridArray(M,N), m, n, route);
                    menuDriver();
                    break;
                case 3:
                    System.exit(0);
                default:
                    menuDriver();
            }

        } while (true);


    }


}

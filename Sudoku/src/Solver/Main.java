package Solver;

public class Main {
    static String sudoku[][] = new String[9][9];
    static int max_size;
    
    public static void initialization(){
        
        /**
         * Objective: Initializing the Sudoku Array with Zeroes and other Global Variables
         * 
         */
        max_size = 9;
        for(int i = 0;i < max_size;i++){
            for(int j = 0;j < max_size;j++)
                //Initialize Cell with all possible numbers
                sudoku[i][j] = "123456789";
        }
    }
    
    public static boolean UsedInRow(int row,String number){
        
        /**
         * Objective: Check whether given number exists in a Row or not
         * Input: Row Number & Number to be checked
         * Output: True (if used in Row)
         *         False (if not)
         */
        
        boolean check = false;
        for(int i = 0;i < max_size;i++){
            if(sudoku[row][i].equalsIgnoreCase(number)){
                check = true;
                break;
            }
        }
        
        return check;
    }
    
    public static boolean UsedInColumn(int column,String number){
         /**
         * Objective: Check whether given number exists in a Column or not
         * Input: Row Number & Number to be checked
         * Output: True (if used in Column)
         *         False (if not)
         */
        
        boolean check = false;
        for(int i = 0;i < max_size;i++){
            if(sudoku[i][column].equalsIgnoreCase(number)){
                check = true;
                break;
            }
        }
        
        return check;
    }
    
    public static boolean UsedInGrid(int row,int column,String number){
        
        /**
         * Objective: Check whether the given number exists in the Corresponding Grid
         * Input: Row & Column Number and Number to be checked
         * Output: True (if used in Grid)
         *         False (if not)
         */
        
        //Setting Row and Column to minimum value of Grid
        row -= row%3;
        column -= column%3;
        
        boolean check = false;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(sudoku[i][j].equalsIgnoreCase(number)){
                    check = true;
                    break;
                }
            }
        }
        
        return check;
    }
    
    public static boolean isSafe(int row,int column,String number){
        
        /**
         * Objective: Check whether the given number is Safe or not i.e. satisfies the 3 condition of the Game
         * Input: Row & Column Number and Number to be checked
         * Output: True (if Safe)
         *         False (if not)
         */
        
        boolean check = !UsedInRow(row,number) &&
                        !UsedInColumn(column,number) &&
			!UsedInGrid(row,column,number);
        
        return check;
    }
}

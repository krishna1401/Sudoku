package Solver;

/**
 * The particular class Solution gets the problem Sudoku and gives the Solved Sudoku after operations
 * @author Krishna Agarwal
 */

public class Solution {
    static String sudoku[][] = new String[9][9];
    static int max_size;
    static int current_row;
    static int current_column;
    
    public Solution(String problem[][]){
        
        /**
         * Objective: COnstructor to initialize Global Variables and Sudoku
         */
        
        max_size = 9;
        current_row = 0;
        current_column = 0;
        
        for(int i = 0;i < max_size;i++){
            for(int j = 0;j < max_size;j++){
                if(problem[i][j].equals("")){
                    sudoku[i][j] = "123456789";
                }else{
                    sudoku[i][j] = problem[i][j];
                }
            }
        }
    }
    
    public static boolean validateSudoku(){
        
        /**
         * Objective: Sudoku should have at least 17 cells filled to find a possible Solution
         * Input: NULL
         * Output: True (if it have 17 cells filled
         *         False (if not)
         */
        
        int count = 0;
        for(int i = 0;i < max_size;i++){
            for(int j = 0;j < max_size;j++){
                if(!sudoku[i][j].equals("123456789")){
                    count++;
                }
            }
        }
        return count >= 17;
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
        row = row - row%3;
        column = column - column%3;
        
        boolean check = false;
        exit:
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(sudoku[row+i][column+j].equalsIgnoreCase(number)){
                        check = true;
                        break exit;
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
    
    public static String getConstraint(int row,int column){
        
        /**
         * Objective: Return the possible Values (constraints) for a given cell
         * Input: Row & Column Number
         * Output: String of all possible values from "0" to "9"
         */
        
        String possible_values = "";
        String number;
        for(int i = 0;i < sudoku[row][column].length();i++){
            number = Character.toString(sudoku[row][column].charAt(i));
            if(isSafe(row, column, number)){   
                possible_values = possible_values + number;
            }
        }
        return possible_values;
    }
    
    public static boolean solveSudoku(){
        
        /**
         * Objective: Assign Values to all the Blank Cells using above functions
         * Input: NULL
         * Output: True (if Sudoku is solved)
         *         False (if not)
         */
        
        boolean result = true;
        
        if(validateSudoku()){
            boolean loop_condition;
            exit:
            do{
                loop_condition = false;
                for(int i = 0;i < max_size;i++){
                    for(int j = 0;j < max_size;j++){
                        if(sudoku[i][j].length() != 1){
                            sudoku[i][j] = getConstraint(i,j);
                        }
                        if(sudoku[i][j].equalsIgnoreCase("")){
                            result = false;
                            break exit;
                        }
                        if(sudoku[i][j].length() > 1){
                            loop_condition = true;
                        }
                    }
                }
            }while(loop_condition);
        }else{
            result = false;
        }
        //System.out.println(isSafe(8,8,"2"));
        return result;
    }
    
    /**
    public static void main(String args[]){
        solveSudoku();
        display();
    }*/
}

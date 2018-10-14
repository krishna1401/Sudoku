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
    
    public static void initialization(){
        sudoku[0][1] = "6";
        sudoku[0][2] = "2";
        sudoku[0][3] = "8";
        sudoku[0][5] = "4";
        sudoku[0][6] = "9";
        sudoku[0][8] = "7";
        sudoku[1][6] = "1";
        sudoku[1][7] = "2";
        sudoku[1][8] = "4";
        sudoku[2][3] = "3";
        sudoku[2][5] = "2";
        sudoku[2][6] = "8";
        sudoku[3][3] = "1";
        sudoku[3][4] = "2";
        sudoku[3][5] = "8";
        sudoku[3][7] = "6";
        sudoku[5][1] = "7";
        sudoku[5][3] = "4";
        sudoku[5][4] = "5";
        sudoku[5][5] = "9";
        sudoku[6][2] = "8";
        sudoku[6][3] = "6";
        sudoku[6][5] = "1";
        sudoku[7][0] = "4";
        sudoku[7][1] = "1";
        sudoku[7][2] = "6";
        sudoku[8][0] = "7";
        sudoku[8][2] = "9";
        sudoku[8][3] = "5";
        sudoku[8][5] = "3";
        sudoku[8][6] = "6";
        sudoku[8][7] = "8";
    }
    
    public static void display(){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++)
                System.out.print(sudoku[i][j]+"\t");
            System.out.println();
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
    
    /**
    public static boolean getBlankCell(){
        
        /**
         * Objective: Find the Cell that do not contain any Number
         * Input: NULL
         * Output: True (if any blank cell exists)
         *         False (if not)
         
        
        boolean blank_cell = false;
        for(current_row = 0;current_row < max_size;current_row++){
            for(current_column = 0;current_column < max_size;current_column++){
                if(sudoku[current_row][current_column].length() != 1){
                    blank_cell = true;
                    break;
                }
            }
            if(blank_cell){
                break;
            }
        }
        return blank_cell;
    }
    */
    public static boolean solveSudoku(){
        
        /**
         * Objective: Assign Values to all the Blank Cells using above functions
         * Input: NULL
         * Output: True (if Sudoku is solved)
         *         False (if not)
         */
        
        boolean result = true;
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
        //System.out.println(isSafe(8,8,"2"));
        return result;
    }
    
    public static void main(String args[]){
        initialization();
        solveSudoku();
        display();
    }
}

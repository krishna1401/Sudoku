/*
 * This class generates a new Sudoku puzzle and returns to the Main GUI for game.
 */
package Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Generator {
    public int puzzle[][];
    private int max_size;
    
    public Generator(){
        max_size = 9;
        puzzle = new int[max_size][max_size];
        for(int i = 0;i < max_size;i++){
            for(int j = 0;j < max_size;j++)
                puzzle[i][j] = 0;
        }
    }
    
    private boolean UsedInRow(int row,int number){
        
        /**
         * Objective: Check whether given number exists in a Row or not
         * Input: Row Number & Number to be checked
         * Output: True (if used in Row)
         *         False (if not)
         */
        
        boolean check = false;
        for(int i = 0;i < max_size;i++){
            if(puzzle[row][i] == number){
                check = true;
                break;
            }
        }
        
        return check;
    }
    
    private boolean UsedInColumn(int column,int number){
        
        /**
         * Objective: Check whether given number exists in a Column or not
         * Input: Row Number & Number to be checked
         * Output: True (if used in Column)
         *         False (if not)
         */
        
        boolean check = false;
        for(int i = 0;i < max_size;i++){
            if(puzzle[i][column] == number){
                check = true;
                break;
            }
        }
        
        return check;
    }
    
    private boolean UsedInGrid(int row,int column,int number){
        
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
                if(puzzle[row+i][column+j] == number){
                        check = true;
                        break exit;
                }
            }
        }
        
        return check;
    }
    
    private boolean isSafe(int row,int column,int number){
        
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
    
    public boolean createPuzzle(){
        boolean result = false;
        int row = -1;
        int column = -1;
        
        boolean isEmpty = true;
        
        outer:
        for(int i = 0;i < max_size;i++){
            for(int j = 0;j < max_size;j++){
                if(puzzle[i][j] == 0){
                    row = i;
                    column = j;
                    isEmpty = false;
                    break outer;
                }
            }
        }
        if(isEmpty){
            result = true;
        }else{
            ArrayList<Integer> possible_numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            Collections.shuffle(possible_numbers);
            for(int num = 0;num < 9;num++){
                if(isSafe(row, column, possible_numbers.get(num))){
                   puzzle[row][column] = possible_numbers.get(num);
                   if(createPuzzle()){
                       result = true;
                   }else{
                       puzzle[row][column] = 0;
                   }
               }
            }
        }
        return result;
    }
    
    public void display(){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                System.out.print(puzzle[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
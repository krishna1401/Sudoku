# Sudoku

## Game Description
> Sudoku is a logic-based, combinatorial number-placement puzzle.
Objective of the game is to fill a 9x9 grid with digits based on the following constraints:
- Each Row should contain all digits from 1 to 9
- Each Column should contain all digits from 1 to 9
- Each of 3x3 subgrid should contain all digits from 1 to 9

## Problem Statment
Create a Sudoku Puzzle Game i.e. provide some pre-filled cells in the Sudoku and the user solves the Sudoku.

## How to Use
Open the given project in any Java IDE (preferred Netbeans) and execute the GUI.java file for execution.

## Approach
Sudoku Generator using BackTracking Algorithm to create a Valid Sudoku using following steps:
1. Find at Empty cell in the Sudoku (if exists)
2. Fill any of the one possible values *(1,2,3,4,5,6,7,8,9)*
3. Check whether the value is Safe or not
4. Repeat steps 1 - 3 until,
		- All cells are assigned some value **(Random Sudoku Puzzle)**
		- Some cells are left unfilled **(No Sudoku Puzzle)**
3. If not set cell value to 0 and try other value, else continue with step 1
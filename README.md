# Sudoku

## Game Description
> Sudoku is a logic-based, combinatorial number-placement puzzle.
Objective of the game is to fill a 9x9 grid with digits based on the following constraints:
- Each Row should contain all digits from 1 to 9
- Each Column should contain all digits from 1 to 9
- Each of 3x3 subgrid should contain all digits from 1 to 9

## Problem Statment
Given a semi-filled 9x9 grid with some numbers we need to determine the complete grid (if possible) following all the above constraints.

| ![Input](https://github.com/krishna1401/Sudoku-Solver/blob/master/Sudoku%20Solver/Example.png) | ![Output](https://github.com/krishna1401/Sudoku-Solver/blob/master/Sudoku%20Solver/Solution.png) |
| :---: | :---: |
| **Input** | **Output** |

## How to Use
Open the given project in any Java IDE (preferred Netbeans) and execute the GUI.java file for execution.

## Approach
Sudoku Solver is based on the Contraint Satisfaction Problem Algorithm. It performs the following steps:
1. Find any empty cell within the grid.
2. Find all possible values from the given cell without voilating constraints.
3. Assign value to the cell if it have only single possibility
4. Repeat steps 1 - 3 until,
      - All cells are filled with unique digits **(Solution)**
      - No single possibility for any one of the cell **(No Solution)**

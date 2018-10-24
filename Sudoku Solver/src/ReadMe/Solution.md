## Introduction
> Solution.java file accepts a problem Sudoku using a Construction and then returns the solution (if exists) using the function **solveSudoku**

## Global Variable
1. **sudoku** : It is a 2D array of 9x9, used to represent a Sudoku Matrix
2. **max_size** : Defines the maximum number of rows/columns in a Sudoku Matrix

## Functions
### validateSudoku
> Validates the problem Sudoku to have at least 17 digits filled in the Matrix
- **Input**: NULL
- **Output**: True (if at least 17 digits are in the Sudoku) & False (if not)

### usedInRow
> Check whether the given number exists in the specified row or not
- **Input**: Row Number & Digit (to be checked)
- **Output**: True (if used) & False(if not)

### usedInColumn
> Check whether the given number exists in the specified column or not
- **Input**: Column Number & Digit (to be checked)
- **Output**: True (if used) & False(if not)

### usedInGrid
> Check whether the given number exists in the corresponding grid or not
- **Input**: Row & Column Number & Digit (to be checked)
- **Output**: True (if used) & False(if not)

### isSafe
> Check whether the given number is safe or not i.e. satisfies all the three constraints
- **Input**: Row & Column Number & Digit (to be checked)
- **Output**: True (if used) & False(if not)

### getConstraint
> Returns all possible numbers that can be used in a particular cell
- **Input**: Row & Column Number
- **Output**: String of numbers that can be used in a cell ("" if no number is possible)

### solveSudoku
> Assigns values to all the blank cell within the matrix using the above functions
- **Input**: NULL
- **Output**: NULL
- **Approach**: Find contraints for all the blank cell and assign the number if only single possibility is left. Execute until all the cells have unique number or if any cell cannot have a number.
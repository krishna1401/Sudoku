## Introduction
> Generator.java file construct a random valid sudoku using **bracktracking** technique in **createPuzzle()**

## Global Variable
1. **puzzle** : It is a 2D array of 9x9, used to represent a Sudoku Matrix
2. **max_size** : Defines the maximum number of rows/columns in a Sudoku Matrix

## Functions
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

### createPuzzle
> It creates a Random Valid Sudoku using backtracking technique.
- **Input**: NULL
- **Output**: true (if valis Sudoku is generated) else false
- **Approach**: Simple Backtracking approach to find any one valid Sudoku.
## Introduction
> GUI.java uses a Graphical User Interface to take Sudoku Matrix as input from the user and then prints the solution (if exists) using Solution.java file.

## Global Variables
1. **problemSudoku**: It stores the problem Sudoku entered by the user
2. **cells**: It is a HashMap used to store key-value pair of String-JTextField Objects for access
3. **max_size**: Defines the maximum number of rows/columns in a Sudoku Matrix

## User Defined Functions
### initializeHashMap
> Store all the JTextField Objects with there corresponding String key for easy access
- **Input**: NULL
- **Output**: NULL

### getInput
> Reads input from all the cells of the Sudoku and validates for digits (1-9) and store it in the problemSudoku global variable
- **Input**: NULL
- **Output**: NULL

## display
> Display the resultant solved Sudoku (if exists) with some basic formatting of representation
- **Input**: NULL
- **Output**: NULL
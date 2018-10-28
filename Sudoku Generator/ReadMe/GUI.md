## Introduction
> GUI.java uses a Graphical User Interface to take Sudoku Matrix as input from the user and then prints the solution (if exists) using Solution.java file.

## Global Variables
1. **keyListener**: Key Listener Object to valid entered key in the cell i.e. only Digits
2. **cells**: It is a HashMap used to store key-value pair of String-JTextField Objects for access
3. **max_size**: Defines the maximum number of rows/columns in a Sudoku Matrix
4. **generator**: Generator.java Object for function calls

## User Defined Functions
### initializeHashMap
> Store all the JTextField Objects with there corresponding String key for easy access
- **Input**: NULL
- **Output**: NULL

### addKeyListeners
> Add Key Listener Event to all the text fields in the Sudoku GUI and updates the object overload functions for appropriate functioning i.e. No key is typed in the cell except Digits *(1,2,3,4,5,6,7,8,9)*
- **Input**: NULL
- **Output**: NULL

### getRandomCells
> It selects cells from the Sudoku that need to be displayed to the user in *Grid-by-Grid* fashion
- **Input**: NULL
- **Output**: NULL

### getResult
> It check whether the solved Sudoku by the user is same as the actual puzzle Sudoku or not
- **Input**: NULL
- **Output**: true (if solution is correct) else false
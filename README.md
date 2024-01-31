# Weighted-Activity-Selection

The goal is to find a subset of mutually compatible activities with maximum total weight by using dynamic programming.

## Running the program
The absolute path of an input file will be provided as a command-line argument to the program.  
The jar will be run using the following command:  
java -jar jar_name.jar absolute_path_to_input_file  
The input file will have the number of activities n in the first line, followed by n lines.  
Each line will contain the start time, finish time and weight of one of the input activities.  
All data will be integers and will be separated by spaces, e.g.,  
3  
1 2 1  
2 3 2  
3 4 5  
The program will output a file that has the maximum possible weight that can be obtained by choosing a mutually-compatible set of activities.  
The file will appear in the same directory as the input file.  
If the input file name is test.in, then the output will be test.out.

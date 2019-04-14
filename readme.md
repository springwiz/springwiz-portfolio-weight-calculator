#Portfolio Calculator

The Portfolio Calculator ingests an Input File via command line and evaluates the fund portfolio weights.
Features:
* Calculates fund weight within the flattened given portfolio in the input file.
* Employes the graph data structure and breadth first search to calculate fund weight for all base 
(leaf node) funds within the portfolio.
* Calculates the weighted return given ending market value of the portfolio is provided.
* Uses java streams and functional programming.

Assumptions:
* The Solution assumes that the ending market value is provided as an argument over the command line.

#Building the Solution
The Solution relies on Maven to build the Solution and packages a pom.xml as part of the project/zip file.
Run the following in order to build the Solution.

mvn clean install

Needless to say that the maven should be installed and present on the path.

#Input
The Solution assumes that the input is passed in the following format:
A,B,1000  
A,C,2000  
B,D,500   
B,E,250    
B,F,250  
C,G,1000  
C,H,1000 

#Running the Solution
The Solution can be run as:
java -jar ./target/springwiz-portfolio-weight-calculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./data/input.txt 9000

#Output
A,D,0.167
A,E,0.083
A,F,0.083
A,G,0.333
A,H,0.333
B,D,0.500
B,E,0.250
B,F,0.250
C,G,0.500
C,H,0.500
50.0 %
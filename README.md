# MapReduce-ReduceSideJoin

Instruction of SBG Big Data Craft Demonstration


How to use the code :


Setup M2Eclipse with dependencies, or install hadoop locally for your computer. 


If you use Maven repository in your Eclipse, by installing and creating a Maven project with setting dependencies, you could follow the next steps:


Put all of the java classes into the Maven project you created.


Click Run Configuration.
Select “Java Application” and “Driver” in left column.
In “Main” section, choose the project you want to run(‘hadoop’), and then search your main class(‘myhadoop.Driver’). 
Click ‘Apply’, then ‘Run’.

In “Arguments” section, add four program arguments, separate them by only one space. 
The four arguments should be absolute path of: sales information data, customer information data, intermediate result location you wish, final result location you wish.
Click ‘Apply’, then ‘Run’.



You could see the intermediate result and final result in the location you filled in program arguments.


Open your terminal, cd into final folder.
Then type ‘cat part-r-00000 > output.csv’.



Then a new file ‘output.csv’ would come out in your final folder. This is the final result.


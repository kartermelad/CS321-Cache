Project 01: Webpage Cache
Author: Karter Melad
Class: CS321 Section #001
Semester: Fall 2023

Overview
This is an implementation of a Cache using a linked list. The Cache can store webpages using the methods definied in the Cache file. The CacheTest
file will read test files and generate output for the user to make sure the Cache is working properly.

Reflection
Working on this project I was faced with multiple different issues. The two major problems I pursued was double checking my Cache methods so they were working properly and outputting the correct format for the tests. This coding required for this assignment is not a ton but needs debugging often to
make sure everything is working properly. I enjoyed writing the tester class because I have written methods similar to the Cache ones before. The less desirable part is usually debugging. Sometimes debugging a single issue will cause other issues throughout the code. I spent a lot of time reviewing my code and using Visual Studio Code's debugging tools. 

Compiling and Using
To compile this program the user should run 'javac *.java' first. Secondly the user should submit 'java CacheTest [size] [number of webpages] [standard deviation] [debug level] [seed(optional)]'. While the user is responsible for entering in a value for each of the categories. Seed is optional, though.

java CacheTest <cache-size> <number-of-Webpages>  
               <standard-deviation> <debug-level=0-3> [<seed>] 
where:
<cache size>: The size of the cache.
<number-of-Webpages>: The amount of Webpages to generate.
<standard-deviation>: The standard deviation of Webpage generation.
<debug-level=0,1,2,3>: Level of debug to output:
<0>: Prints out cache stats (Figure 1)
<1>: Prints out the the Webpage distribution (Figure 2)
<2>: Prints out summarized content of the Webpages (Figure 3)
<3>: Prints out the whole content of the Webpages
[<seed>]:  Square brackets denote an optional argument. Using a seed ensures simulation can be repeated for a random number generator


Results
The Cache.java and CacheTest.java that were asked to be created are functional and able to be used by the user.

Sources used
geeksforgeeks.org
stackoverflow.com
# HSPF BIS2151 Testat1
 
This is the first of five practical examinations carried out as part of the course *'Introduction to Programming'* at Pforzheim University in the Summer term of 2020. 

Over the course of the semester, students are grouped in teams of two and asked to complete various tasks related to object-oriented programming.

Our team, consisting of Lukas Gabriel and Cedric Jansen, chose GitHub for Version Control to make collaboration easier. Now that we passed all five examinations, we want to share our code with other students of later semesters who might be faced with similar tasks.

---

The learning objective of **Testat #1** is as follows:
*"[The students] know first Java basics and can program a short procedural process in Java."*

While Tasks One to Three are of theoretical nature, Task Four requires the students to implement a simple command-line application in Java called 'Virus Calculator':
The application takes **four** arguments:
- The **number of infected people** at the start of the calculation,
- the **number of weeks** the calculation has to run,
- the **weekly increase of infections** in percent and
- the **mortality rate** for this disease in percent.

The complete task description can be found in 'Testat_1.pdf'

---

We implemented these functions in Java (*src\testat\pkg1\pkg319191\Viruscalculator.java*) and Python (*etc\virus_calculator.py*).

A sample query might look like this:  
```
100 26 5.5 3.5
``` 
And produce the following output in both versions of the program:
```
Viruscalculator will calculate with 100 persons at start and run for 26 weeks with an increase of infections of 25.5% and a mortality of 3.5%:
Week   Infections   Deaths
1       100       4
2       125       4
3       158       6
4       198       7
5       248       9
6       311       11
7       391       14
8       490       17
9       615       22
10       772       27
11       969       34
12       1216       43
13       1527       53
14       1916       67
15       2404       84
16       3018       106
17       3787       133
18       4753       166
19       5965       209
20       7486       262
21       9395       329
22       11790       413
23       14797       518
24       18570       650
25       23305       816
26       29248       1024
```
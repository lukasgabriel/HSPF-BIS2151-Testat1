# **BIS2151E** - Programming in Java - Prof. Dr. Burkard
## **Testat No. 1 Theory** - Jansen/Gabriel

### **Task 1:** Initialisation
If you read this, task 1 is finished.

### **Task 2:** Bad identifiers

    - 03/17/2020  
    Is indeed a bad variable name. The '/' char is reserved for arithmetic operations ( here division ) and is interpreted as such. Forbidden to use in variable declarations.

    - CourseNumberJava
    Does not follow the "lowerCamelCase"-notation that is used for easy readability. Better: javaCourseNumber

    - best grade in SS20
    Spaces are definitely not allowed in variable declaration and would throw an error. Better: bestGradeInSS20.

    - 1stAttestation
    Declared variables cannot start with a digit number. Better: firstAttestation.

    - fußgröße
    I assume characters like 'ß' and 'ö' that are not universal should not be used when declaring a variable.
    Best practice would be to avoid umlauts to keep the code readable by non-german speakers and keep the variable names URL-safe and encoding-neutral. Better: fussgroesse.

    - bestaveragerating
    Does not follow the "lowerCamelCase"-notation. Better: bestAverageRating.

    - netto+VAT
    The plus operator is reserved for arithmetic operations and cannot be used when declaring variables. Better: sumNettoVAT.

    - s
    Is no meaningful word and thus should not be used when declaring a variable. It is not clear to what a value 's' might referece.

### **Task 3:** Variable Names
```java
    double creditAccountBalance;
    int orderedArticleQuantity;
    String vehicleTyreDot;
    float monthlyInstalmentRate;
    String matriculationNumber;
```
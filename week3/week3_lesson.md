## Week 3 - Equivalence Partitioning and Boundary Value Analysis

Suppose a program reads in an integer and prints whether it is negative, neutral, or positive. It is not feasible to test the program with every possible integer value, so a subset of integers must be selected for testing.

**Equivalence Partitioning** and **Boundary Value Analysis** are functional (opaque-box) testing technique designed to reduce the total number of test cases to a finite set, while also covering the functional requirements.
You'll use these techniques to develop test cases for the week 3 programming projects.

### Equivalence Partitioning

**Equivalence Partitioning**, also called **Equivalence Class Partitioning (ECP)**,
partitions the input domain into equivalence classes based on the similarity of input values. Each value within an equivalence class should display the same output behavior as all other values in that class.

- If one value in an equivalence class passes a test, all values in the class are expected to pass.
- If one value in an equivalence class fails a test, all values in the class should likewise fail.

Test cases are written to ensure each equivalence class is covered at least once.

**Example #1:** A program determines whether a gpa is in the range of [0.0, 4.0].

There are three equivalence classes:

| Invalid gpa | Valid gpa | Invalid gpa |
| ----------- | --------- | ----------- |
| < 0.0       | 0.0 - 4.0 | > 4.0       |

ECP testing requires a minimum of one test per equivalence class. For example:

| Test | Expected I/O             | Actual I/O | Status | Equivalence<br>Class |
| ---- | ------------------------ | ---------- | ------ | -------------------- |
| 1    | gpa: **-1.0**<br>Invalid |            |        | <0.0                 |
| 2    | gpa: **2.5**<br>Valid    |            |        | 0.0 - 4.0            |
| 3    | gpa: **5.7**<br>Invalid  |            |        | >4.0                 |

**Example #2:** A program determines whether a number represents a 6 digit product code.

There are three equivalence classes:

| Invalid product code | Valid product code | Invalid product code |
| -------------------- | ------------------ | -------------------- |
| <6 digits            | 6 digits           | >6 digits            |

ECP testing requires a minimum of one test per equivalence class. For example:

| Test | Expected I/O                    | Actual I/O | Status | Equivalence<br>Class |
| ---- | ------------------------------- | ---------- | ------ | -------------------- |
| 1    | product: **4321**<br>Invalid    |            |        | <6 digits            |
| 2    | product: **555442**<br>Valid    |            |        | 6 digits             |
| 3    | product: **1234567**<br>Invalid |            |        | >6 digits            |

**Example #3:** A program determines if the age represents a legal adult (i.e. at least 18).

There are two equivalence classes:

| Not legal age | Legal age |
| ------------- | --------- |
| < 18          | >= 18     |

ECP testing requires a minimum of one test per equivalence class. For example:

| Test | Expected I/O             | Actual I/O | Status | Equivalence<br>Class |
| ---- | ------------------------ | ---------- | ------ | -------------------- |
| 1    | age: **10**<br>Not legal |            |        | < 18>                |
| 2    | age: **32**<br>Legal     |            |        | >= 18                |

**Example #4:** Write a program to read in a numeric score between 0 and 100 and print the corresponding letter grade.

Let's assume standard letter assignment. Given that a score range of 0 to 100 is specified, we divide the test cases into seven equivalence classes to cover the five valid and two invalid input ranges.

| Invalid | F    | D     | C     | B     | A      | Invalid |
| ------- | ---- | ----- | ----- | ----- | ------ | ------- |
| < 0     | 0-59 | 60-69 | 70-79 | 80-89 | 90-100 | >100    |

We'll test the following program, which fails to differentiate between a valid score of A and an invalid score above 100.

```java
import java.util.Scanner;

public class BuggyGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Score: ");
        int score = input.nextInt();

        // ERROR, missing condition for  score > 100
        if (score < 0) {
            System.out.println(score + " is invalid");
        } else if (score < 60) {
            System.out.println("F");
        } else if (score < 70) {
            System.out.println("D");
        } else if (score < 80) {
            System.out.println("C");
        } else if (score < 90) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
```

One representative value from each equivalence class is selected. The last test fails to produce the expected output.

| Test | Expected I/O                     | Actual I/O                       | Status | Equivalence<br>Class |
| ---- | -------------------------------- | -------------------------------- | ------ | -------------------- |
| 1    | Score: **-10**<br>-10 is invalid | Score: **-10**<br>-10 is invalid | Pass   | <0                   |
| 2    | Score: **52**<br>F               | Score: **52**<br>F               | Pass   | 0-59                 |
| 3    | Score: **60**<br>D               | Score: **60**<br>D               | Pass   | 60-69                |
| 4    | Score: **79**<br>C               | Score: **79**<br>C               | Pass   | 70-79                |
| 5    | Score: **85**<br>B               | Score: **85**<br>B               | Pass   | 80-89                |
| 6    | Score: **93**<br>A               | Score: **93**<br>A               | Pass   | 90-100               |
| 7    | Score: **105**<br>105 is invalid | Score: **105**<br>A              | Fail   | > 100                |

A coding error was identified using just one value from the **> 100** equivalence class.

### Boundary Value Analysis

Boundary value analysis is a type of equivalence partitioning that focuses on testing the values on or near partition boundaries.

## Comparing Equivalence Partitioning and Boundary Value Analysis

## Conclusion

....

...

## Resources

Java files for this lesson are available at [https://github.com/linda-seiter/cmsc115_2252](https://github.com/linda-seiter/cmsc115_2252)

<!--
<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>
>

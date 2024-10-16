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

**Example #1:** A program determines whether input is a valid gpa between 0.0 and 4.0.

There are three equivalence classes:

| Invalid | Valid gpa | Invalid |
| ------- | --------- | ------- |
| < 0.0   | 0.0 - 4.0 | > 4.0   |

ECP testing requires a minimum of one test per equivalence class. For example:

| Test | Expected I/O             | Actual I/O | Status | Equivalence<br>Class |
| ---- | ------------------------ | ---------- | ------ | -------------------- |
| 1    | gpa: **-1.0**<br>Invalid |            |        | <0.0                 |
| 2    | gpa: **2.5**<br>Valid    |            |        | 0.0 - 4.0            |
| 3    | gpa: **5.7**<br>Invalid  |            |        | >4.0                 |

**Example #2:** A program determines whether a number represents a 6 digit product code.

There are three equivalence classes:

| Invalid   | Valid product code | Invalid   |
| --------- | ------------------ | --------- |
| <6 digits | 6 digits           | >6 digits |

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

**Example #4:** Write a program to read in a month and determine the nightly rate. Off-season stays (October - April) are discounted 20%.

There are two equivalence classes:

| In-season       | Off-season    |
| --------------- | ------------- |
| May - September | October-April |

**Example #5:** Write a program to read in a numeric score between 0 and 100 and print the corresponding letter grade.

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

A coding error was identified using one value from the **> 100** equivalence class.

### Boundary Value Analysis

Boundary value analysis (BVA) is a type of equivalence partitioning that focuses on testing the values on or near partition boundaries, as this is where logic errors often occur.

![range boundaries](images/range_boundaries.png)

When an input domain has a specified range [min, max], the min and max represent the boundaries or edges that separate valid and invalid values.
We design the test cases to include input values at the min/max, just below the min/max, just above the min/max, and a nominal value (optional). An offset of 1 is used if the boundary is an integer and 0.1 if it is a double. The nominal value is typically chosen as (max + min) / 2.

**Example #1 (1 variable):** A program requires an age between 18 - 65 as input.

BVA test case design will select input values from the three equivalence classes as shown:

| Invalid Age<br>min-1 | Valid Age<br>min,min+1,nominal,max-1,max | Invalid Age<br>max+1 |
| -------------------- | ---------------------------------------- | -------------------- |
| 17                   | 18, 19, 41, 64, 65                       | 66                   |

**Example #2 (2 variables):** Most people feel comfortable when the indoor humidity level is between 40 and 60 and indoor temperature is between 65 and 75. Any point that falls within the light blue rectangle in the graph below represents a comfortable indoor condition. We'll use BVA techniques to reduce the number of points used for testing.

![comfortable indoor conditions](images/comfyindoors.png)

BVA for the range [40, 60] determines 7 **humidity** input values:

| Uncomfortable<br>min-1 | Comfortable Humidity<br>min,min+1,nominal,max-1,max | Uncomfortable<br>max+1 |
| ---------------------- | --------------------------------------------------- | ---------------------- |
| 39                     | 40, 41, 50, 59, 60                                  | 61                     |

BVA for the range [65, 75] determines 7 **temperature** input values:

| Uncomfortable<br>min-1 | Comfortable Temperature<br>min,min+1,nominal,max-1,max | Uncomfortable<br>max+1 |
| ---------------------- | ------------------------------------------------------ | ---------------------- |
| 64                     | 65, 66, 70, 74, 75                                     | 76                     |

Is it necessary to test every combination of the 7 humidity and 7 temperature values? The answer is no if we make a **single fault assumption**, which states that failures are only rarely the result of the simultaneous occurrence of two (or more) faults. This means we can create test cases that combine each of the 7 humidity levels with the nominal temperature, and each of the 7 temperatures with the nominal humidity. Two test cases represent the same input (nominal humidity, nominal temperature), thus we need only 13 test cases.

In general, N variables require 6N + 1 test cases for VBA.

- 4N+1 cases on or within the boundaries.
- 2N cases just outside a boundary.

Two variables (humidity, temperature) thus require 6\*2+1 = 13 test cases.

- 9 test cases for points inside the rectangle (black, blue, yellow dots)
- 4 test cases for points outside the rectangle (red dots).

| Test | Expected I/O                                         | Actual I/O | Status | (humidity, temperature)    |
| ---- | ---------------------------------------------------- | ---------- | ------ | -------------------------- |
| 1    | Humidity and Temperature: **50 70**<br>Comfortable   |            |        | (nom, nom) <br>black dot   |
| 2    | Humidity and Temperature: **40 70**<br>Comfortable   |            |        | (min, nom) <br>blue dot    |
| 3    | Humidity and Temperature: **41 70**<br>Comfortable   |            |        | (min+1, nom)<br> blue dot  |
| 4    | Humidity and Temperature: **59 70**<br>Comfortable   |            |        | (max-1, nom)<br>blue dot   |
| 5    | Humidity and Temperature: **60 70**<br>Comfortable   |            |        | (max, nom)<br>blue dot     |
| 6    | Humidity and Temperature: **50 65**<br>Comfortable   |            |        | (nom, min)<br>yellow dot   |
| 7    | Humidity and Temperature: **50 66**<br>Comfortable   |            |        | (nom, min+1)<br>yellow dot |
| 8    | Humidity and Temperature: **50 74**<br>Comfortable   |            |        | (nom, max-1)<br>yellow dot |
| 9    | Humidity and Temperature: **50 75**<br>Comfortable   |            |        | (nom, max)<br>yellow dot   |
| 10   | Humidity and Temperature: **39 70**<br>Uncomfortable |            |        | (min-1, nom)<br>red dot    |
| 11   | Humidity and Temperature: **61 70**<br>Uncomfortable |            |        | (max+1, nom)<br>red dot    |
| 12   | Humidity and Temperature: **50 64**<br>Uncomfortable |            |        | (nom, min-1)<br>red dot    |
| 13   | Humidity and Temperature: **50 76**<br>Uncomfortable |            |        | (nom, max+1)<br>red dot    |

## Conclusion

Equivalence Partitioning and Boundary Value Analysis are two common functional testing techniques for reducing the number of test cases.

| Equivalence Partitioning                                                                 | Boundary Value Analysis                                                                                       |
| ---------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| Representative values from valid and invalid equivalence classes are used for test cases | The following are used for test cases:<br>min-1<br>min<br>min+1<br>nominal(optional)<br>max-1<br>max<br>max+1 |
| Identifies bugs within equivalence classes                                               | Identifies bugs at the boundaries of equivalence classes                                                      |

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

## Week 2 - Specification-Based (opaque-box) Testing

A key goal of software testing is to detect and resolve errors in the code.

While numerous software testing techniques exist, CMSC 115 presents two popular approaches:

- **Specification-Based Testing (opaque-box)** assesses a program's functionality without examining its internal structure.
  Tests are created based on the program's requirements and the characteristics of the input domain.

- **Structure-Based Testing (clear-box)** analyzes a program's internal structures and logic to
  evaluate how thoroughly the tests exercise the program.

Specification-based testing techniques will be used for the week#2 programming projects.

### Example #1 - Convert Inches to Feet

Consider the following program requirements:

_Write a program that converts inches to feet. The program should read in an integer representing the number of inches, then calculate and display the equivalent number of feet. There are 12 inches in a foot._

The table below contains 5 test cases that will be used for testing a program.

- The **Expected I/O** (Input/Output) column can be filled out based on the specified program requirements. Input values are displayed in bold.
- The **Actual I/O** and **Status** columns are filled out after writing and executing the program. `Status` will contain **Pass/Fail** based on whether the expected and actual I/O columns match.

| Test | Expected I/O                                     | Actual I/O | Status |
| ---- | ------------------------------------------------ | ---------- | ------ |
| 1    | Enter inches: <b>3</b><br>3 inches = 0.25 feet   |            |        |
| 2    | Enter inches: <b>12</b><br>12 inches = 1.0 feet  |            |        |
| 3    | Enter inches: <b>18</b><br>18 inches = 1.5 feet  |            |        |
| 4    | Enter inches: <b>24</b><br>24 inches =2.0 feet   |            |        |
| 5    | Enter inches: <b>33</b><br>33 inches = 2.75 feet |            |        |

<div style="page-break-after: always"></div>

The `InchesToFeet` class represents a possible solution:

```java
import java.util.Scanner;

/**
 * InchesToFeet reads the number of inches from user input
 * and prints the equivalent number of feet.
 */
public class InchesToFeet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter inches: ");
        int inches = input.nextInt();
        double feet = inches / 12; //ERROR: integer division
        System.out.println(inches + " inches = " + feet + " feet");
    }
}
```

TODO: Incorporate Possible Online Versions?

- [InchesToFeet using Java Visualizer](<https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=import+java.util.Scanner%3B%0A%0A/**%0A+*+InchesToFeet+reads+the+number+of+inches+from+user+input%0A+*+and+prints+the+equivalent+number+of+feet.%0A+*/%0Apublic+class+InchesToFeet+%7B%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Scanner+input+%3D+new+Scanner(System.in)%3B%0A++++++++System.out.print(%22Enter+inches%3A+%22)%3B%0A++++++++int+inches+%3D+input.nextInt()%3B%0A++++++++double+feet+%3D+inches+/+12%3B+//ERROR%3A+integer+division%0A++++++++System.out.println(inches+%2B+%22+inches+%3D+%22+%2B+feet+%2B+%22+feet%22)%3B%0A++++%7D%0A%7D&mode=edit&stdin=18%0A>)
- [InchesToFeet using https://onlinegdb.com](https://onlinegdb.com/NSw4HI2UG7)

onlinegdb iframe:

<iframe sandbox="allow-forms allow-modals" title="InchesToFeet.java in online code editor" scrolling="yes" height="800" width="100%" src="https://onlinegdb.com/NSw4HI2UG7"></iframe>

Java visualizer iframe:

<iframe height="800" width="100%" scrolling="yes"  
src="https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=import+java.util.Scanner%3B%0A%0A/**%0A+*+InchesToFeet+reads+the+number+of+inches+from+user+input+and+prints+the%0A+*+equivalent+number+of+feet.%0A+*/%0Apublic+class+InchesToFeet+%7B%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Scanner+input+%3D+new+Scanner(System.in)%3B%0A++++++++System.out.print(%22Enter+inches%3A+%22)%3B%0A++++++++int+inches+%3D+input.nextInt()%3B%0A++++++++double+feet+%3D+inches+/+12%3B+//+ERROR%3A+integer+division%0A++++++++System.out.println(inches+%2B+%22+inches+%3D+%22+%2B+feet+%2B+%22+feet%22)%3B%0A++++%7D%0A%7D&mode=display&stdin=18&curInstr=0"></iframe>

The program must be executed for each test case to obtain the actual output. While the tests for 12 and 24 inches pass, the other tests fail.

| Test | Expected I/O                                     | Actual I/O                                      | Status |
| ---- | ------------------------------------------------ | ----------------------------------------------- | ------ |
| 1    | Enter inches: <b>3</b><br>3 inches = 0.25 feet   | Enter inches: <b>3</b><br>3 inches = 0.0 feet   | Fail   |
| 2    | Enter inches: <b>12</b><br>12 inches = 1.0 feet  | Enter inches: <b>12</b><br>12 inches = 1.0 feet | Pass   |
| 3    | Enter inches: <b>18</b><br>18 inches = 1.5 feet  | Enter inches: <b>18</b><br>18 inches = 1.0 feet | Fail   |
| 4    | Enter inches: <b>24</b><br>24 inches =2.0 feet   | Enter inches: <b>24</b><br>24 inches =2.0 feet  | Pass   |
| 5    | Enter inches: <b>33</b><br>33 inches = 2.75 feet | Enter inches: <b>33</b><br>33 inches = 2.0 feet | Fail   |

A failed test indicates an error exists in the code!

Recall how division works in Java. If both operands are integers, the result is an integer and any remainder is discarded. However, if either operand is a floating point number, the result is a floating point number.

| Expression | Value |
| ---------- | ----- |
| 18 / 12    | 1     |
| 18 / 12.0  | 1.5   |

To avoid integer division, the code should be updated to use 12.0 as the divisor:

```java
double feet = inches / 12.0;
```

After updating the code, the program must be re-executed for every test case to confirm the actual and expected I/O match. _It is important to re-execute all tests and not just the failed tests because an update might accidentally introduce new errors_.

| Test | Expected I/O                                     | Actual I/O                                       | Status |
| ---- | ------------------------------------------------ | ------------------------------------------------ | ------ |
| 1    | Enter inches: <b>3</b><br>3 inches = 0.25 feet   | Enter inches: <b>3</b><br>3 inches = 0.25 feet   | Pass   |
| 2    | Enter inches: <b>12</b><br>12 inches = 1.0 feet  | Enter inches: <b>12</b><br>12 inches = 1.0 feet  | Pass   |
| 3    | Enter inches: <b>18</b><br>18 inches = 1.5 feet  | Enter inches: <b>18</b><br>18 inches = 1.5 feet  | Pass   |
| 4    | Enter inches: <b>24</b><br>24 inches =2.0 feet   | Enter inches: <b>24</b><br>24 inches =2.0 feet   | Pass   |
| 5    | Enter inches: <b>33</b><br>33 inches = 2.75 feet | Enter inches: <b>33</b><br>33 inches = 2.75 feet | Pass   |

### Example #2 - Converting years to minutes

Consider the following program requirements:

_Write a program that converts years to minutes. The program should read in an integer representing the number of years, then calculate and display the equivalent number of minutes. Assume a year has 365 days, a day has 24 hours, and an hour has 60 minutes._

The requirements do not specify a particular range of values for years, other than stating the input is an integer. We'll use the following test cases:

| Test | Expected I/O                                   | Actual I/O | Status |
| ---- | ---------------------------------------------- | ---------- | ------ |
| 1    | Enter years: <b>1</b><br>525600 minutes        |            |        |
| 2    | Enter years: <b>2</b><br>1051200 minutes       |            |        |
| 3    | Enter years: <b>1000</b><br>525600000 minutes  |            |        |
| 4    | Enter years: <b>5000</b><br>2628000000 minutes |            |        |

The `YearsToMinutes` class represents a possible solution:

```java
import java.util.Scanner;

/**
 * YearsToMinutes reads the number of years from user input
 * and prints the equivalent number of minutes.
 */
public class YearsToMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter years: ");
        int years = input.nextInt();
        int minutes = years * 365 * 24 * 60; // ERROR: Overflow
        System.out.println(minutes + " minutes");
    }
}
```

We'll execute `YearsToMinutes` for each test case. Notice the last test fails to produce the expected result.

| Test | Expected I/O                                   | Actual I/O                                      | Status |
| ---- | ---------------------------------------------- | ----------------------------------------------- | ------ |
| 1    | Enter years: <b>1</b><br>525600 minutes        | Enter years: <b>1</b><br>525600 minutes         | Pass   |
| 2    | Enter years: <b>2</b><br>1051200 minutes       | Enter years: <b>2</b><br>1051200 minutes        | Pass   |
| 3    | Enter years: <b>1000</b><br>525600000 minutes  | Enter years: <b>1000</b><br>525600000 minutes   | Pass   |
| 4    | Enter years: <b>5000</b><br>2628000000 minutes | Enter years: <b>5000</b><br>-1666967296 minutes | Fail   |

An **overflow** occurs when a calculation produces a result that is too large for the declared data type of a variable.

- An `int` is a 32-bit signed integer data type that can store whole numbers ranging from: -2,147,483,648 to 2,147,483,647. Java provides constants `Integer.MIN_VALUE` and `Integer.MAX_VALUE` for these values.
- The last test case results in an overflow error because `minutes` is declared as an `int` and can't store a value as large as 2,626,000,000.

A `long` can store a value as large as 9,223,372,036,854,775,807. Assume the code is updated to declare the variable as `long`:

```java
long minutes = years * 365 * 24 * 60;
```

After updating the code, the program is re-executed for each test case. Unfortunately, the last test case still fails as shown below:

| Test | Expected I/O                                   | Actual I/O                                      | Status |
| ---- | ---------------------------------------------- | ----------------------------------------------- | ------ |
| 1    | Enter years: <b>1</b><br>525600 minutes        | Enter years: <b>1</b><br>525600 minutes         | Pass   |
| 2    | Enter years: <b>2</b><br>1051200 minutes       | Enter years: <b>2</b><br>1051200 minutes        | Pass   |
| 3    | Enter years: <b>1000</b><br>525600000 minutes  | Enter years: <b>1000</b><br>525600000 minutes   | Pass   |
| 4    | Enter years: <b>5000</b><br>2628000000 minutes | Enter years: <b>5000</b><br>-1666967296 minutes | Fail   |

Although the variable `minutes` on the left-hand side of the assignment is declared as a long, the expression on the right-hand side produces an int:

```java
long minutes = years * 365 * 24 * 60;
```

Why does this happen? The expression `years * 365 * 24 * 60` produces an `int` because the variable `years` is declared as an `int` and the numeric literals 365, 24, and 60 are also integers. The solution is to either cast `years` as a long, or to specify the first numeric literal value as a long by append `L`.

| Expression          | Type |
| ------------------- | ---- |
| years \* 365        | int  |
| (long) years \* 365 | long |
| years \* 365L       | long |

We'll update the code to cast the `years` variable as a `long`. Note this does not modify the actual type of the variable `years`, rather it creates a temporary copy of the value stored in memory as a long.

```java
long minutes = (long) years * 365 * 24 * 60;
```

The tests are re-executed, resulting in success:

| Test | Expected I/O                                   | Actual I/O                                     | Status |
| ---- | ---------------------------------------------- | ---------------------------------------------- | ------ |
| 1    | Enter years: <b>1</b><br>525600 minutes        | Enter years: <b>1</b><br>525600 minutes        | Pass   |
| 2    | Enter years: <b>2</b><br>1051200 minutes       | Enter years: <b>2</b><br>1051200 minutes       | Pass   |
| 3    | Enter years: <b>1000</b><br>525600000 minutes  | Enter years: <b>1000</b><br>525600000 minutes  | Pass   |
| 4    | Enter years: <b>5000</b><br>2628000000 minutes | Enter years: <b>5000</b><br>2628000000 minutes | Pass   |

## Conclusion

With specification-based testing, the test cases are developed based on requirements of what the program should do,
rather than specific details of how it is implemented.

The week#2 programming projects will be tested using the specification-based testing techniques presented in this lesson.
Each test case will describe:

- the expected I/O based on the requirements
- the actual I/O based on the program execution
- the test result of pass/fail

## Resources

Java files for this lesson are available at [https://github.com/linda-seiter/cmsc115_2252](https://github.com/linda-seiter/cmsc115_2252)

<!--
<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>
>

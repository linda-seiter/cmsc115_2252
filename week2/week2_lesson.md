## Week 2 - Unit Testing

Testing is a critical part of software development that involves executing a program to identify errors in the code.

There are many different software testing methodologies, techniques, and tools. CMSC 115 introduces two basic testing approaches:

- **Black-box Testing** assesses program functionality based on requirements of what the program should do, without looking into the details of how the program is implemented. To perform black-box testing in CMSC 115, we will develop test cases that map a program input to an expected output, or map a method call to an expected return value.

- **White Box Testing** assesses program functionality based on its implementation. To perform white-box testing in CMSC 115, we will develop test cases to cover various execution paths through a program.

The week#2 projects will be tested using black-box testing techniques. Each test case will specify:

- the user input
- the expected output
- the actual output
- the test result

### Example #1 - Convert Inches to Feet

Consider the following program requirements:

_Write a program that converts inches to feet. The program should prompt the user to enter an integer representing the number of inches, then calculate and display the equivalent number of feet. There are 12 inches in a foot._

The table below contains 5 test cases that will be used for testing.

| Test | Input | Expected Output       | Actual Output | Pass/Fail |
| ---- | ----- | --------------------- | ------------- | --------- |
| 1    | 3     | 3 inches = 0.25 feet  |               |           |
| 2    | 12    | 12 inches = 1.0 feet  |               |           |
| 3    | 18    | 18 inches = 1.5 feet  |               |           |
| 4    | 24    | 24 inches = 2.0 feet  |               |           |
| 5    | 33    | 30 inches = 2.75 feet |               |           |

The last two columns are filled out by executing the program to obtain the actual output and comparing it to the expected output.

<div style="page-break-after: always"></div>

We'll execute each test case using the `InchesToFeet` class:

```java
import java.util.Scanner;

/**
 * InchesToFeet reads the number of inches from user input and prints the
 * equivalent number of feet.
 */
public class InchesToFeet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter inches: ");
        int inches = input.nextInt();
        double feet = inches / 12;
        System.out.println(inches + " inches = " + feet + " feet");
    }
}
```

The table is updated to record the actual output and result. While the tests for 12 and 24 inches pass, the other tests fail to produce the correct result.

| Test | Input | Expected Output       | Actual Output        | Pass/Fail |
| ---- | ----- | --------------------- | -------------------- | --------- |
| 1    | 3     | 3 inches = 0.25 feet  | 3 inches = 0.0 feet  | Fail      |
| 2    | 12    | 12 inches = 1.0 feet  | 12 inches = 1.0 feet | Pass      |
| 3    | 18    | 18 inches = 1.5 feet  | 18 inches = 1.0 feet | Fail      |
| 4    | 24    | 24 inches = 2.0 feet  | 24 inches = 2.0 feet | Pass      |
| 5    | 33    | 33 inches = 2.75 feet | 33 inches = 2.0 feet | Fail      |

Recall how division works in Java.
If both operands are integers, the result is an integer and any remainder is discarded. However,if either operand is a floating point number, the result is a floating point number.

| Expression | Value |
| ---------- | ----- |
| 18 / 12    | 1     |
| 18 / 12.0  | 1.5   |

The code should be updated to use 12.0 as the divisor to avoid integer division:

```java
double feet = inches / 12.0;
```

After updating the code, the program is re-executed for each test case to confirm the actual output matches the expected output:

| Test | Input | Expected Output       | Actual Output         | Pass/Fail |
| ---- | ----- | --------------------- | --------------------- | --------- |
| 1    | 3     | 3 inches = 0.25 feet  | 3 inches = 0.25 feet  | Pass      |
| 2    | 12    | 12 inches = 1.0 feet  | 12 inches = 1.0 feet  | Pass      |
| 3    | 18    | 18 inches = 1.5 feet  | 18 inches = 1.5 feet  | Pass      |
| 4    | 24    | 24 inches = 2.0 feet  | 24 inches = 2.0 feet  | Pass      |
| 5    | 33    | 33 inches = 2.75 feet | 33 inches = 2.75 feet | Pass      |

### Example #12 - Converting years to minutes

_Write a program that converts years to minutes. The program should prompt the user to enter an integer representing the number of years, then calculate and display the equivalent number of minutes. For simplicity, assume a year has 365 days._

The requirements do not specify a particular range of values for years, other than stating the input is an integer. We'll use the following test cases:

| Test | Input | Expected Output    | Actual Output | Pass/Fail |
| ---- | ----- | ------------------ | ------------- | --------- |
| 1    | 1     | 525600 minutes     |               |           |
| 2    | 2     | 1051200 minutes    |               |           |
| 3    | 1000  | 525600000 minutes  |               |           |
| 4    | 5000  | 2628000000 minutes |               |           |

Let's test the `YearsToMinutes` class for each test case:

```java
import java.util.Scanner;

/**
 * YearsToMinutes reads the number of years from user input and prints the equivalent number of minutes.
 */
public class YearsToMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        int minutes = years * 365 * 24 * 60;

        System.out.println(minutes + " minutes");
    }
}

```

Notice the last test fails to produce the correct result.

| Test | Input | Expected Output    | Actual Output       | Pass/Fail |
| ---- | ----- | ------------------ | ------------------- | --------- |
| 1    | 1     | 525600 minutes     | 525600 minutes      | Pass      |
| 2    | 2     | 1051200 minutes    | 1051200 minutes     | Pass      |
| 3    | 1000  | 525600000 minutes  | 525600000 minutes   | Pass      |
| 4    | 5000  | 2628000000 minutes | -1666967296 minutes | Fail      |

An **overflow** occurs when a calculation produces a result that is too large for the declared data type of a variable.

- An int is a 32-bit signed integer data type that can store whole numbers ranging from: -2,147,483,648 to 2,147,483,647.
- The last test case results in an overflow error because `minutes` is declared as an int and can't store a value as large as 2,626,000,000.

A `long` can store a value as large as 9,223,372,036,854,775,807. Assume the code is updated to declare the variable as `long`:

```java
long minutes = years * 365 * 24 * 60;
```

After updating the code, the program is re-executed for each test case. Unfortunately, the last test case still fails as shown below:

| Test | Input | Expected Output    | Actual Output       | Pass/Fail |
| ---- | ----- | ------------------ | ------------------- | --------- |
| 1    | 1     | 525600 minutes     | 525600 minutes      | Pass      |
| 2    | 2     | 1051200 minutes    | 1051200 minutes     | Pass      |
| 3    | 1000  | 525600000 minutes  | 525600000 minutes   | Pass      |
| 4    | 5000  | 2628000000 minutes | -1666967296 minutes | Fail      |

The variable `years` is declared as an int, thus `years * 365 * 24 * 60` produces an int and results in an overflow error. The solution is to either cast `years` as a long in the calculation, or to specify one of the literal values as a long by append `L`.

| Expression          | Result Type |
| ------------------- | ----------- |
| years \* 365        | int         |
| (long) years \* 365 | long        |
| years \* 365L       | long        |

We'll update the code as shown below, converting `years` from int to long before performing the multiplication.

```java
long minutes = (long) years * 365 * 24 * 60;
```

Executing the updated program for each test case results in success:

| Test | Input | Expected Output    | Actual Output      | Pass/Fail |
| ---- | ----- | ------------------ | ------------------ | --------- |
| 1    | 1     | 525600 minutes     | 525600 minutes     | Pass      |
| 2    | 2     | 1051200 minutes    | 1051200 minutes    | Pass      |
| 3    | 1000  | 525600000 minutes  | 525600000 minutes  | Pass      |
| 4    | 5000  | 2628000000 minutes | 2628000000 minutes | Pass      |

<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>

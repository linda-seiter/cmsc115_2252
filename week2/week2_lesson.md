## Week 2 - Unit Testing

Testing is a critical part of software development that often involves executing a program to identify errors in the code.

There are many different software testing methodologies, techniques, and tools. We will focus on two basic approaches of software testing: black-box or white-box testing:

- **Black-box Testing:** Assesses program functionality based on requirements of what the program should do, without looking into the details of how the program is implemented. To perform black-box testing in CMSC 115, we will develop test cases that map a program input to an expected output, as well as test cases that map a method call to an expected return value.

- **White Box Testing:** Assesses program functionality based on its implementation. To perform white-box testing in CMSC 115, we will develop test cases to cover various execution paths through a program.

For the week#2 projects, we will perform basic black-box testing. Each test case will specify:

- the user input
- the expected output
- the actual output
- the test result

### Example

Let's consider the following program requirements:

_Write a program that prompts the user to enter a quantity of years (such as 1, 2, 1000, or 5000). The program should calculate and display the equivalent number of minutes. For simplicity, assume a year has 365 days._

While the requirements do not specify a valid range of input values, a set of sample values is provided. The sample values will be used for the test cases.

| Input | Expected Output    | Actual Output | Pass/Fail |
| ----- | ------------------ | ------------- | --------- |
| 1     | 525600 minutes     |               |           |
| 2     | 1051200 minutes    |               |           |
| 1000  | 525600000 minutes  |               |           |
| 5000  | 2628000000 minutes |               |           |

NOTE: The first two columns should be filled out before writing the code. The last two columns are filled out after writing and executing the code.

<div style="page-break-after: always"></div>

We'll execute each test case for the following program:

```java
import java.util.Scanner;

public class YearsToMinutes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the number of years
		System.out.print("Enter the number of years: ");
		int years = input.nextInt();

		//Convert years to minutes
		int days =years * 365;
		int hours = days * 24;
		int minutes = hours * 60;

		System.out.println(minutes + " minutes");
	}

}
```

Each test case is updated to record the actual output and result. Notice the last test fails to produce the correct result.

| Input | Expected Output    | Actual Output       | Pass/Fail |
| ----- | ------------------ | ------------------- | --------- |
| 1     | 525600 minutes     | 525600 minutes      | Pass      |
| 2     | 1051200 minutes    | 1051200 minutes     | Pass      |
| 1000  | 525600000 minutes  | 525600000 minutes   | Pass      |
| 5000  | 2628000000 minutes | -1666967296 minutes | Fail      |

An **overflow** occurs when a calculation produces a result that is too large for the declared data type of a variable. Similarly, an **underflow** occurs when the value is too small. An int is a 32-bit signed integer data type that can store whole numbers ranging from: -2,147,483,648 to 2,147,483,647. The last test case results in an overflow error because `minutes` is declared as an int and is not able to store a value as large as 2,626,000,000.

<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>

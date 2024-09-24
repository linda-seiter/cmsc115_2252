## Week 3 - White-box testing

White box testing techniques are based on code coverage, which measures of the percent of code executed by the tests. Some basic measures of code coverage include:

- **Statement Coverage:** The percent of statements executed at least once.
- **Branch Coverage:** The percent of branches executed at least once. For example, `if (x  < 10)` requires at least 2 tests:
  - `x < 10` is true
  - `x < 10` is false
- **Condition/Predicate Coverage:** The percent of boolean sub-expression in a compound boolean expression that evaluate to `true` and `false` at least once.
  - The compound boolean expression `(isSunny || isWeekend)` requires 4 tests that evaluate as shown:
    - `isSunny == true && isWeekend == true`
    - `isSunny == true && isWeekend == false`
    - `isSunny == false && isWeekend == true`
    - `isSunny == false && isWeekend == false`
- **Loop Coverage:** The percent of loops that have been executed at least zero times, one time, and two or more times.

### Statement Coverage - BuggyExample1.java

Consider the following program that reads in two numbers and compares them to find the smallest. Line numbers are displayed to the left of each line of code. The programmer copied the assignment statement from the `if` block (line 12) into the `else` block (line 14) and forgot to update the variable from `x` to `y`.

<img alt="BuggyExample1.java with line numbers" src="images/buggy1code.png" width="400">

The program control flow can be visually depicted using a flowchart as shown below. We will use a simplified flowchart notation, drawing decision points as diamonds and all other statements as a rectangle. The line number is displayed next to each node in the graph. Note that line 6 is omitted since a variable declaration (without assignment) is a compile-time rather than runtime statement.

| Flowchart                                                                    | Simplified                                                                      |
| ---------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| <img alt="flowchart with java statements" src="images/buggy1flowchart.png" > | <img alt="flowchart with line numbers" src="images/buggy1simpleflowchart.png" > |

There are two possible execution paths:

- `x <= y` is true: 7, 8, 9, 10, 11, 12, 16
- `x <= y` is false: 7, 8, 9, 10, 11, 14, 16

Assume the program is executed with the initial set of test cases shown below:

| Test | Input   | Expected Output | Actual Output   | Path              | Pass/Fail |
| ---- | ------- | --------------- | --------------- | ----------------- | --------- |
| 1    | 3 9     | smallest is 3   | smallest is 3   | 7,8,9,10,11,12,16 | Pass      |
| 2    | 150 275 | smallest is 150 | smallest is 150 | 7,8,9,10,11,12,16 | Pass      |
| 3    | 20 20   | smallest is 20  | smallest is 20  | 7,8,9,10,11,12,16 | Pass      |

All tests pass and the error on line 14 goes undetected.

**100% statement coverage** means every statement is executed by at least one test. The three test cases above **do not** achieve 100% statement coverage since line 14 is never executed.

100% statement coverage can be achieved by adding a fourth test such that `x <= y` is false, causing line 14 to be executed.

| Test | Input   | Expected Output | Actual Output   | Path              | Pass/Fail |
| ---- | ------- | --------------- | --------------- | ----------------- | --------- |
| 1    | 3 9     | smallest is 3   | smallest is 3   | 7,8,9,10,11,12,16 | Pass      |
| 2    | 150 275 | smallest is 150 | smallest is 150 | 7,8,9,10,11,12,16 | Pass      |
| 3    | 20 20   | smallest is 20  | smallest is 20  | 7,8,9,10,11,12,16 | Pass      |
| 4    | 25 10   | smallest is 10  | smallest is 25  | 7,8,9,10,11,14,16 | Fail      |

The fourth test case fails to produce the expected output, indicating an error exists in the code.

The error was not discovered until 100% statement coverage was achieved.

### Branch Coverage - BuggyExample2.java

Consider the following program that reads in a number and should print whether it is even or not. The `isEven` boolean variable is not initialized correctly on line 9.

<img alt="BuggyExample2.java with line numbers" src="images/buggy2code.png" width="400">

The program control flow is shown below:

| Flowchart                                                                     | Simplified                                                                      |
| ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| <img alt="flowchart2 with java statements" src="images/buggy2flowchart.png" > | <img alt="flowchart with line numbers" src="images/buggy2simpleflowchart.png" > |

There are two possible execution paths:

- `num %2 == 0` is true: 6, 7, 8, 9, 10, 11, 12
- `num %2 == 0` is false: 6, 7, 8, 9, 10, 12

Assume the program is executed with the test case shown below:

| Test | Input | Expected Output  | Actual Output    | Path             | Pass/Fail | Comment              |
| ---- | ----- | ---------------- | ---------------- | ---------------- | --------- | -------------------- |
| 1    | 6     | 6 is even : true | 6 is even : true | 6,7,8,9,10,11,12 | Pass      | num % 2 == 0 is true |

The test passes and the error on line 9 goes undetected.

Is 100% statement coverage achieved? Yes it is! The single test case causes every statement in the `main` method to execute. However, the error was not discovered because the `false` branch of the conditional statement was never executed.

**100% branch coverage** means every branch is executed by at least one test. For each decision point such as a conditional statement (if, if-else, etc), at least one test includes a path that follows the `true` branch and at least one test includes a path that follows the `false` branch.

We'll add a test with an odd number as input to force path that follows the `false` branch:

| Test | Input | Expected Output   | Actual Output    | Path             | Pass/Fail | Comment               |
| ---- | ----- | ----------------- | ---------------- | ---------------- | --------- | --------------------- |
| 1    | 6     | 6 is even : true  | 6 is even : true | 6,7,8,9,10,11,12 | Pass      | num % 2 == 0 is true  |
| 2    | 7     | 7 is even : false | 7 is even : true | 6,7,8,9,10,12    | Fail      | num % 2 == 0 is false |

The new test case fails to produce the expected output, indicating an error exists in the code.

The error was not discovered until 100% branch coverage was achieved.

<div style="page-break-after: always"></div>

<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>

## Resources

[https://app.code2flow.com/](https://app.code2flow.com/)

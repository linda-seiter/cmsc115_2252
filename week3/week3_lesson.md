## Week 3 - Equivalence Class Partitioning, Boundary Value Analysis, Decision Table Testing

It is not feasible to test a program with every
possible input value, so a subset of values must be selected.

This lesson presents three widely-used specification-based (opaque-box) testing techniques aimed at minimizing the overall number of test cases to a manageable set, while still ensuring coverage of the functional requirements.

- Equivalence Class Partitioning (ECP)
- Boundary Value Analysis (BVA)
- Decision Table Testing (DTT)

Each technique will be used to develop test cases for the week 3 programming projects.

### Equivalence Class Partitioning

**Equivalence Class Partitioning (ECP)**
divides the input domain into equivalence classes (also called partitions) based on the similarity of input values. Each value in an equivalence class should display the same program output behavior as all other values in that class.

The assumption is that for any single value _v_ in an equivalence class:

- If _v_ passes a test, all values in that class are expected to pass.
- If _v_ fails a test, all values in that class should likewise fail.

Test cases are written to ensure each equivalence class is covered at least once.

**Example #1:** A bank charges a $2 per transaction fee. The first 5 transactions are free.

This problem partitions input values based on a transaction limit of `5`. The value `5` is a boundary resulting in two equivalence classes:

| No fee | Transaction fee |
| ------ | --------------- |
| <= 5   | > 5             |

Each equivalence class should be covered by at least one test case. A random value
is selected from each equivalence class. For example:

| Test | Expected I/O                     | Actual I/O | Status | Equivalence<br>Class |
| ---- | -------------------------------- | ---------- | ------ | -------------------- |
| 1    | Transactions: <b>3</b><br>Fee $0 |            |        | <= 5                 |
| 2    | Transactions: <b>9</b><br>Fee $8 |            |        | >5                   |

The program `TransactionFee` has an error in calculating the fee when the transaction count exceeds the limit of 5.

```java
import java.util.Scanner;

public class TransactionFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Transactions: ");
        int transactions = input.nextInt();

        int fee = 0; // 1st 5 transactions are free

        // $2 per transaction above the limit of 5
        if (transactions > 5)
            fee = transactions * 2; // ERROR
        System.out.println(fee);
    }
}
```

We must execute `TransactionFee` for each test case to obtain the actual I/O and test status.

| Test | Expected I/O                     | Actual I/O                        | Status | Equivalence<br>Class |
| ---- | -------------------------------- | --------------------------------- | ------ | -------------------- |
| 1    | Transactions: <b>3</b><br>Fee $0 | Transactions: <b>3</b><br>Fee $0  | Pass   | <= 5                 |
| 2    | Transactions: <b>9</b><br>Fee $8 | Transactions: <b>9</b><br>Fee $18 | Fail   | >5                   |

Test #2 fails, indicating an error exists for input values
that fall into the `>5` equivalence class.

The correct calculation for the fee should be:

```java
fee = (transactions - 5) * 2;
```

**Example #2:** A valid gpa falls within the range of values 0.0 and 4.0.

The range has a minimum boundary of 0.0 and a maximum boundary of 4.0. The two boundaries result in three three equivalence classes (below minimum, between minimum and maximum, above maximum):

| Invalid | Valid gpa | Invalid |
| ------- | --------- | ------- |
| < 0.0   | 0.0 - 4.0 | > 4.0   |

Each equivalence class should be covered by at least one test case. For example:

| Test | Expected I/O                           | Actual I/O | Status | Equivalence<br>Class |
| ---- | -------------------------------------- | ---------- | ------ | -------------------- |
| 1    | Enter gpa: **-1.0**<br>-1.0 is invalid |            |        | < 0.0                |
| 2    | Enter gpa: **2.5**<br>2.5 is valid     |            |        | 0.0 - 4.0            |
| 3    | Enter gpa: **5.7**<br>5.7 is valid     |            |        | > 4.0                |

Let's test the `ValidGPA` class using the three test cases.

```java
import java.util.Scanner;

public class ValidGPA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("gpa: ");
        double gpa = input.nextDouble();

        // ERROR: Missing test for minimum value 0.0
        if (gpa <= 4.0) {
            System.out.println(gpa + " is valid");
        } else {
            System.out.println(gpa + " is invalid");
        }
    }
}
```

Test #1 fails to identify -1.0 as an invalid gpa. The failing test indicates a code error exists for values that fall within the `< 0.0` equivalence class.

| Test | Expected I/O                           | Actual I/O                           | Status | Equivalence<br>Class |
| ---- | -------------------------------------- | ------------------------------------ | ------ | -------------------- |
| 1    | Enter gpa: **-1.0**<br>-1.0 is invalid | Enter gpa: **-1.0**<br>-1.0 is valid | Fail   | < 0.0                |
| 2    | Enter gpa: **2.5**<br>2.5 is valid     | Enter gpa: **2.5**<br>2.5 is valid   | Pass   | 0.0 - 4.0            |
| 3    | Enter gpa: **5.7**<br>5.7 is valid     | Enter gpa: **5.7**<br>5.7 is valid   | Pass   | > 4.0                |

The condition should be adjusted to compare the user input against both the range minimum of 0.0 and range maximum of 4.0:

```java
if (gpa >= 0.0 && gpa <= 4.0)
```

### Boundary Value Analysis

Boundary Value Analysis (BVA) is a type of equivalence partitioning that focuses on testing the values on or near partition boundaries, as this is where logic errors often occur.

<img src="images/boundary.png" alt="single boundary with nearby points" width = 200>

We design the test cases to include the boundary value `b` and input values just above and below it.

- Typically, an offset of **1** is used if the boundary is an integer and **0.1** if the boundary is a double.

<img src="images/range_boundaries.png" width=500 alt="range [min,max]">

When an input domain has a specified range [min, max], the min and max represent two boundaries that separate valid and invalid values.

We design the test cases to include input values at the min/max, just below the min/max, just above the min/max, and a nominal value (optional).

- The optional nominal value is usually computed as (max + min) / 2.

While equivalence partitioning requires at least one value from each equivalence class, the choice of value may be arbitrary. Boundary value analysis on the other hand selects specific values:

| Invalid | Valid                           | Invalid |
| ------- | ------------------------------- | ------- |
| min-1   | min, min+1, nominal, max-1, max | max+1   |

**Example #1 (single boundary):** Consider a minimum age requirement to determine legal adulthood: `age is at least 18` . This results in two equivalence classes based on the minimum age boundary of 18:

<img src="images/adult.png" alt="age boundary at 18 with nearby points 17 and 19" width = 300>

BVA picks ages 17, 18, and 19 for testing:

| Test | Expected I/O         | Actual I/O | Status | min = 18 |
| ---- | -------------------- | ---------- | ------ | -------- |
| 1    | Age: **17**<br>Minor |            |        | min - 1  |
| 2    | Age: **18**<br>Adult |            |        | min      |
| 3    | Age: **19**<br>Adult |            |        | min + 1  |

The table below show several **correct** and **incorrect** ways the
condition might be written. Assume "Adult" is printed if the condition is true, otherwise "Minor" is printed.
The test set {17, 18, 19} is effective in identifying the incorrect conditions.

| Condition | 17    | 18    | 19    | Comment   |
| --------- | ----- | ----- | ----- | --------- |
| age > 17  | Minor | Adult | Adult | Correct   |
| age >= 18 | Minor | Adult | Adult | Correct   |
| age >= 17 | Adult | Adult | Adult | Incorrect |
| age > 18  | Minor | Minor | Adult | Incorrect |
| age == 18 | Minor | Adult | Minor | Incorrect |
| age < 18  | Adult | Minor | Minor | Incorrect |

**Example #2 (range for 1 variable):** A program requires an age between 18 - 65 as input.

BVA test case design selects input values from the three equivalence classes as shown:

| Invalid Age<br>min-1 | Valid Age<br>min,min+1,nominal,max-1,max | Invalid Age<br>max+1 |
| -------------------- | ---------------------------------------- | -------------------- |
| 17                   | 18, 19, 41, 64, 65                       | 66                   |

BVA picks ages 17, 18, 19, 41, 64, 65, and 66 for testing:

| Test | Expected I/O           | Actual I/O | Status | min = 18 |
| ---- | ---------------------- | ---------- | ------ | -------- |
| 1    | Age: **17**<br>Invalid |            |        | min - 1  |
| 2    | Age: **18**<br>Valid   |            |        | min      |
| 3    | Age: **19**<br>Valid   |            |        | min + 1  |
| 4    | Age: **41**<br>Valid   |            |        | nominal  |
| 3    | Age: **64**<br>Valid   |            |        | max - 1  |
| 3    | Age: **65**<br>Valid   |            |        | max      |
| 3    | Age: **66**<br>Invalid |            |        | max + 1  |

**Example #3 (range for 2 variables):** Research suggests that most people feel comfortable indoors when the humidity level is between 40 and 60 and temperature is between 65 and 75. Any point that falls within the light blue rectangle in the graph below represents a comfortable indoor condition. We'll use BVA techniques to reduce the number of points used for testing.

![comfortable indoor conditions](images/comfyindoors.png)

BVA for the range [40, 60] determines 7 **humidity** input values:

| Uncomfortable<br>min-1 | Comfortable Humidity<br>min,min+1,nominal,max-1,max | Uncomfortable<br>max+1 |
| ---------------------- | --------------------------------------------------- | ---------------------- |
| 39                     | 40, 41, 50, 59, 60                                  | 61                     |

BVA for the range [65, 75] determines 7 **temperature** input values:

| Uncomfortable<br>min-1 | Comfortable Temperature<br>min,min+1,nominal,max-1,max | Uncomfortable<br>max+1 |
| ---------------------- | ------------------------------------------------------ | ---------------------- |
| 64                     | 65, 66, 70, 74, 75                                     | 76                     |

Is it necessary to test every combination of the 7 humidity and 7 temperature values?
Thankfully, the answer is no if we make a **single fault assumption**, which states that
failures are only rarely the result of the simultaneous occurrence of two (or more) faults.
This means we can create test cases that combine each of the 7 humidity levels with the
nominal temperature, and each of the 7 temperatures with the nominal humidity.
Two test cases represent the same input (nominal humidity, nominal temperature), thus we need only 13 test cases.

- 9 test cases for points inside the rectangle (black, blue, yellow dots)
- 4 test cases for points outside the rectangle (red dots).

```java
import java.util.Scanner;

public class IndoorTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Humidity and Temperature: ");
        int humidity = input.nextInt();
        int temperature = input.nextInt();

        boolean comfyHumidity = humidity >= 40 || humidity <= 60; // ERROR
        boolean comfyTemp = temperature >= 65 && temperature <= 75;

        if (comfyTemp && comfyHumidity) {
            System.out.println("Comfy");
        } else {
            System.out.println("Uncomfy");
        }
    }
}
```

We'll test `IndoorTemp`, which has an error when checking the humidity condition.

| Test | Expected I/O                                   | Actual I/O                                     | Status | (humidity, temperature)    |
| ---- | ---------------------------------------------- | ---------------------------------------------- | ------ | -------------------------- |
| 1    | Humidity and Temperature: **50 70**<br>Comfy   | Humidity and Temperature: **50 70**<br>Comfy   | Pass   | (nom, nom) <br>black dot   |
| 2    | Humidity and Temperature: **40 70**<br>Comfy   | Humidity and Temperature: **40 70**<br>Comfy   | Pass   | (min, nom) <br>blue dot    |
| 3    | Humidity and Temperature: **41 70**<br>Comfy   | Humidity and Temperature: **41 70**<br>Comfy   | Pass   | (min+1, nom)<br> blue dot  |
| 4    | Humidity and Temperature: **59 70**<br>Comfy   | Humidity and Temperature: **59 70**<br>Comfy   | Pass   | (max-1, nom)<br>blue dot   |
| 5    | Humidity and Temperature: **60 70**<br>Comfy   | Humidity and Temperature: **60 70**<br>Comfy   | Pass   | (max, nom)<br>blue dot     |
| 6    | Humidity and Temperature: **50 65**<br>Comfy   | Humidity and Temperature: **50 65**<br>Comfy   | Pass   | (nom, min)<br>yellow dot   |
| 7    | Humidity and Temperature: **50 66**<br>Comfy   | Humidity and Temperature: **50 66**<br>Comfy   | Pass   | (nom, min+1)<br>yellow dot |
| 8    | Humidity and Temperature: **50 74**<br>Comfy   | Humidity and Temperature: **50 74**<br>Comfy   | Pass   | (nom, max-1)<br>yellow dot |
| 9    | Humidity and Temperature: **50 75**<br>Comfy   | Humidity and Temperature: **50 75**<br>Comfy   | Pass   | (nom, max)<br>yellow dot   |
| 10   | Humidity and Temperature: **39 70**<br>Uncomfy | Humidity and Temperature: **39 70**<br>Comfy   | Fail   | (min-1, nom)<br>red dot    |
| 11   | Humidity and Temperature: **61 70**<br>Uncomfy | Humidity and Temperature: **61 70**<br>Comfy   | Fail   | (max+1, nom)<br>red dot    |
| 12   | Humidity and Temperature: **50 64**<br>Uncomfy | Humidity and Temperature: **50 64**<br>Uncomfy | Pass   | (nom, min-1)<br>red dot    |
| 13   | Humidity and Temperature: **50 76**<br>Uncomfy | Humidity and Temperature: **50 76**<br>Uncomfy | Pass   | (nom, max+1)<br>red dot    |

Test cases 10 and 11 check the humidity values below the minimum and above the maximum.
The two tests fail due the logical operator error, which should be `&&` (and) rather than `||` (or).

```java
    boolean comfyHumidity = humidity >= 40 && humidity <= 60;
    boolean comfyTemp = temperature >= 65 && temperature <= 75;
```

## Decision Table

**Decision Table Testing** is a technique to evaluate program behavior based on various combinations of inputs and their corresponding actions.
It is particularly useful for testing scenarios where multiple conditions affect the outcome.
A **decision table**, also called a cause-effect table, specifies the actions to perform for a given set of input conditions.

Decision Table Structure:

- Conditions: The different inputs that influence the outcome. A condition can have two or more values (true/false, yes/no/maybe, etc.).
- Actions: The outputs that the system should produce based on the combination of condition values.
- Rules: A unique combination of condition values and the corresponding action.

**Example #1:** The monthly cost for a subscription service is based on two binary conditions:

- basic (B) or premium (P) plan
- annual (A) or monthly (M) commitment

The decision table below contains one rule per unique combination of subscription plan and commitment.
Each rule defines the monthly cost for that particular combination of input values.

<table>
<tr>
<th></th>
<th>Rule 1</th>
<th>Rule 2</th>
<th>Rule 3</th>
<th>Rule 4</th>
</tr>
<tr>
<td>CONDITIONS</td>
<td colspan="4"></td>
</tr>
<tr>
<td>Basic (B) or Premium (P) Plan</td>
<td>B</td>
<td>B</td>
<td>P</td>
<td>P</td>
</tr>
<tr>
<td>Annual (A) or Monthly (M) Commitment</td>
<td>A</td>
<td>M</td>
<td>A</td>
<td>M</td>
</tr>
<tr>
<td>ACTIONS</td>
<td colspan="4"></td>
</tr>
<tr>
<td>Monthly Cost</td>
<td>10</td>
<td>15</td>
<td>30</td>
<td>35</td>
</tr>
</table>

A test case is typically created for each rule.

**Example #2:** The subscription service adds another condition, a $5 loyalty discount for monthly plans based on length of service.

The monthly cost now depends on three binary conditions, doubling the number of rules in the decision table.

- basic (B) or premium (P) plan
- annual (A) or monthly (M) commitment
- loyalty discount (L) or no discount (N)

<table>
<tr>
<th></th>
<th>Rule 1</th>
<th>Rule 2</th>
<th>Rule 3</th>
<th>Rule 4</th>
<th>Rule 5</th>
<th>Rule 6</th>
<th>Rule 7</th>
<th>Rule 8</th>
</tr>
<tr>
<td>CONDITIONS</td>
<td colspan="8"></td>
</tr>
<tr>
<td>Basic (B) or Premium (P) Plan</td>
<td>B</td>
<td>B</td>
<td>B</td>
<td>B</td>
<td>P</td>
<td>P</td>
<td>P</td>
<td>P</td>
</tr>
<tr>
<td>Annual (A) or Monthly (M) Commitment</td>
<td>A</td>
<td>A</td>
<td>M</td>
<td>M</td>
<td>A</td>
<td>A</td>
<td>M</td>
<td>M</td>
</tr>
<tr>
<td>Loyalty Discount (L) or No Discount (N)</td>
<td>L</td>
<td>N</td>
<td>L</td>
<td>N</td>
<td>L</td>
<td>N</td>
<td>L</td>
<td>N</td>
</tr>
<tr>
<td>ACTIONS</td>
<td colspan="8"></td>
</tr>
<tr>
<td>Monthly Cost</td>
<td>10</td>
<td>10</td>
<td>10</td>
<td>15</td>
<td>30</td>
<td>30</td>
<td>30</td>
<td>35</td>
</tr>
</table>

However, notice that the loyalty discount does not affect the cost for annual subscriptions, just monthly subscriptions.
Thus, we can merge rules 1&2 and rules 5&6 and use a dash `-` to denote "don't care" for the loyalty value for those rules.
The resulting table has 6 rules:

<table>
<tr>
<th></th>
<th>Rule 1</th>
<th>Rule 2</th>
<th>Rule 3</th>
<th>Rule 4</th>
<th>Rule 5</th>
<th>Rule 6</th>
</tr>
<tr>
<td>CONDITIONS</td>
<td colspan="6"></td>
</tr>
<tr>
<td>Basic (B) or Premium (P) Plan</td>
<td>B</td>
<td>B</td>
<td>B</td>
<td>P</td>
<td>P</td>
<td>P</td>
</tr>
<tr>
<td>Annual (A) or Monthly (M) Commitment</td>
<td>A</td>
<td>M</td>
<td>M</td>
<td>A</td>
<td>M</td>
<td>M</td>
</tr>
<tr>
<td>Loyalty Discount (L) or No Discount (N)</td>
<td>-</td>
<td>L</td>
<td>N</td>
<td>-</td>
<td>L</td>
<td>N</td>
</tr>
<tr>
<td>ACTIONS</td>
<td colspan="6"></td>
</tr>
<tr>
<td>Monthly Cost</td>
<td>10</td>
<td>10</td>
<td>15</td>
<td>30</td>
<td>30</td>
<td>35</td>
</tr>
</table>

**Example #3:** The base cost of a pizza is determined by the size (small=8.99, medium=12.99, large=16.99).
A large pizza is discounted by $1.50 for customers having at least 100 reward points.

There are two input conditions that determine the price:

- size {small, medium, large}
- points >= 100 { true, false}

There are six possible combinations for the two conditions, but we can reduce the number of rules to just four since the rewards discount only applies to large pizzas.

<table>
<tr>
<th></th>
<th>Rule 1</th>
<th>Rule 2</th>
<th>Rule 3</th>
<th>Rule 4</th>
</tr>
<tr>
<td>CONDITIONS</td>
<td colspan="4"></td>
</tr>
<tr>
<td>size</thd>
<td>small</td>
<td>medium</td>
<td>large</td>
<td>large</td>
</tr>
<tr>
<td>points &gt;= 100</td>
<td>-</td>
<td>-</td>
<td>true</td>
<td>false</td>
</tr>
<tr>
<td>ACTIONS</td>
<td colspan="4"></td>
</tr>
<tr>
<td>price</td>
<td>8.99</td>
<td>12.99</td>
<td>15.49</td>
<td>16.99</td>
</tr>
</table>

To summarize, the decision table rules can be reduced by merging columns:

- Combine columns where certain conditions do not affect the outcome.
- Use “-” to denote that a condition’s value does not affect the outcome.

## Conclusion

Equivalence Partitioning, Boundary Value Analysis, and Decision Tables are common specification-based testing techniques for reducing the number of test cases.

Decision Table Testing is used to describe rules involving multiple input conditions.

| Equivalence Partitioning                                                                 | Boundary Value Analysis                                                                                       | Decision Table Testing                                                         |
| ---------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| Representative values from valid and invalid equivalence classes are used for test cases | The following are used for test cases:<br>min-1<br>min<br>min+1<br>nominal(optional)<br>max-1<br>max<br>max+1 | Test Cases cover input condition permutations that result in different actions |
| Identifies bugs within equivalence classes                                               | Identifies bugs at the boundaries of equivalence classes                                                      | Identifies bugs for combinations of inputs                                     |

Note the three techniques are not exclusive and may be used in combination.

## Resources

Java files for this lesson are available at [https://github.com/linda-seiter/cmsc115_2252](https://github.com/linda-seiter/cmsc115_2252)

<!--
<style>
th,td { border: 1px solid black; padding: 5px; }
table {border-collapse: collapse }
</style>
>

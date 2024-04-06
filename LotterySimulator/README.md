# Personal Note on **`genRandomUnique()`** Method

Since I found the Lottery Simulator program that I submitted for my assignment to be not organized and not-so-elegant, I've decided to optimize it and there has been a significant change to my **`genRandomUnique()`** method. 

## Previous Version:
```java
    public int[] genRandomUnique(int size) {
        int pushed = 0;
        int[] randNumList = new int[size];
        int randNum;

        while (pushed < size) {
            boolean found = false;
            randNum = rand.nextInt(20) + 1;

            for (int i = 0; i < pushed; i++) {
                if (randNum == randNumList[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                randNumList[pushed] = randNum;
                pushed++;
            }
        }
        return randNumList;
    }
```

## Optimized Version

### Method Overview
The **`genRandomUnique()`** method is designed to generate an array of unique random numbers within a specified range. It utilizes several key concepts from Java, including **Set**, **HashSet**, and **Java Streams**. Here's a detailed breakdown:

```java
public int[] genRandomUnique(int size) {
    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < size) {
        int randomNumber = rand.nextInt(20) + 1;
        numbers.add(randomNumber);
    }
    return numbers.stream().mapToInt(Integer::intValue).toArray();
}
```

#### Purpose
Generates an array of unique random integers, each between 1 and 20 (inclusive), with the array's length specified by the size parameter.

#### Key Components
1. **`Set<Integer> numbers = new HashSet<>();`**
- A `HashSet` is used to store unique integers (`Integer`). As a Set, it ensures all stored numbers are unique automatically.
- `Integer` is used instead of int because collections in Java, like Set, **can only store objects, not primitives**.

2. **`while (numbers.size() < size)`**
- This loop continues until the Set (numbers) contains the desired number of unique elements (size).

3. **`int randomNumber = rand.nextInt(20) + 1;`**
- Generates a random integer between 1 and 20. rand.nextInt(20) generates values from 0 to 19, so + 1 adjusts the range to 1 to 20.

4. **`numbers.add(randomNumber);`**
- Attempts to add the generated random number to the Set. 
- If the number is already present (duplicate), Set's property ensures it isn't added again, maintaining uniqueness.

5. **`return numbers.stream().mapToInt(Integer::intValue).toArray();`**
- Converts the `Set<Integer>` to an `int[]` using Java Streams, showcasing several concepts:
    - **Stream Conversion:** `numbers.stream()` converts the Set into a Stream, allowing for functional-style operations on the set of numbers.
    - **Mapping:** `.mapToInt(Integer::intValue)` maps each Integer object in the stream to its primitive int value. This is necessary because we want to return an array of primitives.
    - **Array Conversion:** `.toArray()` collects the elements of the stream into an array. Since we're using mapToInt, it returns an `int[]`.

#### Why Use These Concepts?
1. **Uniqueness:** Set ensures all elements are unique, which is ideal for generating a set of unique numbers without manual checks for duplicates.
2. **Simplicity and Efficiency:** Using a HashSet simplifies the code and is efficient for checking and ensuring uniqueness.
3. **Functional Style:** Streams provide a modern, functional-style approach to convert the Set to an array, making the code concise and readable.

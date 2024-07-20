# Big-O Notation

## Time Complexity

### Real Life Analogies

1. **Consider sending a file to a friend who lives across the country:**
   - **O(S)**: Complexity to send the file over email. As size increases, time increases.
   - **O(1)**: Complexity to send the file by taking a plane or driving. As size increases, no impact on the time. It will remain the same.
   
   For a very large file of 1TB, it could take more than 1 day to send it over mail and could be faster to send it physically.

2. **Consider painting a fence that is:**
   - `w` metres long and `h` metres high: **O(w*h)**
   - `w` metres long, `h` metres high and needs `p` layers of paint: **O(w*h*p)**
   
   The larger the parameters, the more time is required.

### Algorithm Runtime Descriptions

Algorithm runtime can be described in 3 different ways:
1. **Best case**
2. **Worst Case**
3. **Expected Case**

## Space Complexity

Refers to the amount of memory or space required by an algorithm.
- If we need to create an array of size `n` => requires **O(n)** space.
- If we need a 2-D array of size `n*n` => requires **O(n^2)** space.
- Stack space in recursive calls counts too. Consider the following:

```java
int sum(int n){
    if(n <= 0) return 0;
    return n + sum(n-1);
}
```

When you start with `sum(5)` -> `sum(4)` -> `sum(3)` -> `sum(2)` -> `sum(1)` -> return 1 => all the method calls exist at the same time => Each call is added to the call stack and actual memory is taken => **O(N)** space is needed.

If you consider this loop, `pairSum` is called once:

```java
for(int i = 0; i < n; i++){
    sum += pairSum(i, i+1);
}

pairSum(int i, int j){
    return i + j;
}
```

There are **O(N)** calls to the `pairSum` but the calls do not exist SIMULTANEOUSLY on the call stack so you only need **O(1)** space.

Remember, it is very possible for **O(N)** to run faster than **O(1)** code depending on the inputs (e.g., small file vs large file, email vs plane). Big O just describes the rate of increase.

### While Forming the Value:

1. Drop the constants - **O(2N) == O(N)**
2. Drop the non-dominant terms - **O(N^2 + N) == O(N^2)**

### Multi-Part Algorithms:

Suppose that an algorithm has 2 steps. When do you multiply the runtimes and when do you add them?

1. **Add** - steps occur separately. We do `A` amount of work and then `B` amount of work - **O(A+B)**

   **If your algorithm is in the form "do this, then, when you're all done, do that" then you add the runtimes.**

   ```java
   for (int a : arrA) { 
       print(a); 
   } 
   for (int b : arrB) { 
       print(b); 
   } 
   ```

2. **Multiply** - steps occur together. We do `B` amount of work for each element in `A` - **O(A*B)**

   **If your algorithm is in the form "do this for each time you do that" then you multiply the runtimes.**

   ```java
   for (int a : arrA) { 
       for (int b: arrB) { 
           print(a + "," + b); 
       } 
   } 
   ```

### Types of Runtimes:

1. **Amortized Time**
2. **Log N Runtimes** - When you see a problem where the number of elements in the problem space gets halved each time, that will likely be a **O(logN)** runtime.
3. **Recursive Runtime** - Draw out the recursion tree and look at the number of calls at each level. e.g., 4 levels: 1 -> 2 -> 4 -> 8 => 2^N

## Examples & Exercises

1. **Do this, then when all done, do that:** time = **O(N)**

   ```java
   void foo(int[] array) { 
       int sum = 0; 
       int product = 1; 
       for (int i = 0; i < array.length; i++) { 
           sum += array[i]; 
       } 
       for (int i = 0; i < array.length; i++) { 
           product *= array[i]; 
       } 
       System.out.println(sum + ", " + product); 
   } 
   ```

2. **For every element `i`, execute function `j` times. Both `i` & `j` = array.length = N = O(N^2)**

   ```java
   void printPairs(int[] array) { 
       for (int i = 0; i < array.length; i++) { 
           for (int j = 0; j < array.length; j++) { 
               System.out.println(array[i] + "," + array[j]); 
           } 
       } 
   } 
   ```

3. **For every element `i`, execute function `i - 1` times - outer loop executes N times. How much work does the inner loop do? It varies across iterations but the average iteration = N/2 => O(N*N/2) = O(N^2)**

   ```java
   void printUnorderedPairs(int[] array) { 
       for (int i = 0; i < array.length; i++) { 
           for (int j = i + 1; j < array.length; j++) { 
               System.out.println(array[i] + "," + array[j]); 
           } 
       } 
   } 
   ```

4. **Since there are 2 different arrays, O(A*B) where A and B are the size of A and B arrays respectively**

   ```java
   void printUnorderedPairs(int[] arrayA, int[] arrayB) { 
       for (int i = 0; i < arrayA.length; i++) { 
           for (int j = 0; j < arrayB.length; j++) { 
               if (arrayA[i] < arrayB[j]) { 
                   System.out.println(arrayA[i] + "," + arrayB[j]); 
               } 
           } 
       } 
   } 
   ```

5. **A*B*100000 - 100,000 is a constant so it can be excluded => O(AB)**

   ```java
   void printUnorderedPairs(int[] arrayA, int[] arrayB) { 
       for (int i = 0; i < arrayA.length; i++) { 
           for (int j = 0; j < arrayB.length; j++) { 
               for (int k = 0; k < 100000; k++) { 
                   System.out.println(arrayA[i] + "," + arrayB[j]); 
               } 
           } 
       } 
   } 
   ```

6. **O(N/2) -> fact that it goes through half of the array does not impact big O -> O(N)**

   ```java
   void reverse(int[] array) { 
       for (int i = 0; i < arrayA.length/2; i++) {
            int other= array.length - i - 1; 
            int temp= array[i];
            array[i] = array[other];
            array[other] = temp;
       } 
   } 
   ```
   
7. Which of the following are equivalent to O(N)? Why?

- **O(N + P), where P < X**
- **O(2N)**
- **O(N + log N)**
- **O(N + M)**

Let's go through these:
- If `P < X`, then we know that `N` is the dominant term so we can drop the **O(P)**.
- **O(2N)** is **O(N)** since we drop constants.
- **O(N)** dominates **O(log N)**, so we can drop the **O(log N)**.
- There is no established relationship between `N` and `M`, so we have to keep both variables in there.

Therefore, all but the last one are equivalent to **O(N)**.

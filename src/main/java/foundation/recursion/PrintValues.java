package foundation.recursion;

/*
Credits: https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2
 */
public class PrintValues {

    public static void main(String[] args) {
        System.out.println("print name n times without using a for loop");
        printNameNTimes(1,3);
        System.out.println("print numbers from 1 to n e.g. 1,2,3,4");
        printLinearNum(1,3);
        System.out.println("print numbers from n to 1 e.g. 4,3,2,1");
        printReverseNum(3,3);
        System.out.println("print numbers from 1 to n without using i+1");
        printLinearWithBacktracking(4);
        System.out.println("print numbers from n to 1 without using i-1");
        printReverseWithBacktracking(1,4);
    }

    // f(1,3) -> f(2,3) -> f(3,3) -> f(4,3) = hit base condition & return
    // time complexity = O(N) - because function is called N times
    // space complexity = O(N) - all the calls were waiting in the stack until the final call
    static void printNameNTimes(int i, int n) {
        if (i > n) return;
        System.out.println("roro2");
        printNameNTimes(i + 1, n);
    }

    // Print linear from 1 to n - e.g. 1,2,3,4
    // (1,3) -> (2,3) -> (3,3) -> (4,3) return;
    // print value 1 and then call
    static void printLinearNum(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        printLinearNum(i + 1, n);
    }

    // print in reverse order e.g. 4,3,2,1
    // (3,3) -> (2,3) -> (1,3) -> (0,3) return
    static void printReverseNum(int i, int n) {
        if (i < 1) return;
        System.out.println(i);
        printReverseNum(i - 1, n);
    }

    // print linear num (1,2,3,4) but without using i+1
    // we can use i - 1
    // print statement is after the recursion call -> backtracking
    // f(4) -> f(3) -> f(2) -> f(1) -> f(0) return -> f(1) will continue to sysout line -> f(2) ...
    // the last method is executed FIRST
    static void printLinearWithBacktracking(int n) {
        if (n < 1) return;
        printLinearWithBacktracking(n - 1);
        System.out.println(n);
    }

    // 4,3,2,1
    // (1,4) -> (2,4) -> (3,4) -> (4,4) -> (5,4) return -> (4,4) print 4 -> (3,4) print 3 -> (2,4) print 2 -> (1,4) print 1
    // refer to printReverseWithBacktracking for explanation
    static void printReverseWithBacktracking(int i, int n) {
        if (i > n) return;
        printReverseWithBacktracking(i+1,n);
        System.out.println(i);
    }
}

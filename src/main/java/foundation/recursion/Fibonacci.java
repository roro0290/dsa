package foundation.recursion;

import java.util.HashMap;
import java.util.Map;

/*
509. Fibonacci Number
https://leetcode.com/problems/fibonacci-number/description/
 */
public class Fibonacci {
    Map<Integer,Integer> map;
    public int fib(int n) {
        map = new HashMap<>();
        return helper(n);
    }

    int helper(int n){
        if(map.containsKey(n)) return map.get(n);
        if(n<2) return n;
        int i = helper(n-1) + helper(n-2);
        map.put(n,i);
        return i;
    }
}

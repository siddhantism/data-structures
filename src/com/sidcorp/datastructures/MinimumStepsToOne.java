package com.sidcorp.datastructures;

/**
 * 
 * @author Siddhant Verma
 *
 */

/*
 * Minimun Steps to one.
 * On a positive integer, following 3 steps can be performed:
 * 1. n = n-1
 * 2. if n is divisible by 2 then n = n/2
 * 3. if n is divisible by 3 then n = n/3
 * Given a positive integer n, find the minimum number of steps that takes n to 1
 * 
 * n = 10
 * Greedy Approach - Make n as low as possible and continue the same till it reaches 1
 * 10/2 = 5
 * 5 - 1 = 4
 * 4/2 = 2
 * 2/2 = 1
 * Total - 4 steps. This is not optimal
 * 
 * Correct answer - 10 - 1 = 9
 *                  9/3 = 3
 *                  3/3 = 1
 *                  Total - 3 steps
 *  
 *  Case of overlapping sub problem
 */
public class MinimumStepsToOne {
	public static void main(String[] args) {
		int n = 10;
		int [] dp = new int[n+1];
		dp[1] = 0;
		for (int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + 1;
			if (i%2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if (i%3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[n]);
		
	}

}

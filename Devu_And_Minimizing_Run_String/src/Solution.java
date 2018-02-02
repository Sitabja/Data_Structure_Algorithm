import java.util.Scanner;

/*
 * Devu likes to play with strings a lot. One day he found a string s with characters 'R' and 'B' in a box of marbles.

He defined runs of a string as the size of string after merging all the consecutive equal characters of the string into a single character. E.g. 'RRBB' has 2 runs, whereas 'RR' and 'RBBRRR' have 1 and 3 runs respectively.

In a single operation, Devu can remove a single character from some position in the string and insert it back at any other position. He is allowed to do at most one such operation. He wants to minimize the number of runs in the string s.

Please help Devu in finding minimum number of runs of the string s.

Input Format

The first line of the input contains a single integer, T, denoting the number of test cases.
For each test case, there is a single line containing string s.
Output Format

For each test case, print in a new line containing a single integer denoting the answer to the problem.

Constraints

1≤ size of string s≤10^5
Sum of sizes of string s over all the test cases will be less than 2∗10^6
Sample Input

3
RB
RBRR
RRR
Sample Output

2
2
1
Explanation

Example 1 
Number of runs in the the string with or without the above explained operation is 2.

Example 2 
In a single operation, Devu can change the string 'RBRR' into 'BRRR' which has 2 runs.

Example 3 
There is only a single run in the string.
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++)
		{	int count = 1 ;
			String s = sc.next();
			boolean flag = false;
			
			for( int j = 1 ; j < s.length() - 1; j++)
			{
				char a = s.charAt(j);
				if(s.charAt(j - 1) != a && s.charAt(j + 1) != a && !flag)
					{  
					    flag = true;
						continue;
					}
				if(s.charAt(j+1) != a)
					count++;
				
				
				
			}
			
			if(!flag)
			{
				if(s.charAt(0) == s.charAt(s.length()-1))
				{
					count++;
				}
			}
			
			System.out.println(count);
		}
		
		
		
	}

}

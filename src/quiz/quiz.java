package quiz;

import java.util.Scanner;
import java.util.Arrays;

public class quiz {
	public static int fib(int n) 
	{  // assumes n >= 0
	  

	   //System.out.print(1);

	   if (n <= 1)
	   {
	      return n;
	   }
	   else
	   {
		  System.out.print(1);
	      return (fib(n - 1) + fib(n - 2));
	   }
	}
	
	public static void main(String[]args) {
		int[] arr = {23, 25, 29, 34, 42};
		int newVal = 15;
		int pos = Arrays.binarySearch(arr, newVal);
		
        String i = "111111111111111111111";
        
        System.out.print(i.length());
        System.out.println(pos);
        System.out.println(fib(7));
//	String[] data = { "abc", "def", "ghi", "jkl" };
//	String[] data2 = Arrays.copyOf(data, data.length - 1);
//	
//	System.out.println(data2[data2.length-1]);
//	    }
	
	}
	
//	public static void main(String[]args) {
//		Scanner in = new Scanner(System.in);
//		int x = 0;
//		int sum = 0;
//		int previous;
//		do {
//			previous = x;
//			System.out.print("Enter an integer:");
//			x = in.nextInt();
//			sum += x;
//		}
//		while (x != 0 && previous != x);
//		System.out.print("Sum is:" +sum);
//		in.close();
//	}
//	public static int forloopSum(int n) {
//		int sum = 0;
//		for (int i=0; i<=n; i++ ) {
//			sum += i;
//		}
//		return sum;
	}
//	public static void main(String[] args) {
//		for (int i = 10; i<= 20; i+=2) {
//			System.out.println(i);
//		}
//	}
//	public static void main(String[] args) {
//		String s1, s2;
//		s1 = s2 = " ";
//		 System.out.println(s1.compareTo(s2));
//		if (s1 == s2)
//		{ 
//		   System.out.println("Yes!"); 
//		}
		
//		for (int i = 1; i < 13; i++) {
//		     for (int j = 1; j < 13; j++) {
//		          System.out.print(i*j);
//		     }
//		     System.out.println();
//		}
		
	
	


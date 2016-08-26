import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Prob03 {
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int v[] = new int[n];
    	for (int i=0; i<n; i++)
		    v[i] = in.nextInt();
	
    	Arrays.sort(v);
	
    	
    	for (int j=0;j<n-1;j++){
			System.out.print(v[j] + " ");
			if (j==v.length-2)
				System.out.print(v[j+1]);
		}
    }

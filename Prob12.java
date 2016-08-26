import java.io.*;
import java.util.*;


class Prob12{
	static long n_ways(long [][] pyramid, int n){
		for(int i = n-2; i>=0; i--){
			for(int j = 0; j<=i; j++){
				if(pyramid[i][j]!=0)
					pyramid[i][j] = pyramid[i+1][j] + pyramid[i+1][j+1];
			}
		}
		return pyramid[0][0];
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int c,p;
		int n = in.nextInt();
		int d = in.nextInt();
		
		long [][] pyramid = new long[n][n];
		
		//Put the matrix all at 1's
		
		for(int i = n-1; i>=0; i--){
			for(int j = 0; j<=i; j++){
				pyramid[i][j]=1;
			}
		}
		
		
		//reads the rotten rock 
		for(int i = 0; i < d; i++){
			c = in.nextInt();
			p = in.nextInt();
			pyramid[n-c][p-1] = 0;
		}
		
		System.out.println(n_ways(pyramid, n));
	}
}
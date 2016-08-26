import java.io.*;
import java.util.*;

public class Prob13_v1{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt(); // tamanho do maior salto
		int n = in.nextInt(); // no. de pedras a considerar
		
		int [] stones = new int[n+1];  // vetor de pedras
		int [] right = new int[n+1];
		int [] left= new int[n+1];
		for(int i = 0; i < n; i++){
			stones[i] = in.nextInt();
		}
		if(n==1){
			System.out.println(stones[0]);
			return;
		}
		right[n-1] = stones[n-1];
		left[n-1] = -stones[n-1]; 
		for(int i = n-2; i >= 0; i--){
			int max_left = left[i+1];
			int max_right = right[i+1];
			for(int j = i+2; j < i+2+k-1; j++){
				if(j <= n){
					if(max_left < left[j])
						max_left = left[j];
					if(max_right < right[j])
						max_right = right[j];
				}
			}
			right[i] = stones[i] + max_left;
			left[i] = -stones[i] + max_right;
		}
		
		int maximum = right[0];
		int i = 0;
		
		while(i < k && i < n){
			if(maximum < right[i])
				maximum = right[i];
			if(maximum < left[i])
				maximum = left[i];
			i++;
		}
		System.out.println(maximum);
	}
}
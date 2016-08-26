import java.io.*;
import java.util.*;

public class Prob14_v1{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int s = in.nextInt(); //no. de sacos de correio
		int c = in.nextInt(); // capacidade da carga maxima da carrinha
		
		int [] weight = new int[s]; // vetor com os varios pesos
		boolean [] sum = new boolean[c+1]; 
		weight[0] = in.nextInt();
		
		sum[weight[0]] = true;
		
		for(int i = 1; i < s; i++){
			weight[i] = in.nextInt();
			for(int j = c; j >= 0; j--){
				if(j-weight[i] >= 0 && sum[j-weight[i]] == true)
					sum[j] = true;
			}
			sum[weight[i]] = true;
		}
		for(int i = c; i >= 0; i--){
			if(sum[i]==true){
				System.out.println(i);
				return; // retorna a maior soma dos precos
			}
		}
		
		
	}
}
import java.io.*;
import java.util.*;

//Tive ajuda de um colega neste exercicio

class Prob08_v1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		long p[] = new long[n];
		long low = 0;
		long high = 0;
		int j = 0;
		for(int i=0; i<n; i++){
			 p[i] = in.nextInt();
			 low = Math.max(low, p[i]);
			 high += p[i];
		}
		
		//pesquisa binaria
		while(low<high){
			long middle = (low+high)/2;
			int c = 1;
			long sum = 0;
			for(int i=0; i<n; i++){
				if(sum+p[i]>middle){
					++c;
					sum = 0;
				}
				sum += p[i];
				}
			if(c>k)
				low = middle +1;
			else 
				high = middle;
		}
		//fim da pesquisa binaria
		
		long sum = 0;
		boolean insere[] = new boolean[n];
		//Decisao se se insere o | ou nao
		for(int i = n-1; i>=0; i--){
			if(sum+p[i] > low){
				if(i>0){
					++j;
					insere[i] = true;
				}
				sum = 0;
			}
			sum += p[i];
		}
		for(int i=0; i<n && j<k-1; i++){
			if (!insere[i]){
				insere[i] = true;
				j++;
			}
		}
		// mete a separacao
		for (int i=0; i<n; i++){
			if (i > 0) 
				System.out.print(" ");
			System.out.print(p[i]);
			if (insere[i]) 
				System.out.print(" |");
		}
		System.out.println();
		
	}
}
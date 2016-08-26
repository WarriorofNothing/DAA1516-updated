import java.io.*;
import java.util.*;

class Prob02{
	public static int kadane(int a[],int n){
		int somamax = 0;
		int soma = 0;
		if(n == 1)
			return a[0];
		else{
			for (int i = 0; i < n; i++){
				if((soma + a[i]) < 0){
					soma = 0;
				}
				else
					soma += a[i];
			
				if(soma > somamax){
					somamax = soma;
				
				}
				
			}
		}
		return somamax;
		
	}
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();          
		int b[] = new int[a];
		for(int i = 0; i<a; i++){
			b[i] = in.nextInt();
			
		}
		if(a == 1) System.out.println(b[0]);
		else{
		int somamax = kadane(b,a);
		System.out.println(somamax);
		}
	}
}
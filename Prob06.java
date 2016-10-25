import java.io.*;
import java.util.*;


class Prob06{
	/**
	* Pesquisa binária interativa
	*/
	static int binarysearch(int [] sum, int low, int high, int key){
		int middle = 0;
		while(low < high){
			middle = low + (high - low)/2;
			if(key == sum[middle])
				return middle;
			else if(key < sum[middle])
				high = middle;
			else low = middle + 1;
		}
		
		middle = low;
		if(middle > 0){
			if(key - sum[middle-1] < sum[middle] - key)
				return middle-1;
			if(key - sum[middle-1] == sum[middle] - key){
				System.out.print(sum[middle-1] + " " );
				return middle;
			}
			if(sum[middle]-key < key - sum[middle-1])
				return middle;
		}
		return middle;
		
	}
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); //o tamanho do conjunto de números
		int [] seq = new int[n];
		int fact =  0;
		
		
		//leitura do conjuntos
		for(int i = 0; i < n; i++){
			seq[i] = in.nextInt();
			fact+=i;
		}
		
		// faz as sucessivas somas
		int [] sum2 = new int[fact];
		int x = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < i ; j++){
				sum2[x] = seq[i]+seq[j]; 
				x++;
			}
		}
		
		Arrays.sort(sum2);
		int p = in.nextInt(); // no. de perguntas
		int k;
		
		// pesquisa a soma mais proxima.
		for(int i = 0; i < p; i++){
			x = in.nextInt(); //leitura das perguntas
			k = binarysearch(sum2, 0, fact-1, x); //pesquisa propriamente dita.
			if(k!= -1)
				System.out.println(sum2[k]);
			else 
				System.out.println(k);
		}
		}
	}
	

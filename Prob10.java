import java.io.*;
import java.util.*;

class Prob10{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double [] ratio = new double[n];
		
		for(int i = 0; i < n; i++){
			int dim = in.nextInt(); //dimensao
			int busted = in.nextInt(); //multa
			ratio[i] = dim/(busted+0.0);
		}
		
		for(int i = 0; i < n; i++){
			double minim = 99999; //minimo
			int index = 0; //indice
			for(int j = 0; j<n; j++)
				if(minim > ratio[j] && ratio[j] > 0.0){
					minim = ratio[j];
					index = j;
				}
			if(i == n-1)
				System.out.print(index + 1);
			else
				System.out.print(index + 1 + " ");
			ratio[index] = 0.0;
		}
		System.out.println();
		
		
	}
}
import java.io.*;
import java.util.*;
 
public class Prob23_v1{
	static int [][] dist; //matrizes das distancias
	static int inf = 999999;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nocidades = in.nextInt(); 
		char [] cities = new char[nocidades];
		cities[0]= 'A';
		boolean [][] adj = new boolean[nocidades][nocidades];
		
		for(int i = 1; i < nocidades; i++)
			cities[i] = (char)(cities[i-1] + 1);
		
		for(int i = 0; i < nocidades; i++){
			in.next(); // salta o char
			int nedges = in.nextInt(); // no de arestas
			for(int j = 0; j < nedges; j++){
				char destination = in.next().toCharArray()[0]; // le o char e mete na posicao 0 do array
				adj[i][destination-'A'] = true;
			}
		}
		
		dist = new int[nocidades][nocidades];
		for(int i = 0; i < nocidades; i++)
			Arrays.fill(dist[i], inf); //preenche todos os valores a dist[i] a infinito
		
		
		// Algoritmo de Floyd-Warshall
		
		for(int i = 0; i < nocidades; i++)
			dist[i][i] = 0;
		for(int i = 0; i < nocidades; i++){
			for(int j = 0; j < nocidades; j++){
				if(adj[i][j])
					dist[i][j] = 1;
			}
		}
		
		for(int k = 0; k < nocidades; k++){
			for(int i = 0; i < nocidades; i++){
				for(int j = 0; j < nocidades; j++){
					if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		//fim do algoritmo de floyd-warshall
		
	//tratamento do output
	System.out.print("  ");
	for(int i = 0; i < nocidades; i++){
		System.out.print((char) ('A' + i));
		if(i+1 != nocidades)
			System.out.print(" ");
	}
	System.out.println();
	for(int i = 0; i < nocidades; i++){
		System.out.print((char) ('A'+i));
		System.out.print(" ");
		for(int j = 0; j < nocidades; j++){
			if(dist[i][j] != inf)
				System.out.print(1);
			else 
				System.out.print(0);
			if(j+1 != nocidades)
				System.out.print(" ");
		}
		System.out.println();
	}
	}
	
}
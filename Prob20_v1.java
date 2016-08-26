import java.io.*;
import java.util.*;


//classe do no
class Node{
	public boolean visited; // valor booleano que indica se foi visitado numa pesquisa
	public int dist; // distancia do no origem da pesquisa

	Node(){
		visited = false;
		dist = -1;
	}
}

public class Prob20_v1{
	static int c; //colunas
	static int l; //linhas
	static String line;
	static char matrix[][]; //mapa
	static Node nodes[][];
	static int distMaxim = -1; 
	static int distMinim;
	
	//pesquisa em largura
	static void BFS() {
		LinkedList<Integer> x = new LinkedList<Integer>();
		LinkedList<Integer> y = new LinkedList<Integer>();

		for(int i = 0; i < l; i++)
			for(int j = 0; j < c; j++)
				if (matrix[i][j] == '#') {
					x.add(i);
					y.add(j);
					nodes[i][j].visited = true;
					nodes[i][j].dist = 0;
				}

		while(x.size() > 0) { 
			int u = x.removeFirst();
			int v = y.removeFirst();
			if(v < c-1)
				if(!nodes[u][v+1].visited) {
					x.add(u);
					y.add(v+1);
					nodes[u][v+1].visited = true;
					nodes[u][v+1].dist = nodes[u][v].dist + 1;
				}
			if(v > 0)
				if(!nodes[u][v-1].visited) {
					x.add(u);
					y.add(v-1);
					nodes[u][v-1].visited = true;
					nodes[u][v-1].dist = nodes[u][v].dist + 1;
				}
			if(u < l-1)
				if(!nodes[u+1][v].visited) {
					x.add(u+1);
					y.add(v);
					nodes[u+1][v].visited = true;
					nodes[u+1][v].dist = nodes[u][v].dist + 1;
				}
			if (u > 0)
				if (!nodes[u-1][v].visited) {
					x.add(u-1);
					y.add(v);
					nodes[u-1][v].visited = true;
					nodes[u-1][v].dist = nodes[u][v].dist + 1;
				}
		}
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		l = stdin.nextInt();
		c = stdin.nextInt();
		line = stdin.nextLine();
		matrix = new char[l][c];
		nodes = new Node[l + 1][c + 1];
		distMinim = l*c;
		for(int i = 0; i < l; i++) {   //leitura da matriz
			line = stdin.nextLine();
			for (int j = 0; j < c; j++) {
				matrix[i][j] = line.charAt(j);
			}
		}

		for(int i = 0; i < l; i++)
			for(int j = 0; j < c; j++)
				nodes[i][j] = new Node();

		BFS(); // faz a pesquisa em largura
		for(int i = 0; i < l; i++)
			for(int j = 0; j < c; j++)
				if(matrix[i][j] == 'A') {
					if(nodes[i][j].dist > distMaxim)
						distMaxim = nodes[i][j].dist;
					if(nodes[i][j].dist < distMinim) {
						distMinim = nodes[i][j].dist;
					}
				}

		System.out.println(distMinim + " " + distMaxim); //imprime distancia minima e maxima

	}

}
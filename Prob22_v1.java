import java.util.*;
import java.io.*;

//Classe que representa um no
class Node {
 public LinkedList<Edges> adj; // Lista de adjacencias
 public boolean visited;         // Valor booleano que indica se foi visitao numa pesquisa
 public double distance;            // Distancia do no origem da pesquisa

 Node() {
	adj = new LinkedList<Edges>();
	visited = false;
	distance = -1;
 }
}
class Edges{
	public int destination; //no destino
	public double distan; // o custo associado a distancia
	
	//CONSTRUTOR
	Edges(int dest, double dist){
		destination = dest;
		distan = dist;
	}
}


//Classe que representa um grafo
class Graph {
 int n;           // Numero de nos do grafo
 Node nodes[];    // Array para conter os nos

 Graph(int n) {
	this.n = n;
	nodes  = new Node[n+1]; // +1 se os comecam em 1 ao inves de 0
	for (int i = 0; i < n; i++)
	    nodes[i] = new Node();
 }
// adiciona ao grafo com o custo
 public void addLink(int a, int b, double d) {
	nodes[a].adj.add(new Edges(b, d));
	nodes[b].adj.add(new Edges(a, d));
	
  }
 
 // DIJKSTRA
 public void dijkstra(int v){
	 for(int i = 0; i < n; i++){
		 nodes[i].distance = Double.MAX_VALUE;
		 nodes[i].visited = false;
	 }
	 
	 nodes[v].distance = 0;
	 for(int j = 0; j < n; j++){
		 double low = Double.MAX_VALUE;
		 int position = 0;
		 for(int i = 0; i < n; i++){
			 if(nodes[i].visited == false && nodes[i].distance < low){
				 low = nodes[i].distance;
				 position = i;
			 }
		 }
		 
		 nodes[position].visited = true;
		 for(Edges w : nodes[position].adj){
			 if(nodes[w.destination].visited == false && nodes[position].distance + w.distan < nodes[w.destination].distance)
				 nodes[w.destination].distance = nodes[position].distance + w.distan;
		 }
	 }
 }
}


class Prob22_v1{
	static String [] point;
	static int n, e;
	
	// Associacao da cidade a um numero do grafo
	public static int numero(String local){
		for(int i = 0; i < n; i++){
			if("".equals(point[i])){
				point[i] = local;
				return i;
			}
			if(local.equals(point[i]))
				return i;
		}
		return 0;
	}
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double d;
		
		// primeira linha do input
		n = in.nextInt();
		e = in.nextInt();
		
		point = new String[n+1];
		for(int i = 0; i < n; i++){
			point[i] = "";
		}
		point[0] = in.next();
		point[1] = in.next();
		
		//Criacao do grafo
		Graph v = new Graph(n);
		
		
		for(int i = 0; i < e; i++){
			String n = in.next(); // Origem 
			String m = in.next(); // Destino
			v.addLink(numero(n), numero(m), in.nextDouble());
		}
		v.dijkstra(0);
		System.out.printf("%.1f\n", v.nodes[1].distance);
		
	}
	
	
}

import java.util.*;
// Tive alguma ajuda neste exercicio por um colega
// Classe que representa um no
class Node {
	public LinkedList<Integer> adj; // Lista de adjacencias
	public boolean visited;         // Valor booleano que indica se foi visitao numa pesquisa
	public int distance;            // Distancia do no origem da pesquisa

	Node() {
		adj = new LinkedList<Integer>();
		visited = false;
		distance = -1;
	}
}

// Classe que representa um grafo
class Graph {
	int n;           // Numero de nos do grafo
	Node nodes[];    // Array para conter os nos
	
	
	
	//
	int eccentricity; //valor da excentricidade do no do grafo
	//
	
	
	
	
	Graph(int n) {
		this.n = n;
		nodes  = new Node[n+1]; // +1 se os comecam em 1 ao inves de 0
		for (int i=1; i<=n; i++)
			nodes[i] = new Node();
	}

	public void addLink(int a, int b) {
		nodes[a].adj.add(b);
		nodes[b].adj.add(a);
	}

	// Algoritmo de pesquisa em largura
	public void bfs(int v) {
		LinkedList<Integer> q = new LinkedList<Integer>();

		q.add(v);
		nodes[v].visited = true;
		nodes[v].distance = 0;

		while (q.size() > 0) {
			int u = q.removeFirst();
			//System.out.println(u + " [dist=" + nodes[u].distance + "]");
			for (int w : nodes[u].adj)
				if (!nodes[w].visited) {
					q.add(w);
					nodes[w].visited  = true;
					nodes[w].distance = nodes[u].distance + 1; 
				}	    
		}
		
		
		
		
		
		
		
		//calcula a distancia
		//calcular excentricidade
		eccentricity = -1; //caso nao seja a primeira vez que se corre bfs
		for(int i=1; i<=n; i++) {
			if(nodes[i].distance  > eccentricity)
				eccentricity = nodes[i].distance;
		}
		
	}
	
	//retornar excentricidade
	public int excentriCIdade() {
		return eccentricity;
	}


	//Adiciona-se os nos que nao foram visitados para correr o BFS varias vezes.
	public void unvisited() {
		for(int i = 1; i<=n; i++) {
			nodes[i].visited = false;
		}
	}
	
	
	
	
	
	


}

public class Prob19_v4 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Graph g = new Graph(in.nextInt());
		int   e = in.nextInt();
		for (int i=0; i<e; i++) 
			g.addLink(in.nextInt(), in.nextInt());

		
		
		
		
		//AGORA VEM AI GRANDE MAGIA
		//Calcular a excentricidade do no
		int[] excentricidade = new int[g.n+1];
		
		for(int i = 1; i<=g.n;i++) {
			g.bfs(i);
			excentricidade[i] = g.excentriCIdade();
			g.unvisited();
		}
		
		//CALCULAR RADIUS DIAMETER CENTER PERIFERAL
		int diametro = 0, raio = Integer.MAX_VALUE;
		

		for(int i = 1; i<=g.n;i++) {
			if (diametro < excentricidade[i]) {
				diametro = excentricidade[i];
			}
			if (raio > excentricidade[i]) {
				raio = excentricidade[i];
			}
		}
		
		//Output...
		System.out.println(diametro);
		System.out.println(raio);
		
		String centro = new String();
		for(int i = 1; i<=g.n; i++) {
			if(excentricidade[i] == raio) centro += i + " ";
		}
		if (centro.endsWith(" ")) {//se o no central do grafo acaba com um espaco retorna a substring.
			  centro = centro.substring(0, centro.length() - 1);
		}
		System.out.println(centro);
		String periferico = new String();
		// calcula os nos perifericos
		for(int i = 1; i<=g.n; i++) {
			if(excentricidade[i] == diametro) periferico += i + " ";
		}
		if (periferico.endsWith(" ")) {
			periferico = periferico.substring(0, periferico.length() - 1);
		}
		System.out.println(periferico);
		
		
	}
}
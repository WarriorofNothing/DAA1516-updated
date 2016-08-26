import java.io.*;
import java.util.*;


//Tive um bocado de ajuda de um colega em certas partes do codigo.

class Node implements Comparable<Node>{
	double w;
	int from; // no antecessor
	int to; // no sucessor

	Node(double w, int from, int to){
		this.w = w;
		this.from = from;
		this.to = to;
	}

	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Double.compare(this.w, o.w);
	}

}


public class Prob21_v4{
	static List<Node> nodelist;
	static int n;
	static int [] pset;
	static int [] rank;

	//create the set
	static void makeSet(int n1){
		pset = new int[n1];
		rank = new int[n1];
		for(int i = 0; i < n1; i++){
			pset[i] = i;
			rank[i] = 0;
		}
	}

	//search the set
	static int findSet(int i){
		if(i!=pset[i]) {
			pset[i] = findSet(pset[i]);
		}
		return pset[i];
	}

	//is it the same set?

	static boolean isSameSet(int i, int j){
		return findSet(i) == findSet(j);

	}

	//Union.

	static void Union(int i, int j){
		int xRz = findSet(i);
		int yRz = findSet(j);


		if(rank[xRz] > rank[yRz])
			pset[yRz] = xRz;
		else {
			pset[xRz] = yRz;
			if(rank[xRz] == rank[yRz])
				++rank[yRz];
		}


	}

	//algoritmo de kruskall
	static double kruskall(){

		double cost = 0;
		makeSet(n);
		Collections.sort(nodelist);
		for(int i = 0; i < nodelist.size(); ++i){
			Node node = nodelist.get(i);
			if(!isSameSet(node.from, node.to)) {
				Union(node.from, node.to);
				cost += node.w;
			}
		}
		return cost;
	}


	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		double [] xcord = new double[n]; 
		double [] ycord = new double[n]; 
		nodelist = new ArrayList<Node>();

		//splits the string and transforms into doubles
		for(int i = 0; i < n; ++i){
			xcord[i]=in.nextDouble();
			ycord[i]=in.nextDouble();
		}

		for (int i = 0; i < n-1; ++i){
			for(int j = i+1; j < n; ++j){
				double dx = xcord[i] - xcord[j];
				double dy = ycord[i] - ycord[j];
				double d = Math.sqrt(dx*dx + dy*dy);

				nodelist.add(new Node(d,i,j));
				nodelist.add(new Node(d,j,i));
			}
		}
		System.out.println(String.format("%.2f", kruskall()));
	}

	


}
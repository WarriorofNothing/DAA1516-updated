import java.util.*;
import java.io.*;

public class Prob15 {
    static int n;                 // Numero de nos do grafo
    static boolean adj[][]; // Matriz de adjacencias
    static boolean visited[];  // Que nos ja foram visitados?

    static void dfs(int v) {
    	//int count = 0;
    	visited[v] = true;
    	for (int i=1; i<=n; i++){
    		if (adj[v][i] && !visited[i]){
    		//	count++;
    			dfs(i);
    		}
    	
    	}
    	//System.out.println(count);
    }
    
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);
	
	n = stdin.nextInt();
	adj     = new boolean[n+1][n+1];
	visited = new boolean[n+1];	
	int count = 0;
	int edges = stdin.nextInt();	
	for (int i=0; i<edges; i++) {
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    adj[a][b] = adj[b][a] = true;
	}
	for(int i = 1; i<=n;i++){
		if (!visited[i]) {
			dfs(i);
			count++;
		}
		
	}
	if(edges == 0){
		count = n;
	}
	System.out.println(count);
	//System.out.println();       
    }
}
import java.io.*;
import java.util.*;

public class Prob17_v1{
	static boolean [][] adj; //matriz de adjacencias
	static boolean [] vertices;
	static boolean [] visited; 
	static String sort;
	
	//dfs.
	static void dfs(int s){
		visited[s] = true;
		//pecorre o alfabeto..
		for(int i = 0; i < 26; ++i){
			if(adj[s][i] && !visited[i])
				dfs(i);
		}
		sort = (char) (s + 'A') + sort;
	}
	
	//pesquisa e adiciona ao vetor qual foi visitado e "ordena"..
	static void topsort(){
		visited = new boolean[26];
		sort = "";
		
		for(int i = 0; i < 26; ++i){
			if(vertices[i] && !visited[i])
				dfs(i);
		}
		System.out.println(sort);
	}
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		
		List<String> dictionary = new ArrayList<String>();
		vertices = new boolean[26];
		adj = new boolean[26][26];
		int maxlength = 0;
		int n = in.nextInt();
		
		for(int i = 0; i <= n; i++){
			String line = in.nextLine();
			dictionary.add(line);
			maxlength = Math.max(maxlength, line.length());
		}
		
		for(int i = 0; i < maxlength; ++i){
			for(int j = 0; j< dictionary.size(); ++j){
				String s = dictionary.get(j);
				if(i >= s.length())
					continue;
				vertices[s.charAt(i) - 'A'] = true;
				if(j > 0){
					String prevision = dictionary.get(j-1);
					if(prevision.length() > i){
						if(i == 0 && s.charAt(i) != prevision.charAt(i))
							adj[prevision.charAt(i) - 'A'][s.charAt(i) - 'A'] = true;
						else if(s.charAt(i) != prevision.charAt(i)){
							boolean okay = true;
							for(int k = 0; k < i && okay == true; ++k){
								if(s.charAt(k) != prevision.charAt(k))
									okay = false;
							}
							if(okay == true)
								adj[prevision.charAt(i) - 'A'][s.charAt(i) - 'A'] = true;
						}
					}
				}
			}
		}
		topsort();
	}
}
import java.util.*;
import java.io.*;
//Tive ajuda duma colega em partes do codigo
public class Prob18_v1 {
	static int c; // colunas
	static int l; // linhas
	static String line[]; // vetor em q 
	static int visited[][][];
	static int count = 0;
	static int max = 0;
	static int found = 0;

	//pesquisa em profunidade para detetar os ciclos
	static void DFS(int i, int j, int ins, int a, int ptoi, int ptoj) {
		if(visited[i][j][ins] == 1) {
			if(a >= 4)
				found = 1;
			if(a > max)
				if(a >= 4)
					max = a;
			return;
		}

		visited[i][j][ins] = 1;
		if(line[i].charAt(j) == '\\') {
			if(ins == 1) {
				if(i > 0)
					if(i-1 != ptoi)
						if(j != ptoj)
							DFS(i-1,j,0,a+1,i,j);
				if(j < c-1)
					if(line[i].charAt(j+1) == '\\')
						if(i != ptoi)
							if(j+1 != ptoj)
								DFS(i,j+1,0,a+1,i,j);
				if(j<c-1)
					if(line[i].charAt(j+1) == '/')
						if(i != ptoi)
							if(j+1 != ptoj)
								DFS(i, j+1, 1, a+1, i, j);
			} else if(ins == 0) {
				if(i < l-1)
					if(i + 1 != ptoi)
						if(j != ptoj)
							DFS(i+1,j,1,a+1,i,j);
				if(j > 0)
					if(line[i].charAt(j-1) == '\\')
						if(i != ptoi)
							if(j-1 != ptoj)
								DFS(i, j-1, 1, a+1, i, j);
				if(j > 0)
					if(line[i].charAt(j-1) == '/')
						if(i != ptoi)
							if(j-1 != ptoj)
								DFS(i, j-1, 0, a+1, i, j);
			}
		} else{
			if(ins == 1) {
				if(i > 0)
					if(i - 1 != ptoi)
						if(j != ptoj)
							DFS(i-1, j, 0, a+1, i, j);
				if(j > 0)
					if(line[i].charAt(j - 1) == '\\')
						if(i != ptoi)
							if(j - 1 != ptoj)
								DFS(i, j-1, 1, a+1, i, j);
				if(j > 0)
					if(line[i].charAt(j-1) == '/')
						if(i != ptoi)
							if(j-1 != ptoj)
								DFS(i, j-1, 0, a+1, i, j);
			} else if(ins == 0) {
				if(i < l-1)
					if(i+1 != ptoi)
						if(j != ptoj)
							DFS(i+1, j, 1, a+1, i, j);
				if(j < c-1)
					if(line[i].charAt(j + 1) == '\\')
						if(i != ptoi)
							if(j+1 != ptoj)
								DFS(i, j+1, 0, a+1, i, j);
				if(j < c-1)
					if(line[i].charAt(j+1) == '/')
						if(i != ptoi)
							if(j+1 != ptoj)
								DFS(i, j+1, 1, a+1, i, j);
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		c = stdin.nextInt();
		l = stdin.nextInt();
		line = new String[l];
		visited = new int[l][c][2];

		for(int i = 0; i < l; i++) {
			line[i] = stdin.next();
		}
		// 0 -> nao foi visitado, 1 -> a visitar, 2 -> visitado
		for(int i = 0; i < l; i++)
			for (int j = 0; j < c; j++) {
				found = 0;
				if(visited[i][j][0] == 0)
					DFS(i, j, 0, 0, -1, -1);
				if(found == 1)
					count++;
				found = 0;
				if(visited[i][j][1] == 0)
					DFS(i, j, 1, 0, -1, -1);
				if(found == 1)
					count++;
			}

		if(count == 0)
			System.out.println("nao tem ciclos");
		else
			System.out.println(count + " " + max);

	}

}
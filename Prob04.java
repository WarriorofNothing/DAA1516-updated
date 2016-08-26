import java.io.*;
import java.util.*;

// Classe para guardar um nome
class Equipa implements Comparable<Equipa> {
    public String name;
    public int nvictory;
    public int ties;
    public int loses;
    public int goalsplus;
    public int goalssuffered;
    public int points;
    public int media;
    

    Equipa(String n, int nv, int t, int l, int gp, int gs) {
		name = n;
		nvictory  = nv;
		ties = t;
		loses = l;
		goalsplus = gp;
		goalssuffered = gs;
		points = nvictory*3 + ties * 1 + loses * 0;
		media = goalsplus - goalssuffered;
    }
    
    // Definir como comparar dois elementos da classe Name
    // compareTo e uma funcao que compara objecto com outro objecto "n"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "n"
    //  - numero > 0 se objecto for maior que objecto "n"
    //  - zero, se objecto for igual ao objecto "n"
   
	@Override
	public int compareTo(Equipa e) {
		if(points > e.points) return -1;
		if(points < e.points) return 1;
		if(media > e.media) return -1;
		if(media < e.media) return 1;
		return(name.compareTo(e.name));
	}
}

public class Prob04 {
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);

	int n    = stdin.nextInt();	
	Equipa v[] = new Equipa[n]; 
	for (int i = 0; i<n; i++)
	    v[i] = new Equipa(stdin.next(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt());
       	
	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
	Arrays.sort(v);
	
	for (int i = 0; i<n; i++)
	    System.out.println(v[i].name + " " + v[i].points + " " + v[i].media);
    }
}
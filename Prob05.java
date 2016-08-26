import java.io.*;
import java.util.*;

class Prob05{
	// Juntar dois arrays ordenados
    // Assumir que os arrays sao v[start..middle] e v[middle+1..end]
    static int merge(int v[], int start, int middle, int end) {
    	int i, p1, p2;
    	int cont = 0;
    	int aux[] = new int[end+1];

    	p1=start;     // "Apontador" do array da metade esquerda
    	p2=middle+1;  // "Apontador" do array da metade direita
    	i = start;    // "Apontador" do array aux[] a conter juncao
    	while (p1<=middle && p2<=end) {            // Enquanto de para comparar
    		if (v[p1] <= v[p2]) 
    			aux[i++] = v[p1++];  // Escolher o menor e adicionar
    		else if(v[p1] > v[p2]){
    			aux[i++] = v[p2++];
    			cont += middle + 1 -p1;
    		}
    			
    	}
    	while (p1<=middle) 
    		aux[i++] = v[p1++];     // Adicionar o que resta
    	while (p2<=end)   
    		aux[i++] = v[p2++];
	
    	for (i=start; i<=end; i++) 
    		v[i] = aux[i];  // Copiar array aux[] para v[]
    	
    	return cont;
    }

    // Ordenar array v[] com mergesort entre posicoes start e end
    static int mergesort(int v[], int start, int end) {
    	int middle;
    	int counter = 0;
    	if (start<end) {                 // Parar quando tamanho do array < 2
    		middle = (start+end)/2;        // Calcular ponto medio
	    	counter += mergesort(v, start, middle);   // Ordenar metade esquerda
	    	counter += mergesort(v, middle+1, end);   // Ordenar metade direita
	    	counter += merge(v, start, middle, end);  // Combinar duas metades ordenadas
    	}
    	return counter;
    }
  
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] v = new int[n];
		int count = 0;
		for(int i = 0; i<n; i++){
			v[i] = in.nextInt();
		}
		count = mergesort(v,0,n-1);
		
		System.out.println(count);
	}
}
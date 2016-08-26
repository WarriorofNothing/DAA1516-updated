import java.io.*;
import java.util.*;

class Prob16_v1{

    static int v [][] = new int [101][101]; 
    static boolean d [][] = new boolean[101][101]; 
    static int count [] = new int [1001];
    static int out = 0;
    static int k;

    public static void dfs_1(int l,int c){
		k = 0; 
		for(int i=1;i<=l;i++){
	    	for(int j=1;j<=c;j++){
				if(!d[i][j]){ //os que nao foram marcados como visitados sao os 'C' e os ' '
		    		k++;//conta as celulas que estao a false
		    		dfs_2(i,j,l,c,k);
				}	
	    	}
		}
	}

    public static void dfs_2(int i, int j, int linhas, int colunas,int k){
	if((i<linhas-1 && i>0 ) && (j<colunas-1 && j>0))
	    if(!d[i][j]){
		d[i][j]=true;
		if(v[i][j]==1)
		    count[k]=count[k]+1;
		dfs_2(i+1,j,linhas,colunas,k);
		dfs_2(i-1,j,linhas,colunas,k);
		dfs_2(i,j+1,linhas,colunas,k);
		dfs_2(i,j-1,linhas,colunas,k);
	    }
    }

    public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	int l = in.nextInt();
	int c = in.nextInt();
	in.nextLine();
	for(int i=0;i<l;i++){
	    String str = in.nextLine();
	    	for(int j=0;j<c;j++){
				if(str.charAt(j)=='#' || str.charAt(j)=='P'){
		    		v[i][j]=-1;
		    		d[i][j]=true;
		    		out++;
				}else if(str.charAt(j)=='C'){
		    		v[i][j]=1;
				}else{
		    		v[i][j]=0;

				}
	   		 }
	}

	dfs_1(l,c);

	int maximum=Integer.MIN_VALUE;
	for(int i=0;i<k;i++){
	    if(count[i]>maximum)
		maximum=count[i];
	}
	System.out.println(maximum);
    }

 }
 
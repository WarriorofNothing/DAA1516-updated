import java.util.*;
import java.io.*;


class Prob07{
	static int p,q,r,s,t,u;
	public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	
		int c = in.nextInt();
		long num;
		
		double grausx;
		double numero;
		double x = 0;
	
		for (int i = 0;i<c; i++){
	
			p = in.nextInt();
			q = in.nextInt();
			r = in.nextInt();
			s = in.nextInt();
			t = in.nextInt();
			u = in.nextInt();
				
			double k = pesquisabinaria(0.0,1.0);
			if (k!=-1)
				System.out.printf("%.4f\n",k);
			if (k==-1)
				System.out.println("Impossivel");		
		}
	}


static double funcao(double num){
	double numero = (p * Math.exp(-num))+ (q * Math.sin(num)) + (r * Math.cos(num)) + (s * Math.tan(num)) + (t * num * num) + u;
	return numero;
}


static double pesquisabinaria(double low, double high){
		
double middle=0;		
		//System.out.println(low+" "+high+":"+ key + " middle=" + v[middle]);
		while(low+0.000000001<high){
			middle = low + (high - low)/2;
			//System.out.println(low+" "+high);
			if (funcao(low)==0)
				return low;
			if (funcao(high)==0)
				return high;
			if(funcao(middle)==0){
				//System.out.println(middle);
				return middle;
			}
			else if(funcao(middle)>0 && funcao(middle)*funcao(low)>0){
				low = middle;
				//pesquisabinaria(v,low,high,key);
			}
			else if(funcao(middle)>0 && funcao(middle)*funcao(low)<0){
				high = middle;
				//pesquisabinaria(v,low,high,key);
			}
			else if(funcao(middle)<0 && funcao(middle)*funcao(low)<0){
				high = middle;
				//pesquisabinaria(v,low,high,key);
			}
			else if(funcao(middle)<0 && funcao(middle)*funcao(low)>0){
				low = middle;
				//pesquisabinaria(v,low,high,key);
			}
			 if (funcao(low)*funcao(high)>0)
				return -1;
			}
		return low;
		
	}
}
import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment>{
	public int first;
	public int second;
	
	Segment(int l, int r){
		first = l;
		second = r;
	}

	@Override
	public int compareTo(Segment s){
		if(first < s.first) return -1;
		else return -1;
	}
	
	
	
}



public class Prob09{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int cob = in.nextInt(); // ate ao intervalo quer cobrir
		int nointer = in.nextInt(); // no. de intervalos a considerar
		
		Segment [] s = new Segment[nointer];
		
		for(int i = 0; i< nointer; i++){
			s[i] = new Segment(in.nextInt(),in.nextInt());
		}
		
		Arrays.sort(s);
		
		int end= 0; // fim 
		int actual_end = 0; //fim atualizado.
		int numb_seg = 0; // no. de segmentos que ha.
		
		
		while(end < cob){
			for(int i = 0; i < nointer; i++){
				if(s[i].first <= end)
					if(s[i].second > actual_end)
						actual_end = s[i].second;
			}
			end = actual_end;
			numb_seg++;
			
		}
		System.out.println(numb_seg);
	}
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class gemSweep3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		//String[] gems = {"DIA","RUBY", "RUBY", "DIA", "DIA","EMERALD", "SAPPHAIRE", "DIA"};
		//String[] gems = {"A","B","A","A","B","C","A","C","C","B","B"};
		//String[] gems = {"XYZ", "XYZ", "XYZ"};
		//String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
//		answer = [3, 5]
//				output = [1, 4]
		//String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		
		
		
		
		ArrayList<String> gemkind = new ArrayList<String>();
		
		for(int i=0;i<gems.length;i++){
			if(!gemkind.contains(gems[i])){				
				gemkind.add(gems[i]);
			}
		}
		System.out.println("gemkind"+gemkind);
		
		
		
		int first = 0;
		int last = 0;
		int min = gems.length+1;
		int[] answer ={first+1,last+1};
		HashMap<String,Integer> gemMap = new HashMap<String,Integer>();
		//if(gemMap.containsKey(gems[last])) gemMap.put(gems[last], gemMap.get(gems[last])+1);
		if(!gemMap.containsKey(gems[last])) gemMap.put(gems[last], 1);
		else gemMap.put(gems[last], gemMap.get(gems[last])+1);

		while(true){
			//if(first>=gems.length||last>=gems.length-1) break;
			
			System.out.println("first : "+first+" | last : "+last+" | min = "+min);
//			gemMap.clear();
//			for(int i = first;i<=last;i++){
//				if(!gemMap.containsKey(gems[i])) gemMap.put(gems[i], 1);
//				else gemMap.put(gems[i], gemMap.get(gems[i])+1);
//			}
			System.out.println("현재 gemMap >>>>>>>>>>"+gemMap.toString());
			
			if(gemMap.size()!=gemkind.size()){
//				if(!gemMap.containsKey(gems[last])) gemMap.put(gems[last], 1);
//				else gemMap.put(gems[last], gemMap.get(gems[last])+1);
				
				if(last<gems.length-1) {
					last++;
					if(!gemMap.containsKey(gems[last])) gemMap.put(gems[last], 1);
					else gemMap.put(gems[last], gemMap.get(gems[last])+1);
				}
				else if(last>=gems.length-1) {
					break;
				}


			} else{
				System.out.println("!!!!!!!!보석충분");
				if(min>(last+1)-(first+1)){
					System.out.println("헉 최솟값이넹!!!!!! 집어넣는다아앙!");
					min = (last+1)-(first+1);
					answer[0]=first+1;
					answer[1]=last+1;
					System.out.println(Arrays.toString(answer));
				}else if(min>(last+1)-(first+1)){
					if(answer[0]>first||answer[1]>last){
						System.out.println("헉 최솟값이넹!!!!!! 집어넣는다아앙!");
						min = (last+1)-(first+1);
						answer[0]=first+1;
						answer[1]=last+1;
						System.out.println(Arrays.toString(answer));
					}
				}
				
				
				int num = gemMap.get(gems[first])-1;
				System.out.println(gems[first]+" 현재 개수 "+gemMap.get(gems[first])+"를 -1 하겠읍니다.");
				if(num==0) {
					System.out.println("앗 현재 개수 0이니까 지운다아");
					gemMap.remove(gems[first]);
				}
				else {
					gemMap.replace(gems[first], num);
					System.out.println("숫자 줄인 결과"+gemMap.get(gems[first]));
				}
				if(first<gems.length-2){
					first++;
					continue;
				}
				else if(first>=gems.length-1) {
					break;
				}
				//first++;
			}
			
			if(first>=gems.length||last>=gems.length) break;
			
			if(first!=0&&first==gems.length-2) break;
//			else if(last>=gems.length) {
//				break;
//			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
		}
		
		System.out.println(Arrays.toString(answer));
		
		

	}

}

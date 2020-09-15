import java.util.Arrays;
import java.util.HashMap;

public class DialProb {
	public static void main(String[] args) {
		int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand="right";
		String answer = "";
		
		HashMap<Integer,int[]> keypad = new HashMap<Integer,int[]>();
		int[][] keypadLoc = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0}};
		
		for(int i=0;i<10;i++){
			keypad.put( i, keypadLoc[i]);
		}
		//check
		System.out.println(Arrays.toString(keypad.get(3)));
		
		int[] lCurrent = {3 ,0};
		int[] rCurrent = {3 ,2};
		
		
		for(int i:numbers){
			int[] dest = keypad.get(i);
			
			if (i==1||i==4||i==7){
				answer += "L";
				lCurrent = dest;
			}else if (i==3||i==6||i==9){
				answer += "R";
				rCurrent = dest;
			}else {
				
				if(Math.abs(dest[0]-lCurrent[0])+Math.abs(dest[1]-lCurrent[1])>Math.abs(dest[0]-rCurrent[0])+Math.abs(dest[1]-rCurrent[1])){
					answer += "R";
					rCurrent = dest;
				}
				else if (Math.abs(dest[0]-lCurrent[0])+Math.abs(dest[1]-lCurrent[1])<Math.abs(dest[0]-rCurrent[0])+Math.abs(dest[1]-rCurrent[1])){
					answer+="L";
					lCurrent = dest;
				}
				else{
					if (hand.equals("right")) {
						answer+="R";
						rCurrent = dest;
					}
					else {
						answer+="L";
						lCurrent = dest;
					}
				}
			}
			System.out.println(answer);
			
			
		}
		
		
		
		
		
		
        
	}
}

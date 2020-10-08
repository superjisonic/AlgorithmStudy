import java.util.ArrayList;
import java.util.Arrays;

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		brown	yellow	return
//				10	2	[4, 3]
//				8	1	[3, 3]
//				24	24	[8, 6]
		
		int brown = 16;
		int yellow = 9;
		int[] answer = new int[2];
		
		ArrayList<Integer> divisor = new ArrayList();
		//yellow 약수 구하기.
		for(int i = 1; i<=yellow; i++){
            if(yellow % i ==0){
                divisor.add(i);
            }
        }
		System.out.println(divisor.toString());
		
		System.out.println(divisor.get(divisor.size()/2));
		//int w = divisor.get(divisor.size()/2);
		//int h = divisor.get(divisor.size()/2 -1);
		int w = 0;
		int h = 0;
		
		if(divisor.size()==1){
			answer[0]=3;
			answer[1]=3;
		}else{
			for(int i=0;i<divisor.size()/2;i++){
				if(divisor.size()%2==1){
					w = divisor.get(divisor.size()/2+i);
					h = divisor.get(divisor.size()/2-i);
					System.out.println("w:"+w+"  | h:"+h);
					System.out.println(2*((h+2)+w));
				}else{
					w = divisor.get(divisor.size()/2+i);
					h = divisor.get(divisor.size()/2 -(1+i));
					System.out.println("w:"+w+"  | h:"+h);
					System.out.println(2*((h+2)+w));
				}
				if(2*((h+2)+w)==brown){
					answer[0]=w+2;
					answer[1]=h+2;
					break;
				}
				
			}
		}
		
		
		
		
		System.out.println(Arrays.toString(answer));
		
	}

}

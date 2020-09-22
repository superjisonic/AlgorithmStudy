import java.util.ArrayList;

public class StringCompressor {
	public static int solution(String s) {
        int answer = 0;
        int slen = s.length();
        int min = slen;
        int cut = 1;
//        ArrayList<Integer> cut = new ArrayList<Integer>(); 
//        for(int i = 1; i<=slen; i++){
//            if(slen % i ==0){
//                cut.add(i);
//            }
//        }
//        System.out.println(cut+" "+cut.size());
        
        if(slen==1) answer = min;
        
        else{
        	
        	while(slen/cut>1){
        		System.out.println(slen+" while "+(slen/cut));
        		System.out.println("_______________________________cut "+cut);
        		String comS = "";
        		int comN = 1;
            	ArrayList<String> sarry = new ArrayList<String>();

            	String remainS = s;
            	while(remainS.length()>=0){
            		if(remainS.length()<cut){
            			sarry.add(remainS);
            			break;
            		}
            		else{
            			sarry.add(remainS.substring(0, cut));
                		remainS = remainS.substring(cut);
            		}
            		
            		System.out.println(remainS);

        		
        		}

            	System.out.println(sarry);
            	if(sarry.size()==1) break;
            	for(int i=0;i<sarry.size()-1;i++){
            		if(sarry.size()-2==i) {
            			
            			if(comN==1) {
            				comS += sarry.get(i);
            			} else comS+= Integer.toString(comN)+sarry.get(i);
            			comS +=sarry.get(i+1);
            		}else{
            			if(sarry.get(i).equals(sarry.get(i+1))) {
            				comN++;
            				
            			}
                		else{
                			
                			if(comN==1) {
                				comS += sarry.get(i);
                			}
           
                			else comS+= Integer.toString(comN)+sarry.get(i);
                			comN = 1;
                			System.out.println("comS>>"+comS);
                			System.out.println("i : "+i);
                		}
            		}
            		
            		
            		
            	}
            	
            	System.out.println(comS);
            	if(comS.length() < min) min = comS.length();
            	System.out.println("min>>"+min);
            	cut++;
            	
            }        	
        }
        answer = min;
        System.out.println("answer >> "+answer);
        return answer;
    }

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
//		"aabbaccc"	7 >> 
//		"ababcdcdababcdcd"	9
//		"abcabcdede"	8
//		"abcabcabcabcdededededede"	14
//		"xababcdcdababcdcd"	17
		solution(s);
		//System.out.println(solution(s));
		//solution(s);

	}

}

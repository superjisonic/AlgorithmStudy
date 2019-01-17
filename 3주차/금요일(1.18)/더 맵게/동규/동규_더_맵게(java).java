package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(new int[] {7,6,5,4,3,2,1,0},7);
		
		System.out.println(answer);
	}

}

class Solution {
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        int first = 0;
        int second = 0;
        
        for(int i = 0; i <scoville.length; i++) {
        	insert(scoville[i]);
//        	list.add(scoville[i]);
        }
      
//        Collections.sort(list, new AscendingInteger()); // input 오름차순 정렬
        
        while(list.get(0)<K) { // 제일 작은게 K보다 작다면
        	if(list.size() == 1) { // 제일 작은게 K보다 작은 데 1개만 남은 경우 (실패)
        		return -1;
        	}
        	int arg1 = list.get(0);
        	delete_top();
        	int arg2 = list.get(0);
        	delete_top();
        	insert(arg1+arg2*2);
        	answer++;
        }
        
        
        return answer;
    }
    
    public void insert(int num) {
    	list.add(num);
    	int before = list.size()-1;
    	for(int i = list.size()/2-1; i>=0;i=(i-1)/2) {
    		if(list.get(i)>num) {
    			swap(i,before);
    			before = i;
    		}
    		else {
    			break;
    		}
    	}
    }
    
    public void delete_top() {
    	list.set(0, list.get(list.size()-1));
    	list.remove(list.size()-1);
    	for(int i = 0; i <= list.size()/2-1;) {
    		if(list.size()-1 >= i*2+2) {
	    		if(list.get(i*2+1)<list.get(i) && list.get(i*2+1)<=list.get(i*2+2)) {
	    			swap(i,i*2+1);
	    			i = i*2+1;
	    		}
	    		else if(list.get(i*2+2)<list.get(i) && list.get(i*2+1)>=list.get(i*2+2)) {
	    			swap(i,i*2+2);
	    			i = i*2+2;
	    		}
	    		else {
	    			break;
	    		}
    		}
    		else {
    			if(list.get(i*2+1)< list.get(i)) {
    				swap(i,i*2+1);
    				break;
    			}
    			else {
    				break;
    			}
    		}
    	}
    }
    
    public void swap(int i, int j) {
    	int temp = list.get(i);
    	list.set(i, list.get(j));
    	list.set(j, temp);
    }
    
}

class AscendingInteger implements Comparator<Integer>{
	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
}
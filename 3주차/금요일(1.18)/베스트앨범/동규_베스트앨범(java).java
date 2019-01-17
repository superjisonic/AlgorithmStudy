package programmers;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer[] = {};
		answer = test.solution(new String[] {"classic", "pop", "classic", "pop", "classic", "classic"}, new int[] {400,600,150,2500,500,500});
		
		for(int i = 0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}

	
class Solution {
	ArrayList<MusicInfo> list = new ArrayList<MusicInfo>();
	Boolean exist = false;
	
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int[] genre_filter = new int[2];
        
		MusicInfo temp2 = new MusicInfo();
		temp2.setFirst(0);
		temp2.setSecond(-1);
		temp2.setGenre(genres[0]);
		temp2.setTotal(plays[0]);
		list.add(temp2);
        
        for(int i = 1; i<genres.length;i++) {
        	for(int j = 0; j<list.size(); j++) {
        		if(list.get(j).getGenre().equals(genres[i])) {
        			exist = true;
        			MusicInfo temp = new MusicInfo();
        			temp.setGenre(genres[i]);
        			temp.setTotal(list.get(j).getTotalListen()+plays[i]);
        			
        			if(list.get(j).getSecond() == -1) {
        				if(list.get(j).getFirst() == -1) {
        					temp.first = i;
        					temp.second = -1;
        				}
        				else {
        					if(plays[list.get(j).getFirst()]<plays[i]) {
        						temp.second = list.get(j).getFirst();
        						temp.first = i;
        					}
        					else if(plays[list.get(j).getFirst()]==plays[i]) {
        						if(list.get(j).getFirst()>i) {
        							temp.second = list.get(j).getFirst();
            						temp.first = i;
        						}
        						else {
        							temp.second = i;
            						temp.first = list.get(j).getFirst();
        						}
        					}
        					else {
        						temp.second = i;
        						temp.first = list.get(j).getFirst();
        					}
        				}
        			}
        			else {
        				if(plays[list.get(j).getSecond()]<=plays[i]) {
        					if(list.get(j).getSecond() < i && plays[list.get(j).getSecond()]==plays[i]) {
        						temp.second = list.get(j).getSecond();
        					}
        					else {
        						temp.second = i;
        					}
        				}
        				if(plays[list.get(j).getFirst()]<=plays[i]) {
        					if(list.get(j).getFirst() < i && plays[list.get(j).getFirst()]==plays[i]) {
        						temp.second = i; 
        						temp.first = list.get(j).getFirst();
        					}
        					else {
        						temp.second = list.get(j).getFirst();
        						temp.first = i;	
        					}
    					}
        			}
        			list.set(j, temp);
        		}
        	}
        	if(!exist) {
        		MusicInfo temp = new MusicInfo();
        		temp.setFirst(i);
        		temp.setSecond(-1);
        		temp.setGenre(genres[i]);
        		temp.setTotal(plays[i]);
        		list.add(temp);
        	}
        	exist = false;
        }
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        if(list.size()==1) {
        	if(list.get(0).getSecond() != -1) {
        		answer = new int[] {list.get(0).getFirst(),list.get(0).getSecond()};
	    	}
	    	else {
	    		answer = new int[] {list.get(0).getFirst()};
	    	}
        }
        else {
	        int[] total = new int[list.size()];
	        for(int i = 0; i<list.size();i++) {
	        	total[i] = list.get(i).getTotalListen();
	        }
	        Arrays.sort(total);
	        for(int i = total.length-1; i>=0; i--) {
	        	for(int j = 0; j <list.size(); j++) {
	        		if(list.get(j).getTotalListen() == total[i]) {
	        			answerList.add(list.get(j).getFirst());
	        			if(list.get(j).getSecond() != -1) {
	        				answerList.add(list.get(j).getSecond());
	        			}
	        		}
	        	}
	        }
        }

        int[] answer2 = new int[answerList.size()];
        
        for (int i = 0; i<answerList.size();i++) {
        	answer2[i] = answerList.get(i);
        }
        answer = answer2;
        
        return answer;
    }
    
    public int[] bestTwo() {
    	int[] answer = {};
    	int first = -1;
    	int second = -1;
    	
    	for(int i = 0; i<list.size();i++) {
    		if(i == 0) {
    			first = 0;
    		}
    		else if(i == 1) {
    			if(list.get(0).getTotalListen() < list.get(1).getTotalListen()) {
    				first = 1;
    				second = 0;
    			}
    			else {
    				first = 0;
    				second = 1;
    			}
    		}
    		else {
    			if(list.get(second).getTotalListen() < list.get(i).getTotalListen()) {
    				second = i;
    			}
    			if(list.get(first).getTotalListen() < list.get(i).getTotalListen()) {
    				second = first;
    				first = i;
    			}
    		}
    	}
    	answer = new int[] {first,second};
    	return answer;
    }
}
    
class MusicInfo{
	String genre;
	int total_listen = 0;
	int first = -1;
	int second = -1;
	
	public String getGenre() {
		return genre;
	}
	
	public int getTotalListen() {
		return total_listen;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setTotal(int total) {
		total_listen = total;
	}
	
	public void setFirst(int first) {
		this.first = first;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
}
package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer[] = {};
		answer = test.solution(new String[] {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"}, new int[] {500, 600, 150, 800, 2500, 2100, 1000});		
		
		for(int i = 0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
	
	ArrayList<Music> album = new ArrayList<Music>();
	ArrayList<Integer> answer_Temp = new ArrayList<Integer>();
	
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        boolean exist = false;

        Music temp = new Music();
        temp.genre = genres[0];
        temp.play = plays[0];
        
        album.add(temp);
        
        /* 장르별 총 재생수 합 구하기 */
        for(int i = 1 ; i<genres.length;i++) {
        	for(int j = 0; j <album.size(); j++) {
        		if(genres[i].equals(album.get(j).genre)) {
        			Music temp2 = new Music();
        			temp2.genre = album.get(j).genre;
        			temp2.play = album.get(j).play + plays[i];
        			album.set(j,temp2);
        			exist = true;
        		}
        	}
    		if(!exist) {
    			Music temp2 = new Music();
    			temp2.genre = genres[i];
    			temp2.play = plays[i];
    			album.add(temp2);
    		}
			exist = false;
        }
        
        DescendingSort desc = new DescendingSort();
        Collections.sort(album, desc);
        
        for(int i = 0; i<album.size();i++) find_top_two(album.get(i).genre,genres,plays);
        
        int[] aTemp = new int[answer_Temp.size()];
        
        for(int i =0;i<answer_Temp.size();i++) { aTemp[i] = answer_Temp.get(i);}
        
        answer = aTemp;
        
        return answer;
    }
    
    public void find_top_two(String genre, String[] genres, int[] plays) {
    	int first = -1;
    	int second = -1;
    	
    	for(int i = 0; i<genres.length; i++) {
    		if(genre.equals(genres[i])) {
    			if(second == -1) {
    				if(first == -1) first = i; // 하나도 없을 때
    				else { // first는 있을 때
    					if(plays[first] < plays[i]) { // 1개 있을 때 찾은게 더 큼
    						second = first;
    						first = i;
    					}
    					else if(plays[first] == plays[i]) { // first랑 같을 때
    						if(first > i) { // first랑 같은 데 고유 번호가 찾은 게 더 낮음
    							second = first;
    							first = i;
    						}
    						else { // 고유 번호가 찾은 게 더 큼
    							second = i;
    						}
    					}
    					else second = i;
    				}
    			}
    			else { // 2개다 찾아 져있을 때
    				if(plays[second] < plays[i]) {
    					second = i;
    				}
    				else if(plays[second]==plays[i]) {
    					if(second > i) {
    						second = i;
    					}
    				}else {}
    				
    				if(plays[first] < plays[i]) {
    					second = first;
    					first = i;
    				}else if(plays[first] == plays[i]) {
    					if(first > i) {
    						second = first;
    						first = i;
    					}
    				}else {}
    			}
    		}
    	}
    	if(first != -1) answer_Temp.add(first);
    	if(second != -1) answer_Temp.add(second);
    }
    
}

class Music {
	String genre;
	Integer play;
	
	Music(){
		
	}
	
	Music(String genre, Integer play){
		this.genre = genre;
		this.play = play;
	}
}

class DescendingSort implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		return o2.play.compareTo(o1.play);
	}
	
}

package programmers;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		String answer;
		answer = test.solution("ABCDEFG",new String[] {"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"});
		
		System.out.println(answer);
	}

}

class Solution {
	public String solution(String m, String[] musicinfos) {
		String answer = "";
		String[] music_string = new String[musicinfos.length];
		String[] temp;
		String[] start_time;
		String[] end_time;
		int[] play_time = new int[musicinfos.length];
		int play_time_max;
		int max = 0;
		ArrayList<Integer> answer_list = new ArrayList<Integer>();
		
		
		/* 찾고자하는 음정 변환 */
		m = m.replaceAll("A#", "a");
		m = m.replaceAll("B#", "b");
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("E#", "e");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		
		for(int i = 0; i < musicinfos.length; i++) {
			
			temp = musicinfos[i].split(","); // 노래 1곡
			start_time = temp[0].split(":");
			end_time = temp[1].split(":");
			play_time[i] = (Integer.parseInt(end_time[0])*60+Integer.parseInt(end_time[1])) - (Integer.parseInt(start_time[0])*60+Integer.parseInt(start_time[1]));

			music_string[i] = "";
	
			/* 리스트 음정 변환 */
			temp[3] = temp[3].replaceAll("A#", "a");
			temp[3] = temp[3].replaceAll("B#", "b");
			temp[3] = temp[3].replaceAll("C#", "c");
			temp[3] = temp[3].replaceAll("D#", "d");
			temp[3] = temp[3].replaceAll("E#", "e");
			temp[3] = temp[3].replaceAll("F#", "f");
			temp[3] = temp[3].replaceAll("G#", "g");
			
			for(int j = 0; j<play_time[i];j++) {
				music_string[i] += temp[3].charAt(j%temp[3].length());
			}
			
			if(music_string[i].contains(m)) {
				answer_list.add(i);
			}
		}
		
		if(answer_list.size() == 0) { // 곡이 없는 경우
			answer = "(None)";
		}
		else if(answer_list.size() == 1) { // 1곡 찾은 경우
			answer = musicinfos[answer_list.get(0)].split(",")[2];
		}
		else { // 여러 곡인 경우
			ArrayList<Integer> answer_hubo = new ArrayList<Integer>();
			
			for(int i = 0; i < answer_list.size(); i++) {
				if(play_time[answer_list.get(i)] > max) {
					play_time_max = answer_list.get(i);
					max = play_time[answer_list.get(i)];
					answer_hubo.clear();
					answer_hubo.add(answer_list.get(i));
				}
				else if(play_time[i] == max) {
					answer_hubo.add(i);
				}
				else {
					continue;
				}
			}
			
			answer = musicinfos[answer_hubo.get(0)].split(",")[2];
		}
		
		return answer;
	}
}
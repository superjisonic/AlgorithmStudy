package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		answer = test.solution(4,5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"});
		System.out.println(answer);

	}
}

class Solution {
	  public int solution(int m, int n, String[] board) {
	      int answer = 0;
	      char[][] game_board = new char[m][n];
	      boolean has_erase = false;
	      ArrayList<Integer> erase_index = new ArrayList<Integer>();
	      
	      for(int i=0; i<m;i++) {
	    	  for(int j =0;j<n;j++) {
	    		  game_board[i][j] = board[i].charAt(j);
	    	  }
	      }
	      
	      do {
	    	  has_erase = false;
	    	  erase_index.clear();
	    	  
	    	  for(int i = 0; i<m-1;i++) {
	    		  for(int j=0;j<n;j++) {
	    			  if(game_board[i][j] != '0') {
		    			  if(i==0 && j == 0) {
	    					  if((game_board[i][j] == game_board[i][j+1]) && (game_board[i][j] == game_board[i+1][j]) && (game_board[i][j] == game_board[i+1][j+1])) {
	    						  if(!erase_index.contains(i*n+j)) {
	    							  erase_index.add(i*n+j);  
	    						  }
	    						  has_erase = true;
	    					  }
		    				  else {
		    					  continue;
		    				  }
		    			  }
	    				  // 왼쪽 위
	    				  else if((j != n-1) &&(game_board[i][j] == game_board[i][j+1]) && (game_board[i][j] == game_board[i+1][j]) && (game_board[i][j] == game_board[i+1][j+1])) { 
	    					  if(!erase_index.contains(i*n+j)) {
								  erase_index.add(i*n+j);  
							  }
	    					  if(!erase_index.contains(i*n+(j+1))) {
								  erase_index.add(i*n+j+1);  
							  }
	    					  if(!erase_index.contains((i+1)*n+j)) {
								  erase_index.add((i+1)*n+j);  
							  }
	    					  if(!erase_index.contains((i+1)*n+j+1)) {
								  erase_index.add((i+1)*n+j+1);  
							  }
							  has_erase = true;
	    				  }
	    				  // 오른쪽 위
	    				  else if((j != 0 )&&(game_board[i][j] == game_board[i][j-1]) && (game_board[i][j] == game_board[i+1][j]) && (game_board[i][j] == game_board[i+1][j-1])) {
	    					  if(!erase_index.contains(i*n+j)) {
								  erase_index.add(i*n+j);  
							  }
	    					  if(!erase_index.contains(i*n+(j-1))) {
								  erase_index.add(i*n+j-1);  
							  }
	    					  if(!erase_index.contains((i+1)*n+j)) {
								  erase_index.add((i+1)*n+j);  
							  }
	    					  if(!erase_index.contains((i+1)*n+j-1)) {
								  erase_index.add((i+1)*n+j-1);  
							  }
							  has_erase = true;
	    				  }
	    				  else {
	    					  continue;
	    				  }
	    			  }
	    		  }
	    	  }
	    	  for(int i = 0; i<erase_index.size();i++) {
	    		  int garo;
	    		  int sero;
	    		  garo = erase_index.get(i)%n;
	    		  sero = erase_index.get(i)/n;
	    		  game_board[sero][garo] = '0';
	    	  }
	    	  for(int i = 0; i<m-1; i++) {
	    		  for(int j = 0;j<n;j++) {
	    			  if(game_board[i+1][j] == '0') {
	    				  for(int h = i; h >=0;h--) {
	    					  game_board[h+1][j] = game_board[h][j];
	    					  game_board[h][j] = '0';
	    				  }
	    			  }
	    		  }
	    	  }
	      }while(has_erase);
	      
	      
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j<n;j++) {
	    		  if(game_board[i][j] == '0') answer++;
	    	  }
	      }
	      return answer;
	  }
}
	
package samsung_sw;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static int arr_size;
	static int[][] space;
	static int[][] was_merged;
	static int l;
	static int r;
	static int merge_count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] input_arr = input_arr = input.split(" ");
		boolean can_merge = true;
		int day = 0;
		
		arr_size = Integer.parseInt(input_arr[0]);
		l = Integer.parseInt(input_arr[1]);
		r = Integer.parseInt(input_arr[2]);
		
		space = new int[arr_size][arr_size]; 
		was_merged = new int[arr_size][arr_size];
		
		/* 인풋 초기화 */
		for(int i =0; i<arr_size; i++) {
			input = sc.nextLine();
			input_arr = input.split(" ");
			for(int k = 0; k<input_arr.length;k++) {
				space[i][k] = Integer.parseInt(input_arr[k]);
				was_merged[i][k] = 0;
			}
		}
		
		/* 합병 알고리즘 */
		while(can_merge) {
			init_bool_arr();
			can_merge = false;

			for(int i = 0; i<arr_size; i++) {
				for(int j=0;j<arr_size;j++) {
					if(was_merged[i][j] == 0) {
						merge_count = 0;
						int all = find(i,j,-1);
						if(merge_count > 1) {
							can_merge = true;
							avg(i,j,all/merge_count);
						}
						else {
							was_merged[i][j] = 2;
						}
					}
				}
			}
			if(can_merge) {
				day++;
			}
		}
		
		System.out.println(day);
	}
	
	static int find(int x, int y, int value) {
		if( x<0 || x>arr_size-1 || y<0 || y>arr_size-1) {
			return 0;
		}
		if(was_merged[x][y]!=0) {
			return 0;
		}
		if(value != -1) {
			int diff = Math.abs(value - space[x][y]);
			if(diff < l || diff > r) {
				return 0;
			}
		}
		
		was_merged[x][y] = 1;
		merge_count++;

		int sum = space[x][y];
		sum += find(x-1,y,space[x][y]);
		sum += find(x+1,y,space[x][y]);
		sum += find(x,y-1,space[x][y]);
		sum += find(x,y+1,space[x][y]);
		
		
		return sum;
	}
	
	static void avg(int x, int y, int value) {
		if( x<0 || x>arr_size-1 || y<0 || y>arr_size-1) {
			return;
		}
		if(was_merged[x][y]!=1) {
			return;
		}
		
		was_merged[x][y] = 2;
		
		space[x][y] = value;
		avg(x-1,y,value);
		avg(x+1,y,value);
		avg(x,y-1,value);
		avg(x,y+1,value);
	}
	
	static void init_bool_arr() {
		for(int i = 0; i<arr_size;i++) {
			for(int j=0;j<arr_size;j++) {
				was_merged[i][j] = 0;
			}
		}
	}

}

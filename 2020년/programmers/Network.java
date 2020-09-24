
public class Network {
	
	public static void checkNetwork(int ii, int[][] com, boolean[] connected){
		connected[ii] = true;
		for(int j =0 ; j < com.length;j++ ){
			if(ii==j) continue;
			else{
				if(connected[j]==false){
					if(com[ii][j]==1){
						checkNetwork(j, com, connected);
					}
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		n	computers	return
//				3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
//				3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
		
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int answer = 0;
		boolean[] network = new boolean[n];
		
		for(int i = 0;i<n;i++){
			network[i]=false;
		}
		
//		for(int i=0;i<computers.length;i++){
//			for(int j=0;j<computers[i].length;j++){
//				if(i==j) continue;
//				else{
//					if(computers[i][j]==1){
//						checkNetwork(i,computers[i][j])
//					}
//				}
//			}
//		}
		for(int i = 0;i<n;i++){
			if (network[i]==false) {
				checkNetwork(i,computers, network);
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}

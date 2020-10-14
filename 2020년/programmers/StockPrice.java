import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
	static class Stock{
		int price;
		int time;
		Stock(int p, int t){
			this.price = p;
			this.time = t;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		prices	return
//		[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//		[1, 2, 3, 2, 3, 3, 1] [6, 5, 1, 3, 2, 1, 0]
		
		int[] prices = {1, 2, 3, 2, 3, 3, 1};
		
		//Queue<Stock> s = new LinkedList<>();
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++){
			for(int j = i+1;j< prices.length;j++){
				
				if(prices[i]<=prices[j]){
					System.out.println("안떨어짐:"+(j-i)+" counter: "+ i);
					answer[i] = j - i;
					
				}else{
					System.out.println("떨어짐 counter"+ i);
					answer[i]= j- i;
					break;
				}

			}
			
		}

		System.out.println(Arrays.toString(answer));
	}

}

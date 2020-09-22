
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class OpenChat {
	
	public String enter(String name){
		return "";
	}
	
	

	public static void main(String[] args) {
		
		
		//String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		//String[] result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
		String[] record ={"Enter uid1111 AAA", "Leave uid1111","Enter uid1111 AAB", "Enter uid2222 BBB","Change uid1111 CCC","Leave uid1111","Enter uid3333 BBB","Change uid2222 DDDD"};
		
		ArrayList<String> ans = new ArrayList<String>();
		
		HashMap<String, String> idNm = new HashMap<String, String>();
		HashMap<String, ArrayList<Integer>> idAns = new HashMap<String, ArrayList<Integer>>();
		
		for(String r : record){
			String[] command = r.split(" ");
			System.out.println(Arrays.toString(command));
			if(command[0].equals("Enter")){
				System.out.println("Enter>>>>>>>>>>>>>>>>>");
				
				//idNm에 add
				if(idNm.containsKey(command[1])){
					
					for(int i : idAns.get(command[1])){
						ans.set(i, ans.get(i).replace(idNm.get(command[1]), command[2]));
						System.out.println("enter::"+ans.get(i)+"를 @@@changing@@@ " + idNm.get(command[1])+" into "+command[2]);
					}
					idNm.put(command[1], command[2]);
					
				}else{
					System.out.println("test!!!!!");
					idNm.put(command[1], command[2]);
				}
				
				//put a log on idAns
				if(!idAns.isEmpty()&& idAns.containsKey(command[1])){
					ArrayList<Integer> temp = idAns.get(command[1]);
					temp.add(ans.size());
					idAns.put(command[1], temp);
					System.out.println("putting into idAns!!! "+idAns.toString());
				}else{
					idAns.put(command[1], new ArrayList<Integer>(Arrays.asList(ans.size())));
					System.out.println("putting into idAns!!! else "+idAns.toString());
				}
				
				
				
				
				
				ans.add(command[2]+"님이 들어왔습니다.");
				
			}else if(command[0].equals("Leave")){
				
				
				//idAnswer add
				if(idNm.containsKey(command[1])){
					ArrayList<Integer> temp = idAns.get(command[1]);
					temp.add(ans.size());
					idAns.put(command[1], temp);
					System.out.println("putting into idAns!!! "+idAns.toString());
				}
				
				
				//finally add ans List
				ans.add(idNm.get(command[1])+"님이 나갔습니다.");
				
				//idName remove
				//idNm.remove(command[1]);
				
			}else if(command[0].equals("Change")){
				//id name change
				if (idNm.containsKey(command[1])){
					//이미 들어왔던 적이 있단 뜻
					System.out.println("containsKey of "+command[1]);
					for(int i : idAns.get(command[1])){
						
						ans.set(i, ans.get(i).replace(idNm.get(command[1]), command[2]));
						System.out.println(ans.get(i)+"를 @@@changing@@@ " + idNm.get(command[1])+" into "+command[2]);
						System.out.println(ans.toString());
					}

					idNm.replace(command[1], command[2]);
				}
				
			}else{
				continue;
			}
			System.out.println("________("+ans.toString()+")_____________");
			
		}
		
		//answer creation for loop with idNam
		String[] answer = ans.toArray(new String[ans.size()]);
		
		
		System.out.println(Arrays.toString(answer));

	}

}

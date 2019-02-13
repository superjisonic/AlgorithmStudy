#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <algorithm>
#include <map>

using namespace std;

vector<string> solution(vector<string> record);

vector<string> solution(vector<string> record)
{
	map<string, string> idname;
	vector<string> answer;
	vector<string> id;
	string temp;
	vector<string> condition(record.size(), "");
	vector<bool> inout;

	for (int i = 0; i < record.size(); i++)
	{
		stringstream check(record[i]);
		int j = 0;

		/* 띄어쓰기를 기준으로 나눠서 condition 배열에 저장 */
		while (getline(check, temp, ' '))
		{
			condition[j]=temp;
			j++;
		}

		if (condition[0] == "Enter")
		{
			id.push_back(condition[1]); // id 배열에 아이디 넣어주기
			inout.push_back(true); // inout 배열에 true 넣어주기
			idname[condition[1]] = condition[2]; // 아이디(condition[1])를 idname 배열에서 찾아서 이름 넣어주기 & 변경하기
		}
		else if (condition[0] == "Change")
		{
			idname[condition[1]] = condition[2];
		}
		else
		{
			id.push_back(condition[1]);
			inout.push_back(false);
		}
	}

	string ans="";
	for (int i = 0; i < id.size(); i++)
	{
		if (inout[i])
		{
			ans = idname[id[i]] + "님이 들어왔습니다.";
		}
		else
		{
			ans= idname[id[i]] + "님이 나갔습니다.";
		}
		answer.push_back(ans);
	}
	return answer;
}

int main()
{
	vector<string> ans = solution({ "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo" , "Change uid4567 Ryan" });

	for (int i = 0; i < ans.size(); i++)
	{
		cout << ans[i] << endl;
	}
}
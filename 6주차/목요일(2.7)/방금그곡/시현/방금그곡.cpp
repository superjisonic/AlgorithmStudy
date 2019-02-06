#include <string>
#include <vector>
#include <iostream>
#include <sstream>

using namespace std;

void find_Replace(string &data, string toSearch, string replaceStr);
string solution(string m, vector<string> musicinfos);

/* string의 일부를 바꿔주는 함수 */
void find_Replace(string &data, string toSearch, string replaceStr)
{
	size_t pos = data.find(toSearch);

	while (pos != string::npos)
	{
		data.replace(pos, toSearch.size(), replaceStr);
		pos = data.find(toSearch, pos + replaceStr.size());
	}
}

string solution(string m, vector<string> musicinfos)
{
	string answer = "";
	string temp;
	vector<vector<string>> split(musicinfos.size(), vector<string>(6, "")); // 2차원 배열 초기화
	vector<string> listen;
	vector<int> found;
	int min = 0;
	int timeDifference = 0;

	find_Replace(m, "C#", "c");
	find_Replace(m, "D#", "d");
	find_Replace(m, "F#", "f");
	find_Replace(m, "G#", "g");
	find_Replace(m, "A#", "a");

	for (int i = 0; i < musicinfos.size(); i++)
	{
		/* musicinfos의 :를 ,로 바꾸기 */
		find_Replace(musicinfos[i], ":", ",");

		find_Replace(musicinfos[i], "C#", "c");
		find_Replace(musicinfos[i], "D#", "d");
		find_Replace(musicinfos[i], "F#", "f");
		find_Replace(musicinfos[i], "G#", "g");
		find_Replace(musicinfos[i], "A#", "a");

		stringstream check(musicinfos[i]);
		int j = 0;

		/* 콤마(,)를 기준으로 나눠서 split 배열에 저장 */
		while (getline(check, temp, ','))
		{
			split[i][j]=temp;
			j++;
		}
	}

	for (int i = 0; i < split.size(); i++)
	{
		temp = "";
		min = 0;

		/* 재생시간 구하기 - string을 int로 변환 후 계산 */
		timeDifference = (stoi(split[i][2]) * 60 + stoi(split[i][3])) - (stoi(split[i][0]) * 60 + stoi(split[i][1]));

		/* 재생시간이 악보 정보보다 짧거나 같은 경우 재생시간만큼 listen 배열에 저장 */
		if (timeDifference <= split[i][5].length())
		{
			temp = split[i][5].substr(0, timeDifference);
			listen.push_back(temp);
		}
		else
		{
			while (min <= timeDifference-split[i][5].length())
			{
				min += split[i][5].length();
				temp += split[i][5];
			}
			if (min < timeDifference)
			{
				temp += split[i][5].substr(0, timeDifference - min);
			}
			listen.push_back(temp);
		}
	}

	/* m이 listen 배열에 있는지 검사 후 index를 found 배열에 순차적으로 추가 */
	size_t pos = 0;
	for (int i = 0; i < listen.size(); i++)
	{
		pos = listen[i].find(m);
		if (pos != string::npos)
		{
			found.push_back(i);
		}
	}

	int max = 0;
	if (found.size() == 1) // 한 곡 찾은 경우
	{
		answer = split[found[0]][4];
	}
	else if (found.size() == 0) // 한 곡도 못찾은 경우
	{
		answer = "(None)";
	}
	else // 여러 곡 찾은 경우
	{
		max = (stoi(split[found[0]][2]) * 60 + stoi(split[found[0]][3]))
			- (stoi(split[found[0]][0]) * 60 + stoi(split[found[0]][1]));
		answer = split[found[0]][4];
		for (int i = 1; i < found.size(); i++)
		{
			timeDifference = (stoi(split[found[i]][2]) * 60 + stoi(split[found[i]][3]))
				- (stoi(split[found[i]][0]) * 60 + stoi(split[found[i]][1]));
			/* 재생 시간 긴 경우 찾기 */
			if (max < timeDifference) // 재생 시간도 같을 경우 먼저 입력된 음악 제목 반환
			{
				max = timeDifference;
				answer = split[found[i]][4];
			}
		}
	}

	return answer;
}

int main()
{
	string ans = solution("ABCDEFG", { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" });
	cout << ans << endl;
	ans = solution("CC#BCC#BCC#BCC#B", { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" });
	cout << ans << endl;
	ans = solution("ABC", { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" });
	cout << ans << endl;
	return 0;
}
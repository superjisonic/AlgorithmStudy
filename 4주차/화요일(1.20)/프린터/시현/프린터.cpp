#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int findMax(vector<int> priorities);
int solution(vector<int> priorities, int location);

/* 중요도 배열에서 max 찾기 */
int findMax(vector<int> priorities)
{
	int max = priorities[0];
	for (int i = 1; i < priorities.size(); i++)
	{
		if (priorities[i] > max)
		{
			max = priorities[i];
		}
	}
	return max;
}

int solution(vector<int> priorities, int location)
{
	int answer = 0;
	int max = findMax(priorities);
	char alpha = 65 + location;
	queue<char> num;
	for (int i = 0; i < priorities.size(); i++)
	{
		num.push(65+i);
	}

	while(!num.empty())
	{
		if (priorities[0] == max && num.front() == alpha)
		{
			answer++;
			return answer;
		}
		else
		{
			if (priorities[0] < max)
			{
				num.push(num.front());
				num.pop();
				priorities.push_back(priorities[0]);
				priorities.erase(priorities.begin());
			}
			else
			{
				answer++;
				num.pop();
				priorities.erase(priorities.begin());
				max = findMax(priorities);
			}
		}
	}
	return answer;
}

int main()
{
	int ans = solution({ 2, 1, 3, 2 }, 2);
	cout << ans << endl;
	ans = solution({ 1, 1, 9, 1, 1, 1 }, 0);
	cout << ans << endl;
}
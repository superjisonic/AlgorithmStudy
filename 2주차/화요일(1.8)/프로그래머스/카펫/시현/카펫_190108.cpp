#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int red) {
	vector<int> answer;
	int x = 0;
	int y = 0;
	for (int i = 1; i<red + 1; i++)
	{
		if (red % i == 0)
		{
			x = red / i;
			y = i;
		}
		if ((x + 2)*(y + 2) - brown == red)
		{
			if (x >= y)
			{
				answer.push_back(x + 2);
				answer.push_back(y + 2);
				break;
			}
			else
			{
				answer.push_back(y + 2);
				answer.push_back(x + 2);
				break;
			}
		}
	}
	return answer;
}

int main()
{
	vector<int> sol(solution(10, 2));
	for (int i = 0; i < sol.size(); i++)
	{
		cout << sol[i] << " ";
	}
	return 0;
}
#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> triangle);

int solution(vector<vector<int>> triangle)
{
	int answer = 0;
	vector<vector<int>> sum(triangle.size(), vector<int>(triangle.size(), 0));
	sum[0][0] = triangle[0][0];
	for (int i = 1; i < triangle.size(); i++)
	{
		sum[i][0] = sum[i - 1][0] + triangle[i][0];
		for (int j = 1; j < triangle[i].size(); j++)
		{
			if (j == triangle[i].size() - 1)
			{
				sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
			}
			else
			{
				sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
				if (sum[i][j] < sum[i - 1][j] + triangle[i][j])
				{
					sum[i][j] = sum[i - 1][j] + triangle[i][j];
				}
			}
		}
	}
	answer = sum[sum.size() - 1][0];
	for (int i = 1; i < sum[sum.size() - 1].size(); i++)
	{
		if (answer < sum[sum.size() - 1][i])
		{
			answer = sum[sum.size() - 1][i];
		}
	}
	return answer;
}

int main()
{
	int ans = solution({ {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5} });
	cout << ans;
}
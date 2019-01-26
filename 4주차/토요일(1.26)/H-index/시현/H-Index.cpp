#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> citations);

int solution(vector<int> citations)
{
	int answer = 0;
	int index = citations.size()-1;
	/* citations 벡터 오름차순 정렬 */
	sort(citations.begin(), citations.end());

	for (int i = citations[citations.size()-1]; i >= 0; i--)
	{
		if (index != 0)
		{
			/* 숫자가 두 index 사이에 있을 때 큰 index 기준으로 함 */
			while (i == citations[index - 1])
			{
				index--;
				if (index == 0)
				{
					break;
				}
				if (citations[index - 1] < i && i <= citations[index])
				{
					break;
				}
			}
			/* h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었는지 확인 */
			if (i <= citations.size() - index && i >= index - 1)
			{
				answer = i;
				return answer;
			}
		}
		else
		{
			/* index가 0일때 h번 이상 인용된 논문이 h편 이상인지 확인 */
			if (i <= citations.size())
			{
				answer = i;
				return answer;
			}
		}
	}
}

int main()
{
	int ans = solution({ 3, 0, 6, 1, 5 }); // 3
	cout << ans << endl;
	ans = solution({ 2, 0, 8, 4, 6 }); // 3
	cout << ans << endl;
	ans = solution({ 7, 9, 2, 1, 4, 6, 5 }); // 4
	cout << ans << endl;
	ans = solution({ 10, 100 }); // 2
	cout << ans << endl;
	return 0;
}
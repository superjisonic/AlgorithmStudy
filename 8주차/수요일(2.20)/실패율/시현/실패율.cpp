#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages);

struct Pair {
	double start;
	int end;
};

bool compare(Pair p1, Pair p2) {
	return (p1.start > p2.start);
}

vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	vector<Pair> failure;
	int total = stages.size();
	int num = 0;
	int cnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < stages.size(); j++) {
			if (stages[j] == i+1) {
				cnt++;
				stages.erase(stages.begin() + j);
				j--;
			}
			else {
				continue;
			}
		}
		cout << stages.size() << " ";
		if (cnt == 0) {
			failure.push_back({ 0, i + 1 });
		}
		else {
			failure.push_back({ (double)cnt / (double)(total - num), i + 1 });
		}
		num += cnt;
		cnt = 0;
	}

	stable_sort(failure.begin(), failure.end(), compare);

	cout << endl;
	for (int i = 0; i < failure.size(); i++)
	{
		cout << failure[i].start << " " << failure[i].end << "  ";
	}
	
	for (int i = 0; i < failure.size(); i++)
	{
		answer.push_back(failure[i].end);
	}
	
	return answer;
}

int main() {
	vector<int> ans = solution(5, { 2, 1, 2, 6, 2, 4, 3, 3 });
	/*
	cout << endl;
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << " ";
	}
	cout << endl;
	cout << endl;
	ans = solution(4, { 4, 4, 4, 4, 4 });
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << " ";
	}
	cout << endl;
	cout << endl;
	ans = solution(6, { 3, 1, 2, 2, 4, 5, 1, 5 });
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << " ";
	}
	*/
}
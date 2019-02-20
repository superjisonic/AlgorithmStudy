#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int m, int n, vector<string> board);

int solution(int m, int n, vector<string> board) {
	int answer = 0;
	bool valid = false; // while문 탈출을 위한 조건 (더이상 지울 타일이 있는지 여부)

	vector<vector <bool>> check(m, vector<bool>(n, false));
	
	while (1) {
		valid = false; // 초기화

		/* check 배열 false로 초기화*/
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				check[i][j] = false;
			}
		}

		/* 지울 타일이 4개 있는지 확인 후 check배열 true로 바꾸기 */
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (board[i][j] != 'n' && board[i][j + 1] != 'n' && board[i + 1][j] != 'n' && board[i + 1][j + 1] != 'n') {
					if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i + 1][j] && board[i + 1][j] == board[i + 1][j + 1]) {
						check[i][j] = true;
						check[i][j + 1] = true;
						check[i + 1][j] = true;
						check[i + 1][j + 1] = true;
						valid = true;
					}
				}
			}
		}

		/* 왼쪽 밑에서부터 지울 타일이 있는지 확인하고 한칸씩 밑으로 내리기 */
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (check[j][i] == true) {
					answer++;
					for (int k = j-1; k >= 0; k--) {
						board[k + 1][i] = board[k][i];
						check[k + 1][i] = check[k][i];
					}
					board[0][i] = 'n';
					check[0][i] = false;
					j++;
				}
				else {
					continue;
				}
			}
		}

		/* while문 탈출 */
		if (!valid) {
			return answer;
		}
	}
}

int main() {
	/* test case */
	int ans = solution(6, 6, { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" });
	cout << ans << endl;
	ans = solution(4, 5, {"CCBDE", "AAADE", "AAABF", "CCBBF"});
	cout << ans << endl;
	return 0;
}
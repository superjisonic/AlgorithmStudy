#include <string>
#include <vector>
#include <iostream>
#include <math.h>

using namespace std;

string solution(int n, int t, int m, int p);

string solution(int n, int t, int m, int p){
	string answer = "";
	string sample = "0"; // 숫자 나열
	int num = 1; // 현재 탐색할 숫자(임시)
	int count = 1; // 현재 숫자
	int exp = 0; // 지수

	/* 숫자 나열하기 */
	while (sample.length() < t*m){
		/* 현재 숫자를 n진법으로 표현했을 때 자리수 구하기 */
		while (1){
			if (count < (int)pow(n, exp)){
				break;
			}
			exp++;
		}

		num = count;
		exp--;
		while (exp >= 0){
			if (num / (int)pow(n, exp) > 0){ // 자리수로 나눌 수 있을 때
				if (n <= 10){ // 10진수 이하일때
					sample += to_string(num / (int)pow(n, exp));
					num = num - (int)pow(n, exp)*(num / (int)pow(n, exp));
				}
				else{ // 10진수 초과일때
					if (num / (int)pow(n, exp) >= 10){
						if (num / (int)pow(n, exp) == 10){
							sample += "A";
						}
						else if (num / (int)pow(n, exp) == 11){
							sample += "B";
						}
						else if (num / (int)pow(n, exp) == 12){
							sample += "C";
						}
						else if (num / (int)pow(n, exp) == 13){
							sample += "D";
						}
						else if (num / (int)pow(n, exp) == 14){
							sample += "E";
						}
						else{
							sample += "F";
						}
						num = num - (int)pow(n, exp)*(num / (int)pow(n, exp));
					}
					else{
						sample += to_string(num / (int)pow(n, exp));
						num = num - (int)pow(n, exp)*(num / (int)pow(n, exp));
					}
				}
			}
			else{ // 자리수로 나눌 수 없을 때
				sample += "0";
			}
			exp--;
		}
		count++;
		exp = 0;
	}

	/* 말하는 숫자 나열 */
	p--;
	while (answer.length() != t) {
		answer += sample.at(p);
		p += m;
	}

	return answer;
}

int main(){
	string ans = solution(2, 4, 2, 1);
	cout << ans << endl;
	ans = solution(6, 5, 3, 1);
	cout << ans << endl;
	ans = solution(16, 8, 2, 2);
	cout << ans << endl;
	ans = solution(14, 7, 3, 1);
	cout << ans << endl;
	ans = solution(10, 6, 3, 3);
	cout << ans << endl;
}
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

bool is_3_multiple(int n) {

	int sum = 0;

	while (n >= 10) {
		sum += n % 10;
		n = n / 10;
	}
	sum += n;

	if (sum % 3 == 0) {
		return true;
	}
	else {
		return false;
	}
}

long long solution(int N) {
	long long answer = 0;
	bool is_prime = true;
	int* arr;
	int num = 1;

	arr = (int*)malloc(sizeof(int)*(N+1));

	for (int i = 2; i <= N; i++) {
		is_prime = true;
		if (i == 2 || i == 3 || i == 5 || i == 7) {
			answer += i;
		}
		else if (i % 2 == 0) {
			continue;
		}
		// 3의 배수
		else if (is_3_multiple(i)) {
			continue;
		}
		// 5의 배수
		else if (i % 5 == 0) {
			continue;
		}
		// 7의 배수
		else if (i % 7 == 0) {
			continue;
		}
		else { // 제곱수들 찾기
			if (arr[i] != 99) {
				answer += i;
			}
			
			while (i*num <= N) {
				if (arr[i*num] == 99) {
					num++;
					continue;
				}
				arr[i*num] = 99;
				num++;
			}
			num = 1;
		}
	}
	
	return answer;

}

void main() {
	cout << solution(1000);
}
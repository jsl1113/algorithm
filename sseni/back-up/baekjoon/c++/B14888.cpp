#include <iostream>
#include <cstring>

using namespace std;
int n, num[100], oper[4];
int maxNum = INT_MIN;
int minNum = INT_MAX;

void f(int c, int v) {
	if (c == n) {
		minNum = min(minNum, v);
		maxNum = max(maxNum, v);
	}
	else {
		for (int i = 0; i < 4; i++) {
			if (oper[i] == 0) continue;

			oper[i]--;  // 선택
			if (i == 0) f(c + 1, v + num[c]);
			else if (i == 1) f(c + 1, v - num[c]);
			else if (i == 2) f(c + 1, v * num[c]);
			else if (i == 3) f(c + 1, v / num[c]);
			oper[i]++;  // 복원
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++)  cin >> num[i]; 
	for (int i = 0; i < 4; i++)  cin >> oper[i]; 
	f(1, num[0]);
	cout << maxNum << '\n';
	cout << minNum << '\n';
}
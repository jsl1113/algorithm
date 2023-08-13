#include <iostream>
#include <string>
using namespace std;
const int MAX = 64;
int n, arr[MAX][MAX];

void f(int n, int x, int y) {
	if (n == 1) {
		cout << arr[y][x];
		return;
	}
	bool isZero = true, isOne = true;
	for (int i = y; i < y + n; i++)
		for (int j = x; j < x + n; j++)
			if (arr[i][j]) isZero = false;
			else isOne = false;
	if (isZero) cout << 0;
	else if (isOne) cout << 1;
	else {
		cout << "(";
		f(n / 2, x, y);
		f(n / 2, x + n / 2, y);
		f(n / 2, x, y + n / 2);
		f(n / 2, x + n / 2, y + n / 2);
		cout << ")";
	}
	return;
}

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	cin >> n;
	bool zero = true, one = true;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < n; j++) arr[i][j] = s[j] - '0';
	}
	f(n, 0, 0);
	cout << '\n';
	return 0;
}
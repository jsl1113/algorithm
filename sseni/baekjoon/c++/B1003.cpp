#include <iostream>
using namespace std;

long long fibo[50] = { 0,1, };
// 0 ���� : 1 0 1 1 2 3 5 ... = �� ���� 1�̰� �������� 0���� �����ϴ� �Ǻ���ġ
// 1 ���� : 0 1 1 2 3 5 ... = 0���� �����ϴ� �Ǻ���ġ

int fibonacci(int n) {
	if (n == 0 || n == 1) return fibo[n];
	if (fibo[n] == 0) return fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
	else return fibo[n];
	
}

int main(void) {
	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		if (n == 0) cout << "1 0" << '\n';
		else {
			fibonacci(n);
			cout << fibo[n - 1] << ' ' << fibo[n]  << '\n';
		}
	}
}
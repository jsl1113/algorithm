#include <iostream>
using namespace std;

long long fibo[50] = { 0,1, };
// 0 개수 : 1 0 1 1 2 3 5 ... = 맨 앞이 1이고 다음부터 0부터 시작하는 피보나치
// 1 개수 : 0 1 1 2 3 5 ... = 0부터 시작하는 피보나치

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
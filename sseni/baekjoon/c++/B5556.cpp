#include <iostream>
using namespace std;
int main (void) {
	int n, k, half;
	cin >> n >> k;
	half = n / 2;
	while (k--) {
		int a, b, color;
		cin >> a >> b;
		if (b <= half) {
			int start = b, end = n + 1 - b;
			if (a >= start && a <= end) color = b % 3;
			else {
				if (a <= half) color = a % 3;
				else color = (n + 1 - a) % 3;
			}
		}
		else {
			int start = n + 1 - b, end = b;
			if (a >= start && a <= end) color = (n + 1 - b) % 3;
			else {
				if (a <= half) color = a % 3;
				else color = (n + 1 - a) % 3;
			}
		}
		if (color == 0) cout << 3;
		else cout << color;
		cout << '\n';
	}
}
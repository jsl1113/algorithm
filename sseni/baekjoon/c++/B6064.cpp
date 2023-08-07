#include <iostream>	
#include <algorithm>	
using namespace std;

int m, n, x, y;
int g(int a, int b) {
	if (a % b == 0) return b;
	else return g(b, a % b);
}

int l(int a, int b) {
	return (a * b) / g(a, b);
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> m >> n >> x >> y;
		int maxY = l(m, n);

		while (1) {
			if (x > maxY || (x - 1) % n + 1 == y) 
				break;
			x += m;
		}
		if (x > maxY) cout << -1 << '\n';
		else cout << x << '\n';
	}
	return 0;
}
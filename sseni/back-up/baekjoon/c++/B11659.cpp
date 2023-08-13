#include <iostream>
using namespace std;

int n, m, ps[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		ps[i + 1] = ps[i] + x;
	}
	for (int i = 0; i < m; i++) {
		int s, f;
		cin >> s >> f;
		cout << ps[f] - ps[s - 1] << '\n';
	}
}
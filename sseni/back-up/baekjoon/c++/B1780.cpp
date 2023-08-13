#include <iostream>
using namespace std;

int n;
int p[2188][2188];
int cnt[3]; // -1,0,1

void f(int x, int y, int size) {
	bool isSame = true;
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (p[x][y] != p[i][j]) {
				isSame = false;
				break;
			}
		}
	}

	if (isSame) {
		cnt[p[x][y] + 1]++;
		return;
	}
	
	for (int i = x; i < x + size; i += size / 3) {
		for (int j = y; j < y + size; j += size / 3) {
			f(i, j, size / 3);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0), cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) 
			cin >> p[i][j];

	f(0, 0, n);

	for (int i = 0; i < 3; i++) 
		cout << cnt[i] << '\n';
}
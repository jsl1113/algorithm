#include <iostream>
using namespace std;

int n; 
int paper[128][128];
int p1, p2;

void f(int x, int y, int size) {
	int check = paper[x][y];
	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (check == 0 && paper[i][j] == 1) check = 2;
			else if (check == 1 && paper[i][j] == 0) check = 2;
			
			if (check == 2) {
				f(x, y, size / 2);
				f(x, y + size / 2, size / 2);
				f(x + size / 2, y, size / 2);
				f(x + size / 2, y + size / 2, size / 2);
				return;
			}
		}
	}
	if (check == 0) p1++;
	else p2++;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) 
			cin >> paper[i][j];

	f(0, 0, n);
	cout << p1 << '\n' << p2 << '\n';
	return 0;
}
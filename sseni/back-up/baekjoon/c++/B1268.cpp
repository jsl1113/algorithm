#include <iostream>
using namespace std;

int grade[1001][6]; // 애들은 1000명까지, 1~5학년
bool check[1001][1001] = { false, };
int cnt[1001];
int n;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < 5; j++) 
			cin >> grade[i][j];

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < n - 1; j++) {
			for (int k = j + 1; k < n; k++) {
				if (grade[j][i] == grade[k][i]) {
					check[j][k] = check[k][j] = true;
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		int c = 0;
		for (int j = 0; j < n; j++) {
			if (check[i][j]) c++;
		}
		cnt[i] = c;
	}

	int max = cnt[0];
	int idx = 0;
	for (int i = 1; i < n; i++) {
		if (max < cnt[i]) {
			max = cnt[i];
			idx = i;
		}
	}
	cout << idx + 1 << '\n';
}
#include <iostream>
#include <queue>
using namespace std;

int m, n, cnt;
int map[1001][1001];
bool isVisit[1001][1001];
int dr[4] = { -1,1,0,0 }; 
int dc[4] = { 0,0,-1,1 }; 
queue<pair<pair<int, int>, int>> Q;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> n >> m;
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				isVisit[i][j] = true;
				Q.push(make_pair(make_pair(i, j), 0));
			}
		}
	}
	while (!Q.empty()) {
		int fr = Q.front().first.first;
		int fc = Q.front().first.second; 
		cnt = Q.front().second;
		Q.pop();
		for (int i = 0; i < 4; i++) {
			int ddr = fr + dr[i];
			int ddc = fc + dc[i];
			if (ddr > 0 && ddc > 0 && ddr <= m && ddc <= n) {
				if (map[ddr][ddc] == 0 && !isVisit[ddr][ddc]) {
					isVisit[ddr][ddc] = true;
					Q.push(make_pair(make_pair(ddr, ddc), cnt + 1));
				}
			}
		}
	}
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (map[i][j] == 0 && !isVisit[i][j]) {
				cnt = -1;
				break;
			}
		}
	}
	cout << cnt;
	return 0;
}
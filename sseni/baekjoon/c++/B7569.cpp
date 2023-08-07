#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int n, m, h;
int map[102][102][102];
int dz[6] = { 0,0,0 ,0,-1,1 };
int dx[6] = { 0,0 ,1,-1,0,0 };
int dy[6] = { -1,1,0,0,0,0 };

int d[102][102][102];
int day = 0;

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(0);
	cin >> m >> n >> h;
	queue<pair<pair<int, int>, int>> Q;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> map[i][j][k];
				if (map[i][j][k] == 1) {
					Q.push({ {i,j},k });
				}
				if (map[i][j][k] == 0)
					d[i][j][k] = -1;
			}
		}
	}

	while (!Q.empty()) {
		pair<pair<int, int>, int> cur = Q.front();
		Q.pop();
		for (int i = 0; i < 6; i++) {
			int nz = cur.first.first + dz[i];
			int nx = cur.first.second + dx[i];
			int ny = cur.second + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
			if (d[nz][nx][ny] >= 0) continue;
			d[nz][nx][ny] = d[cur.first.first][cur.first.second][cur.second] + 1;
			Q.push({ { nz,nx },ny });
		}
	}

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (d[i][j][k] == -1) {
					cout << -1;
					return 0;
				}
				day = max(day, d[i][j][k]);
			}
		}
	}
	cout << day;
}
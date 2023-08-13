#include <iostream>
#include <string>
#include <queue>
using namespace std;

string s[101];
int dis[101][101];
bool isVisit[101][101];
queue<pair<int, int>> Q;
int n, m;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> s[i];

	dis[0][0] = 1;
	Q.push({ 0,0 });
	isVisit[0][0] = true;

	while (!Q.empty()) {
		pair<int, int> tmp = Q.front();
		Q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = tmp.first + dx[i];
			int ny = tmp.second + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (s[nx][ny] == '0' || isVisit[nx][ny]) continue;

			dis[nx][ny] = dis[tmp.first][tmp.second] + 1;
			Q.push({ nx, ny });
			isVisit[nx][ny] = true;
		}
	}

	cout << dis[n - 1][m - 1];
	return 0;
}
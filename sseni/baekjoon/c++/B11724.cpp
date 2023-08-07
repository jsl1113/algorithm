#include <iostream>
#include <queue>	
using namespace std;

const int MAX = 1001;
queue <int> Q;
int map[MAX][MAX] = { 0, };
bool visit[MAX] = { 0, };
int n, m, cnt = 0;
int s, f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> s >> f;
		map[s][f] = 1;
		map[f][s] = 1;
	}

	for (int i = 1; i <= n; i++) {
		if (visit[i] == 0) {
			Q.push(i);
			visit[i] = true;

			// BFS
			while (!Q.empty()) {
				int i = Q.front();
				Q.pop();
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1 && visit[j] == 0) {
						Q.push(j);
						visit[j] = true;
					}
				}
			}

			cnt++;
		}
	}
	cout << cnt << '\n';
}
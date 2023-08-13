#include <iostream>
#include <queue>
using namespace std;

int n, m, v;
int map[1001][1001];
bool visit[1001];
queue <int> Q;

void DFS(int v) {
	visit[v] = true;
	cout << v << " ";
	for (int i = 1; i <= n; i++) {
		if (map[v][i] == 1 && visit[i] == 0) {
			DFS(i);
		}
	}
}
void BFS(int v) {
	Q.push(v);
	visit[v] = true;
	cout << v << " ";

	while (!Q.empty()) {
		v = Q.front();
		Q.pop();
		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && visit[i] == 0) {
				Q.push(i);
				visit[i] = true;
				cout << i << " ";
			}
		}
	}
}
int main() {
	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
		map[y][x] = 1;
	}

	for (int i = 1; i <= n; i++) {
		visit[i] = 0;
	}

	DFS(v);
	cout << '\n';

	for (int i = 1; i <= n; i++) {
		visit[i] = 0;
	}
	BFS(v);
	return 0;
}
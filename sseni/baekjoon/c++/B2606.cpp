#include <iostream>
#include <queue>
using namespace std;
// BFS - Q �̿�
// DFS - ��� �̿�
int virus[101][101];
int visit[101];
int c, n, cnt;

void DFS(int node) {
	visit[node] = 1;
	for (int i = 1; i <= c; i++) {
		cout << "node = " << node << ", i = " << i << '\n';
		if (!visit[i] && virus[node][i] == 1) {
			cnt++;
			DFS(i);
		}
	}
}

int main(void) {
	cin >> c;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int s, f;
		cin >> s >> f;
		virus[s][f] = 1;
		virus[f][s] = 1;
	}

	// BFS
	//visit[1] = 1;
	//queue <int> Q;
	//Q.push(1);
	/*while (!Q.empty()) {
		int node = Q.front();
		Q.pop();
		for (int i = 1; i <= c; i++) {
			if (!visit[i] && virus[node][i] == 1) { //������ �湮�� �� ���� ���� ����Ǿ� ������
				Q.push(i);
				visit[i] = 1;
				cnt++;
			}
		}
	}*/

	DFS(1);
	cout << cnt << '\n';
}
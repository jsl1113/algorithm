#include <iostream>
#include <cstring>
#include <cmath>
#include <climits>
using namespace std;
int n, num[21][21];
bool visit[21];
int ans = INT_MAX;

void DFS(int x, int idx) { 
	if (x == n / 2) { // 반반으로 팀이 완성됐을 때
		int s, l;
		s = 0; l = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (visit[i] && visit[j]) s += num[i][j];
				if (!visit[i] && !visit[j]) l += num[i][j];
			}
		}
		ans = min(ans, abs(s - l));
	}

	for (int i = idx; i < n; i++) { // n의 경우는 모두 중복
		visit[i] = true;
		DFS(x + 1, i + 1);
		visit[i] = false;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= n; j++) 
			cin >> num[i][j];
	
	DFS(0, 1);
	cout << ans;
}



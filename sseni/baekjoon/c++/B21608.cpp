#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> info[401];
int arr[21][21]; // 1 ~ n 
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int score[5] = { 0, 1, 10, 100, 1000 };

int main() {
	cin >> n;
	int num = n * n; // ex. 3 * 3
	while (num--) {
		int st, a, b, c, d;
		cin >> st >> a >> b >> c >> d;
		info[st].push_back(a);
		info[st].push_back(b);
		info[st].push_back(c);
		info[st].push_back(d);

		int x, y; // �ڸ� ��ġ
		bool isDone = false;  // �ڸ��� ã�Ҵ��� Ȯ��

		// 1  
		// �� �ڸ��� Ȯ���ϸ鼭 ���ڸ� �ֺ��� �����ϴ� �л��� �ɾ��ִ��� Ž��
		vector<pair<int, int>> v1[5];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 0) {
					int cnt = 0;
					for (int pos = 0; pos < 4; pos++) {
						int nx = i + dx[pos];
						int ny = j + dy[pos];

						if (nx <1 || nx > n || ny < 1 || ny > n) continue;
						if (arr[nx][ny] == a || arr[nx][ny] == b || arr[nx][ny] == c || arr[nx][ny] == d)
							cnt++;
					}

					v1[cnt].push_back({ i, j });
				}
			}
		}

		int after_1;
		for (int i = 4; i >= 0; i--) {
			if (v1[i].empty()) continue;
			if (v1[i].size() == 1) { // �ڸ��� 1�ڸ��� �׳� �ٷ� ����
				x = v1[i][0].first;
				y = v1[i][0].second;
				isDone = true;
				break;
			}
			else {
				after_1 = i;
				break;
			}
		}

		if (isDone) {
			arr[x][y] = st;
			continue;
		}

		// 2
		vector<pair<int, int>> v2[5];
		for (pair<int, int> x : v1[after_1]) {
			int cnt = 0;
			for (int pos = 0; pos < 4; pos++) {
				int nx = x.first + dx[pos];
				int ny = x.second + dy[pos];

				if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
				if (arr[nx][ny] == 0) cnt++;
			}

			v2[cnt].push_back(x);
		}

		int after_2;
		for (int i = 4; i >= 0; i--) {
			if (v2[i].empty()) continue;
			if (v2[i].size() == 1) {
				x = v2[i][0].first;
				y = v2[i][0].second;
				isDone = true;
				break;
			}
			else {
				after_2 = i;
				break;
			}
		}

		if (isDone) {
			arr[x][y] = st;
			continue;
		}

		// 3 
		sort(v2[after_2].begin(), v2[after_2].end());
		x = v2[after_2][0].first;
		y = v2[after_2][0].second;
		isDone = true;

		if (isDone) {
			arr[x][y] = st;
			continue;
		}
	}

	long long ans = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int number = arr[i][j];
			int cnt = 0;
			for (int pos = 0; pos < 4; pos++) {
				int nx = i + dx[pos];
				int ny = j + dy[pos];

				if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
				if (arr[nx][ny] == info[number][0] || 
					arr[nx][ny] == info[number][1] || 
					arr[nx][ny] == info[number][2] || 
					arr[nx][ny] == info[number][3]) {
					cnt++;
				}
			}
			ans += score[cnt];
		}
	}
		cout << ans;
		return 0;
}


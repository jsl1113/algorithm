#include <iostream> 
#include <cstdio> 
#include <queue> 
#include <vector> 
#include <algorithm>
using namespace std;
int arr[30][30]; 
bool isVisit[30][30]; 
int dx[4] = { 0,0,1,-1 };
int dy[4] = { -1,1,0,0 }; 
int n, cnt = 0; 
vector<int> ans; 
queue<pair<int, int>> q;

int main() { 
	cin >> n;
	for (int i = 0; i < n; i++) { 
		for (int j = 0; j < n; j++) {
			scanf_s("%1d", &arr[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1 && isVisit[i][j] != true) {
				cnt = 0; 
				q.push({ i, j });
				cnt++;
				isVisit[i][j] = true;
				while (!q.empty()) {
					int sx = q.front().first;
					int sy = q.front().second;
					q.pop();
					for (int i = 0; i < 4; i++) {
						int nx = sx + dx[i];
						int ny = sy + dy[i];
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1 && isVisit[nx][ny] != true) {
							q.push({ nx, ny });
							isVisit[nx][ny] = true;
							cnt++;
						}
					}
				}
				ans.push_back(cnt); 
			}
		}
	}
	cout << ans.size() << '\n'; 
	sort(ans.begin(), ans.end()); 
	for (int i = 0; i < ans.size(); i++) { 
		cout << ans[i] << '\n'; 
	}
	return 0; 
}

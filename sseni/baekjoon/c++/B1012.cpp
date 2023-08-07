#include <iostream>
#include <queue>
using namespace std;

//가로길이 m = 열, 세로길이 n = 행
//BFS(Breadth-first search) : 너비우선탐색 - 인접한 노드 먼저(얕은 노드 -> 깊은 노드)
//DFS(Depth-First Search) : 깊이우선탐색 - 끝까지 찍고 더이상 없으면 다음 노드
//큐 - FIFO 이용

//1. 타겟 발견
//2. 맵 벗어났나
//3. 이미 방문한 타겟인가

int t;
int m, n, k;
int map[50][50];
bool visit[50][50];
int result;
queue <pair<int, int>> Q;
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };

int main() {
    cin >> t;

    while (t--) {
        cin >> m >> n >> k;
        int r, c;

        while (k--) {
            cin >> c >> r;
            map[r][c] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    //BFS 탐색 시작
                    Q.push({ i, j }); //Q.push(make_pair(i, j))
                    visit[i][j] = true; //방문 완료

                    while (!Q.empty()) { // 큐가 비어있지 않으면
                       // 처음 좌표 기준
                        int fr = Q.front().first;        // 0
                        int fc = Q.front().second; // 0
                        Q.pop();

                        for (int i = 0; i < 4; i++) {
                            //움직인 좌표 
                            int ddr = fr + dr[i];
                            int ddc = fc + dc[i];

                            if (ddr >= 0 && ddc >= 0 && ddr < n && ddc < m) {
                                if (map[ddr][ddc] == 1 && !visit[ddr][ddc]) {
                                Q.push({ ddr, ddc });
                                visit[ddr][ddc] = true;
                                }
                            }
                        }
                    }
                    result++;
                }
            }
        }
        cout << result << '\n';

        // 초기화
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                map[i][j] = 0;
            }
        }
    }
}
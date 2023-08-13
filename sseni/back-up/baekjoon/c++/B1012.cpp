#include <iostream>
#include <queue>
using namespace std;

//���α��� m = ��, ���α��� n = ��
//BFS(Breadth-first search) : �ʺ�켱Ž�� - ������ ��� ����(���� ��� -> ���� ���)
//DFS(Depth-First Search) : ���̿켱Ž�� - ������ ��� ���̻� ������ ���� ���
//ť - FIFO �̿�

//1. Ÿ�� �߰�
//2. �� �����
//3. �̹� �湮�� Ÿ���ΰ�

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
                    //BFS Ž�� ����
                    Q.push({ i, j }); //Q.push(make_pair(i, j))
                    visit[i][j] = true; //�湮 �Ϸ�

                    while (!Q.empty()) { // ť�� ������� ������
                       // ó�� ��ǥ ����
                        int fr = Q.front().first;        // 0
                        int fc = Q.front().second; // 0
                        Q.pop();

                        for (int i = 0; i < 4; i++) {
                            //������ ��ǥ 
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

        // �ʱ�ȭ
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                map[i][j] = 0;
            }
        }
    }
}
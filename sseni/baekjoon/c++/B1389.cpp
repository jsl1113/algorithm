#include<iostream>
#include<queue>
#include<string.h>
using namespace std;
int map[101][101];
bool chk[101];
int main() {
	int n, m;

	cin >> n >> m;
	int input1;
	int input2;
	for (int i = 0; i < m; i++)
	{
		cin >> input1 >> input2;

		map[input1][input2] = 1;
		map[input2][input1] = 1;
	}
	queue<pair<int, int>> q;//현재번호와 현재층

	int sum = 0;
	int result = 999999;
	int people = 0;
	for (int i = 1; i <= n; i++)
	{
		q.push({ i,0 });
		chk[i] = true;
		sum = 0;
		while (!q.empty())
		{

			int curNum = q.front().first;
			int nextLayer = q.front().second + 1;
			q.pop();

			for (int j = 1; j <= n; j++)
			{
				if (map[curNum][j] == 1 && !chk[j])
				{
					chk[j] = true;
					q.push({ j, nextLayer });
					sum += nextLayer;
				}
			}
		}

		if (sum < result)
		{
			result = sum;
			people = i;
		}
		memset(chk, false, sizeof(chk));
	}

	cout << people << '\n';
	return 0;
}
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;

const int MAX = 1000001;
int n;
bool visit[MAX];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int test;
	cin >> test;

	for (int t = 0; t < test; t++) {
		cin >> n;
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minpq;
		priority_queue<pair<int, int>, vector<pair<int, int>>, less<pair<int, int>>> maxpq;

		for (int i = 0; i < n; i++) {
			char c;
			int num;
			cin >> c >> num;
			if (c == 'I') {
				maxpq.push({ num, i });
				minpq.push({ num, i });
				visit[i] = true;
			}
			else {
				if (num == 1) {
					while (!maxpq.empty() && !visit[maxpq.top().second]) maxpq.pop();
					if (!maxpq.empty()) {
						visit[maxpq.top().second] = false;
						maxpq.pop();
					}
				}
				else {
					while (!minpq.empty() && !visit[minpq.top().second]) minpq.pop();
					if (!minpq.empty()) {
						visit[minpq.top().second] = false;
						minpq.pop();
					}
				}
			}

		}
		while (!maxpq.empty() && !visit[maxpq.top().second]) maxpq.pop();
		while (!minpq.empty() && !visit[minpq.top().second]) minpq.pop();
		if (minpq.empty() && maxpq.empty()) cout << "EMPTY\n";
		else cout << maxpq.top().first << " " << minpq.top().first << "\n";
	}
	return 0;
}
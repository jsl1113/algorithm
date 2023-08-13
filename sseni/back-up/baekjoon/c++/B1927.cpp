#include <iostream>
#include <queue>
using namespace std;

int n, x;
priority_queue<int, vector<int>, greater<int>> pq; // 우선순위 큐 

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n--) {
		cin >> x;
		if (x == 0) { // pq.size() 로도 가능
			if (pq.empty()) cout << 0 << '\n';
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		}
		else {
			pq.push(x);
		}
	}
}
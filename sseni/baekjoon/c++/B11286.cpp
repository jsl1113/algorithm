#include <iostream>	
#include <algorithm>
#include <queue>
using namespace std;
int n, x;
priority_queue<int, vector<int>, greater<int>> Q1; // 양수
priority_queue<int> Q2; // 음수

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> x;
		if (x == 0) {
			if (Q1.empty() && Q2.empty()) cout << "0\n";
			else {
				if (Q1.empty()) {
					cout << Q2.top() << '\n';
					Q2.pop();
				}
				else if (Q2.empty()) {
					cout << Q1.top() << '\n';
					Q1.pop();
				}
				else {
					if (Q1.top() < -Q2.top()) {
						cout << Q1.top() << '\n';
						Q1.pop();
					}
					else {
						cout << Q2.top() << '\n';
						Q2.pop();
					}
				}
			}
		}
		else if (x > 0) Q1.push(x);
		else Q2.push(x);
	}
}
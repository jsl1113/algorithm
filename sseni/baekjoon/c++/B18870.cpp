#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, x;
vector<pair<int, int>> v1;
vector<int> v2(1000001);
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x;
		v1.push_back({ x, i });
	}

	sort(v1.begin(), v1.end());
	int tmp = v1[0].first;
	int cnt = 0;
	v2[v1[0].second] = 0;
	
	for (int i = 1; i < n; i++) {
		if (tmp == v1[i].first) {
			v2[v1[i].second] = cnt;
		}
		else {
			v2[v1[i].second] = ++cnt;
			tmp = v1[i].first;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << v2[i] << " ";
	}
}
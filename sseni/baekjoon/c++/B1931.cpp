#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, s, f;
vector<pair<int, int>> v;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s >> f;
		v.push_back(make_pair(f, s)); // (끝, 시작)
	}

	sort(v.begin(), v.end());
	int t = v[0].first; // 끝나는 시간
	int cnt = 1; 
	for (int i = 1; i < n; i++) {
		if (t <= v[i].second) { 
			cnt++;
			t = v[i].first;
		}
	}
	cout << cnt;
}
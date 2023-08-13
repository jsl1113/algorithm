#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector <string> v;

bool binary_search(int low, int high, string name) {
	if (low > high) return false;
	else {
		int mid = (low + high) / 2;
		if (name == v[mid]) return true;
		else if (v[mid] > name) return binary_search(low, mid - 1, name);
		else return binary_search(mid + 1, high, name);
	}
}

int main(void) {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string name;
		cin >> name;
		v.push_back(name);
	}
	sort(v.begin(), v.end());
	vector <string> result;
	for (int i = 0; i < m; i++) {
		// 듣도 못하고 보도 못한 사람
		string name;
		cin >> name;
		if (binary_search(0, v.size() - 1, name)) {
			result.push_back(name);
		}
	}
	sort(result.begin(), result.end());
	cout << result.size() << '\n';
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << '\n';
	}
	return 0;
}
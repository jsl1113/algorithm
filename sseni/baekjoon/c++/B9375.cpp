#include <iostream>
#include <vector>
#include<unordered_map>
#include <string>
using namespace std;
int t;

int main() {
	cin >> t;
	while (t--) {
		unordered_map<string, int> m;
		int n; 	cin >> n;
		while (n--) {
			string clothes, kind;
			cin >> clothes >> kind;
			if (m.find(kind) == m.end()) m.insert({ kind, 1 });
			else 	m[kind]++;
		}
		int cnt = 1;
		for (auto i : m) cnt *= (i.second + 1);
		cout << cnt - 1 << '\n';
	}
}
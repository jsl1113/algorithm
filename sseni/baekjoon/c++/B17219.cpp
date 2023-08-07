#include <iostream>
#include <map>
#include <string>
using namespace std;

map <string, string> M;
int n, m;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		string site, pw;
		cin >> site >> pw;
		M[site] = pw;
	}
	for (int i = 0; i < m; i++) {
		string s;
		cin >> s;
		cout << M[s] << '\n';
	}
	return 0;
}
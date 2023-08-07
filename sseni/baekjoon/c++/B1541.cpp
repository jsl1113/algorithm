#include <iostream>
#include <string>
using namespace std;

int n = 0;
int m = 0;
string nums = "";
string s;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0), cout.tie(0);

	cin >> s;
	for (int i = 0; i <= s.size(); ++i) {
		if (s[i] == '+' || s[i] == '-' || s[i] == '\0') {
			if (m) n -= stoi(nums);
			else n += stoi(nums);

			if (s[i] == '-') m = 1;
			nums = "";
			continue;
		}
		nums += s[i];
	}
	cout << n << '\n';	
	return 0;
}
#include <iostream>
using namespace std;

int n;
int cnt;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n >= 5) {
		cnt += n / 5;
		n /= 5;
	}
	cout << cnt;
}
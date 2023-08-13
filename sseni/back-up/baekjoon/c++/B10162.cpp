#include <iostream>
using namespace std;

int n;
int a, b, c;
int main() {
	cin >> n;

	while (n > 0) {
		if (n >= 300) {
			n -= 300;
			a++;
		}
		else if (n >= 60) {
			n -= 60;
			b++;
		}
		else if (n >= 10) {
			n -= 10;
			c++;
		}
		else break;
	}
	if (n == 0) cout << a << " " << b << " " << c;
	else cout << -1;
}
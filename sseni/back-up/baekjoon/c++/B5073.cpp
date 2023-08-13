#include <iostream>
#include <cmath>
using namespace std;

int a, b, c;
bool E() {
	return (a == b && b == c) ? true : false;
}

bool I() {
	return (a == b || b == c || c == a) ? true : false;
}

int main() {
	ios::sync_with_stdio();
	cin.tie();

	while (true) {
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0) break;
		else {
			int tmp = max(a, max(b, c));
			if ((2 * tmp) >= (a + b + c)) 
				cout << "Invalid" << "\n";
			else {
				if (E()) {
					cout << "Equilateral" << '\n';
				}
				else if (I()) {
					cout << "Isosceles" << '\n';
				}
				else {
					cout << "Scalene" << "\n";
				}
			}
		}
	}
}
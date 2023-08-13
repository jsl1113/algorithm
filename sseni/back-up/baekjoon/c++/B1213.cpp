#include <iostream>
using namespace std;

string s;
string x, y;  // Ȧ, ¦
int cnt[100];

int main() {
	cin >> s;
	for (char c : s) {
		cnt[c]++;
	}

	for (char i = 'A'; i <= 'Z'; i++) {
		if (cnt[i] % 2 == 1) 
			x += i;

		for (int j = 0; j < cnt[i] / 2; j++) 
			y += i;
	}

	string y_ = y;   
	reverse(y.begin(), y.end());

	if (x.size() <= 1) 
		cout << y_ << x << y;
	else 
		cout << "I'm Sorry Hansoo";
	
}
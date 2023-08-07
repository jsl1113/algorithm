#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int n, w;

bool c(int a, int b) {
	return a > b;
}
int main() {
	int tmp1, tmp2;
	int ans = 0;
	int cnt3 = 0, cnt5 = 0;
	cin >> n >> w;
	int* can3 = new int[n];
	int* can5 = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> tmp1 >> tmp2;
		if (tmp1 == 3) {
			can3[++cnt3 - 1] = tmp2;
		}
		else {
			can5[++cnt5 - 1] = tmp2;
		}
	}

	sort(can3, can3 + cnt3, c);
	sort(can5, can5 + cnt5, c);
	int* c3 = new int[cnt3] {0};
	int* c5 = new int[cnt5] {0};
	for (int i = 1; i < cnt3; i++) {
		c3[i] = c3[i - 1] + can3[i - 1];
	}
	for (int i = 1; i < cnt5; i++) {
		c5[i] = c5[i - 1] + can5[i - 1];
	}

	int n3 = min(int(w / 3), cnt3);
	while (n3 >= 0) {
		int n5 = min(int((w - n3 * 3) / 5), cnt5);
		ans = max(ans, c3[n3] + c5[n5]);
		n3--;
	}

	cout << ans << endl;
}
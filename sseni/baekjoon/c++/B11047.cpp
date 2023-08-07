#include <iostream>
using namespace std;

int n, k;
int arr[11], cnt = 0;
int main() {
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = n - 1; k > 0;) {
		if (arr[i] > k) i--;
		if (arr[i] <= k) {
			k -= arr[i];
			cnt++;
		}
	}
	cout << cnt;
}
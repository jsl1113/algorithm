#include <iostream>	
#include <algorithm>
using namespace std;

int n, time;
int arr[1001]; //��� ��ȣ, �ɸ��� �ð�
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		arr[i] = tmp;
	}

	sort(arr, arr+n);
	for (int i = 0; i < n; i++) {
		time += arr[i] * (n-i);
	}
	cout << time << '\n';
}
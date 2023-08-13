#include <iostream>
using namespace std;

int n;
long long int arr[100001];
long long int x, y;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) 
		cin >> arr[i];

	int start = 0, end = n-1;
	x = arr[start], y = arr[end];
	int mix = abs(x + y);

	while (start < end) {
		if (mix > abs(arr[start] + arr[end])) {
			mix = abs(arr[start] + arr[end]);
			x = arr[start];
			y = arr[end];
		}
			
		if (abs(arr[start + 1] + arr[end]) > abs(arr[start] + arr[end - 1]))
			end--;
		else start++;
	}

	cout << x << " " << y;
}
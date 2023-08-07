#include <iostream>
#include <queue>
using namespace std;
// 걷기 : 1초 후에 x-1 or x+1 이동
// 순간이동 : 1초 후에 2*x 이동
const int Max = 100001;
int n, k, fl, fs;
bool isVisit[Max];
queue <pair<int, int>> Q;

int main(void) {
	cin >> n >> k;
	Q.push(make_pair(n, 0));
	isVisit[n] = true;

	while (!Q.empty()) {
		fl = Q.front().first;
		fs = Q.front().second;
		Q.pop();

		if (fl == k) break;

		if (fl + 1 < Max && !isVisit[fl + 1]) { // +1
			Q.push(make_pair(fl + 1, fs + 1));
			isVisit[fl + 1] = true;
		}
		if (fl - 1 >= 0 && !isVisit[fl - 1]) { // -1
			Q.push(make_pair(fl - 1, fs + 1));
			isVisit[fl - 1] = true;
		}
		if (2 * fl < Max && !isVisit[fl * 2]) { // *2
			Q.push(make_pair(2 * fl, fs + 1));
			isVisit[2 * fl] = true;
		}
	}
	cout << fs << '\n';
}
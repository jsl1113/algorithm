#include <iostream>
#include <string>
#include <cstdio>
#include <map>
#include <cstdlib>
using namespace std;

int n, m;
int result;
char str[21];
map <string, int> mp1; // 문자열 기준 정렬
string mp2[100001]; // 번호 기준 정렬

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 포켓몬 입력
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp;
		mp1.insert(pair<string, int>(tmp, i));
		mp2[i] = tmp;
	}
	// 문자열 또는 번호 검색
	for (int i = 0; i < m; i++) {
		cin >> str;
		if (isdigit(str[0]))  // 숫자를 판단하는 함수 (true, false)
			cout << mp2[atoi(str) - 1] << '\n';
		else cout << mp1[string(str)] + 1 << '\n';
	}
}
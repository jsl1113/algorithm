#include <iostream>
#include <string>
#include <cstdio>
#include <map>
#include <cstdlib>
using namespace std;

int n, m;
int result;
char str[21];
map <string, int> mp1; // ���ڿ� ���� ����
string mp2[100001]; // ��ȣ ���� ����

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// ���ϸ� �Է�
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp;
		mp1.insert(pair<string, int>(tmp, i));
		mp2[i] = tmp;
	}
	// ���ڿ� �Ǵ� ��ȣ �˻�
	for (int i = 0; i < m; i++) {
		cin >> str;
		if (isdigit(str[0]))  // ���ڸ� �Ǵ��ϴ� �Լ� (true, false)
			cout << mp2[atoi(str) - 1] << '\n';
		else cout << mp1[string(str)] + 1 << '\n';
	}
}
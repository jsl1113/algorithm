/*#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m;
int x;
int cnt[101];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;
	vector<pair<int, int>> v(n, { 0, 0 });  // { �ð�, ���� }
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> x;
		cnt[x]++;
		bool b = true;
		
		for (int j = 0; j < n; j++) {
			if (v[j].second == 0) {  // ���ڰ� ����ִ� ���
				v[j].first = i; // �Է¹��� ���� index ������ ���� ���� ���� �ɷ��ִ� ���ڶ�� �Ǵ� ����
				v[j].second = x;
				b = false;
				break;
			}
			else if (v[j].second == x) {  // �̹� ���ڿ� �ִ� ���
				b = false;
				break;
			}
		}

		if (b) {  // ������ ������ �� ��
			int old = 0;
			for (int j = 1; j < n; j++) {
				if (cnt[v[j].second] == cnt[v[old].second]) {
					if (v[j].first < v[old].first) old = j;
				}
				else if (cnt[v[j].second] < cnt[v[old].second]) old = j;
			}

			cnt[v[old].second] = 0;
			v[old].first = i;
			v[old].second = x;
		}

	}

	vector<int> picture;
	for (int i = 0; i < n; i++)
		picture.push_back(v[i].second);
	sort(picture.begin(), picture.end());

	for (int i = 0; i < n; i++) cout << picture[i] << " ";
	return 0;
}*/

#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
map <int, pair<int, int>> m; //��õ���� �л�, (��õ ��, ���� �ñ�)

bool cmp1(const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
    if (a.second.first == b.second.first) return a.first < b.first;
    return a.second.first < b.second.first;
}

bool cmp2(const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
    if (a.second.second == b.second.second) return a.first < b.first;
    return a.second.second < b.second.second;
}

void insert(int student, int n) {
    if (m.find(student) != m.end()) { //�ش� �л��� �̹� ����
        m[student].first++;
    }
    else { //���ο� �л� ����
        m[student].first = 1;
        m[student].second = n;
    }
}

void erase(int student, int n) {
    if (m.find(student) != m.end()) {
        m[student].first++;
        return;
    }

    vector<pair<int, pair<int, int>>> vec1(m.begin(), m.end());
    sort(vec1.begin(), vec1.end(), cmp1); //��õ ������ ����

    int recommend = vec1[0].second.first, cnt = 0;

    for (auto it : vec1) {
        if (it.second.first == recommend) cnt++;
    }

    if (cnt == 1) { //��õ Ƚ�� ���� ���� �л� ����
        m.erase(vec1[0].first);
    }
    else if (cnt > 1) { //��õ �� ���� ���� �л��� �� �� �̻�
        map<int, pair<int, int>> same_r;

        for (auto it : vec1) {
            if (recommend == it.second.first) {
                same_r[it.first].first = it.second.first; //��õ ��
                same_r[it.first].second = it.second.second; //���� �ñ�
            }
        }

        vector<pair<int, pair<int, int>>> vec2(same_r.begin(), same_r.end());
        sort(vec2.begin(), vec2.end(), cmp2); //���� �ñ� ������ ����

        m.erase(vec2[0].first);
    }

    insert(student, n);
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int n, r, student;
    cin >> n >> r;

    for (int i = 0; i < r; i++) {
        cin >> student;

        if (m.size() < n) { //����
            insert(student, i);
        }
        else if (m.size() == n) { //����
            erase(student, i);
        }
    }

    for (auto it = m.begin(); it != m.end(); it++) {
        cout << it->first << " ";
    }

    return 0;
}
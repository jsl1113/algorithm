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
	vector<pair<int, int>> v(n, { 0, 0 });  // { 시간, 사진 }
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> x;
		cnt[x]++;
		bool b = true;
		
		for (int j = 0; j < n; j++) {
			if (v[j].second == 0) {  // 액자가 비어있는 경우
				v[j].first = i; // 입력받은 순서 index 넣으면 작은 수가 오래 걸려있던 액자라고 판단 가능
				v[j].second = x;
				b = false;
				break;
			}
			else if (v[j].second == x) {  // 이미 액자에 있는 경우
				b = false;
				break;
			}
		}

		if (b) {  // 사진을 내려야 할 때
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
map <int, pair<int, int>> m; //추천받은 학생, (추천 수, 들어온 시기)

bool cmp1(const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
    if (a.second.first == b.second.first) return a.first < b.first;
    return a.second.first < b.second.first;
}

bool cmp2(const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
    if (a.second.second == b.second.second) return a.first < b.first;
    return a.second.second < b.second.second;
}

void insert(int student, int n) {
    if (m.find(student) != m.end()) { //해당 학생이 이미 존재
        m[student].first++;
    }
    else { //새로운 학생 삽입
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
    sort(vec1.begin(), vec1.end(), cmp1); //추천 순으로 정렬

    int recommend = vec1[0].second.first, cnt = 0;

    for (auto it : vec1) {
        if (it.second.first == recommend) cnt++;
    }

    if (cnt == 1) { //추천 횟수 제일 적은 학생 삭제
        m.erase(vec1[0].first);
    }
    else if (cnt > 1) { //추천 수 가장 적은 학생이 두 명 이상
        map<int, pair<int, int>> same_r;

        for (auto it : vec1) {
            if (recommend == it.second.first) {
                same_r[it.first].first = it.second.first; //추천 수
                same_r[it.first].second = it.second.second; //들어온 시기
            }
        }

        vector<pair<int, pair<int, int>>> vec2(same_r.begin(), same_r.end());
        sort(vec2.begin(), vec2.end(), cmp2); //들어온 시기 순으로 정렬

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

        if (m.size() < n) { //삽입
            insert(student, i);
        }
        else if (m.size() == n) { //삭제
            erase(student, i);
        }
    }

    for (auto it = m.begin(); it != m.end(); it++) {
        cout << it->first << " ";
    }

    return 0;
}
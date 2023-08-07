#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b);
bool cmp_value(pair<string, int> a, pair<string, int> b);

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    unordered_map<string, vector<pair<int, int>>> m;
    unordered_map<string, int> music;

    vector<pair<string, int>> v;

    for (int i = 0; i < genres.size(); i++) {
        m[genres[i]].push_back(make_pair(plays[i], i));
        music[genres[i]] += plays[i];
    }

    for (auto& k : m)
        sort(k.second.begin(), k.second.end(), cmp);

    v.assign(music.begin(), music.end());
    sort(v.begin(), v.end(), cmp_value);


    for (int i = 0; i < v.size(); i++) {
        string name = v[i].first;

        for (int j = 0; j < m[name].size(); j++) {
            if (j >= 2) break;
            answer.push_back(m[name][j].second);
        }
    }

    return answer;
}

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.first > b.first;
}

bool cmp_value(pair<string, int> a, pair<string, int> b) {
    return a.second > b.second;
}

int main() {
    vector<string> genres = { "classic", "pop", "classic", "classic", "pop" };
    vector<int> plays = { 500, 600, 150, 800,  2500 };

    solution(genres, plays);

}
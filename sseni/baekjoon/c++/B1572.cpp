#include <iostream>
#include <cstdio>
using namespace std;

typedef long long ll;
#define MAX_CNT (250000)
#define MAX_TREE	(65536)						//Max Tree Index

int N, K;
int gArrSrc[MAX_CNT + 1];
int gArrBIT[MAX_TREE + 1];
ll midVal;

inline void updateBIT(int idx, const int& diffValue) {
	idx++;
	while (idx <= MAX_TREE) {
		gArrBIT[idx] += diffValue;
		idx += (idx & -idx);			//get lowest bit
	}
}

inline ll getSum(int idx) {
	idx++;
	ll ans = 0;
	while (idx > 0) {
		ans += gArrBIT[idx];
		idx -= (idx & -idx);
	}
	return ans;
}

//binary search�� �߾Ӱ��� ã�´�
inline int GetMidVal() {
	int C = (K + 1) / 2;
	int s = 0;
	int e = MAX_TREE;
	int m;
	while (s < e) {
		m = (s + e) / 2;
		if (getSum(m) < C) s = m + 1;
		else e = m;
	}
	return s;
}

int main() {
	scanf_s("%d %d", &N, &K);
	for (int i = 1; i <= N; i++) {
		scanf_s("%d", &gArrSrc[i]);
	}
	for (int i = 1; i <= K; i++) {
		updateBIT(gArrSrc[i], 1);			//�󵵼� ���̺� ������Ʈ		
	}
	midVal = GetMidVal();
	for (int i = 1; i <= N - K; i++) {
		updateBIT(gArrSrc[i], -1);		//��ó�� �����ʹ� �����ϰ�
		updateBIT(gArrSrc[i + K], 1);		//�ǳ��� �����͸� �߰��Ѵ�
		midVal += GetMidVal();
	}
	printf("%lld\n", midVal);
	return 0;
}
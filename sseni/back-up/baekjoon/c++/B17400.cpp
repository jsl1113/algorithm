#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

typedef long long ll;

struct Seg {
	ll tree[1 << 20];
	int bias = 1 << 19;
	void update(int x, ll v) {
		x |= bias; tree[x] += v;
		while (x >>= 1) {
			tree[x] = tree[x << 1] + tree[x << 1 | 1];
		}
	}
	ll query(int l, int r) {
		l |= bias, r |= bias;
		ll ret = 0;
		while (l <= r) {
			if (l & 1) ret += tree[l++];
			if (~r & 1) ret += tree[r--];
			l >>= 1, r >>= 1;
		}
		return ret;
	}
}odd, even;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int n, q; cin >> n >> q;
	for (int i = 1; i <= n; i++) {
		ll t; cin >> t;
		if (i & 1) odd.update(i / 2 + 1, t);
		else even.update(i / 2, t);
	}
	while (q--) {
		ll op, a, b; cin >> op >> a >> b;
		if (op == 1) {
			int oddL = a / 2 + 1, oddR = b / 2;
			if (b & 1) oddR++;
			int evenL = a / 2, evenR = b / 2;
			if (a & 1) evenL++;
			ll x = odd.query(oddL, oddR);
			ll y = even.query(evenL, evenR);
			cout << abs(x - y) << "\n";
		}
		else {
			if (a & 1) odd.update(a / 2 + 1, b);
			else even.update(a / 2, b);
		}
	}
}
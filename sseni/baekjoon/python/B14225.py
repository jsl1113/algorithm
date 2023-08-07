import sys
from itertools import chain, combinations

def powerset(iterable):
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s) + 1))
n = int(sys.stdin.readline())
s = [int(i) for i in sys.stdin.readline().split()]

l = []
for c in powerset(s):
    l.append(sum(c))

l = list(set(l))
l.sort()
ret = 0
for c in l:
    if ret != c:
        print(ret)
        sys.exit()
    else:
        ret += 1
print(l[-1] + 1)
import sys

n = sys.stdin.readline()
L = list(map(int, input().split()))

LL = []
tmp = 0

for i in range(len(L)):
    tmp = 0
    for j in range(len(L)):
        tmp += abs(L[i] - L[j])
    LL.append(tmp)

min = LL[0]
m_index = 0

for i in range(1, len(LL)):
    if min >= LL[i]:
        min = LL[i]
        if L[m_index] > L[i]:
            m_index = i

print(L[m_index])
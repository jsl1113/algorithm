import sys
n = int(sys.stdin.readline())
m = []

for i in range(n):
    m.append(list(sys.stdin.readline().split()))

m.sort(key=lambda x: int(x[0]))

for i in range(n):
    print(m[i][0], m[i][1])

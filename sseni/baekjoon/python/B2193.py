import sys

n = int(sys.stdin.readline())
d = [0, 1, 1]
for i in range(3, n+1):
    d.append(d[i-1]+d[i-2])
print(d[-1])

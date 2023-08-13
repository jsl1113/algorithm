import sys

N, M, B = map(int, sys.stdin.readline().split())
li = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
time, height = 9223372036854775807, 0

for h in range(257):
    bot = top = 0
    for i in range(N):
        for j in range(M):
            if li[i][j] < h:
                bot += h-li[i][j]
            else:
                top += li[i][j]-h

    if bot > top + B:
        continue

    t = bot + top * 2
    if t <= time:
        time = t
        height = h

print(time, height)
N, M = map(int, input().split())
tree = list(map(int, input().split()))
left, right = 0, max(tree)
result = []

while not left > right:
    lg = 0
    mid = (left + right) // 2
    lg = sum(i - mid if i > mid else 0 for i in tree)
    if lg == M:
        result.append(mid)
        break
    elif lg > M:
        result.append(mid)
        left = mid + 1
    else:
        right = mid - 1
print(max(result))
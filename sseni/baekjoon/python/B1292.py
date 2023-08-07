number_list = []
for i in range(1, 46):
    number_list += [i] * i

a, b = map(int, input().split())
print(sum(number_list[a - 1:b]))
import sys

n = int(input())
m = int(input())
if n > 1000 or m > 1000:
    sys.exit()
matrix = [list(map(int, input().split())) for i in range(n)]

x = int(input())
y = int(input())

rez = []
if (x >= 0 and y >= 0) and (x < n and y < m):
    if x + 1 < n and x != n - 1:
        rez.append(matrix[x + 1][y])
    if x != 0:
        rez.append(matrix[x - 1][y])
    if y + 1 < m and y != m - 1:
        rez.append(matrix[x][y + 1])
    if y != 0:
        rez.append(matrix[x][y - 1])
else:
    sys.exit()
print(*sorted(rez))

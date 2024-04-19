import random

start = 100
end = 10000
lst = []
while start <= end:
    arr = list([random.randint(0, 1000000) for i in range(start)])
    for i in range(len(arr)):
        arr[i] = str(arr[i])
    start += 100
    s = " ".join(arr)
    lst.append(s)
with open('file.txt', 'w') as f:
    f.writelines(f"{item}\n" for item in lst)

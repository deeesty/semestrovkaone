import time
def counting_sort(arr, exp):
    n = len(arr)
    output = [0] * n
    count = [0] * 10

    for i in range(n):
        index = arr[i] // exp
        count[index % 10] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    i = n - 1
    while i >= 0:
        index = arr[i] // exp
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    for i in range(n):
        arr[i] = output[i]


def radix_sort(arr):
    max_num = max(arr)
    exp = 1
    while max_num // exp > 0:
        counting_sort(arr, exp)
        exp *= 10


def main():
    with open("file.txt", "r") as file:
        arrays = [list(map(int, line.split())) for line in file]

    with open("res.txt", "w") as result_file:
        for idx, arr in enumerate(arrays):
            start_time = time.time_ns()
            radix_sort(arr)
            end_time = time.time_ns()

            num_iterations = len(str(max(arr)))
            sorting_time = end_time - start_time

            result_file.write(f"Массив {idx + 1}:\n")
            result_file.write(f"Отсортированный массив: {arr}\n")
            result_file.write(f"Количество итераций: {num_iterations}\n")
            result_file.write(f"Время сортировки: {sorting_time} наносекунд\n\n")


if __name__ == "__main__":
    main()

import sys

def main(args):
    # Пример: просто складываем два числа
    if len(args) < 2:
        print("Недостаточно аргументов")
        return
    try:
        num1 = float(args[0])
        num2 = float(args[1])
        result = num1 + num2
        print(result)
    except ValueError:
        print("Аргументы должны быть числами")

if __name__ == "__main__":
    main(sys.argv[1:])

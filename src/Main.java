import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {

        // Задание 1.1
        System.out.println("\nЗадача 1.1:");
        Box<Integer> box = new Box<>();
        box.setNumber(3);

        System.out.println("Создаем коробку: " + box.toString());

        // Передаю Box в метод и вывожу значение
        printBoxValue(box);

        // Проверка, пуста ли коробка после извлечения значения
        System.out.println("Коробка пуста: " + box.isEmpty());


        // Задание 1.2
        System.out.println("\nЗадача 1.2:");
        // Создаю Хранилище чисел, кладу туда значение null
        Storage<Integer> intStorageNull = new Storage<>(null);
        printNumber(intStorageNull, 0);

        // Создаю Хранилище чисел, кладу туда значение 99
        Storage<Integer> intStorage99 = new Storage<>(99);
        printNumber(intStorage99, -1);

        // Создаю Хранилище строк, кладу туда значение null
        Storage<String> strStorageNull = new Storage<>(null);
        printNumber(strStorageNull, "default");

        // Создаю Хранилище строк, кладу туда значение "hello"
        Storage<String> strStorageHello = new Storage<>("hello");
        printNumber(strStorageHello, "hello world");


        // Задание 2.3
        System.out.println("\nЗадача 2.3:");
        Box<PointZ> boxPoint = new Box<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату X: ");
        int x = scanner.nextInt();
        System.out.print("Введите координату Y: ");
        int y = scanner.nextInt();
        System.out.print("Введите координату Z: ");
        int z = scanner.nextInt();

        PointZ pointZ = new PointZ(x, y, z);

        // Устанавливаю PointZ в коробку
        setPointZInBox(boxPoint, pointZ);

        // Проверяю, что PointZ установлен в коробку
        System.out.println("Создаем коробку: " + boxPoint.toString());

        // Извлекаю PointZ из коробки
        PointZ extractedPointZ = boxPoint.getNumber();
        System.out.println("Точки из коробки: " + extractedPointZ);

        // Проверка, пуста ли коробка после извлечения значения
        System.out.println("Коробка пуста: " + boxPoint.isEmpty());


        // Задание 3.1
        System.out.println("\nЗадача 3.1:");

        // Пункт 1
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        Function<String, Integer> stringLengthFunction = String::length;
        List<Integer> lengths = applyToList(strings, stringLengthFunction);
        System.out.println("Исходный список строк: " + List.of("qwerty", "asdfg", "zx"));
        System.out.println("Длины строк: " + lengths);

        // Пункт 2
        List<Integer> numbers = List.of(1, -3, 7);
        Function<Integer, Integer> absFunction = Math::abs;
        List<Integer> absNumbers = applyToList(numbers, absFunction);
        System.out.println("\nИсходный список чисел: " + List.of(1, -3, 7));
        System.out.println("Абсолютные значения: " + absNumbers);

        // Пункт 3
        List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9});
        Function<int[], Integer> maxFunction = array -> {
            int max = Integer.MIN_VALUE;
            for (int num : array) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        };
        List<Integer> maxValues = applyToList(arrays, maxFunction);
        System.out.println("\nИсходные списки: " + List.of(1, 2, 3) + ", " + List.of(4, 5, 6) + ", " + List.of(7, 8, 9));
        System.out.println("Максимальные значения: " + maxValues);

        // Задание 3.2
        System.out.println("\nЗадача 3.2:");

        // Задание 3.3
        System.out.println("\nЗадача 3.3:");

        // Задание 3.4
        System.out.println("\nЗадача 3.4:");

    }


    // метод для задачи 1.1
    public static void printBoxValue(Box<?> box) {
        try {
            System.out.println("Число из коробки: " + box.getNumber());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // метод для задачи 1.2
    public static <T> void printNumber(Storage<T> storage, T defaultNumber) {
        T number = storage.getNumberOrDefault(defaultNumber);
        System.out.println(number);
    }

    // метод для задачи 2.3
    public static <T extends PointZ> void setPointZInBox(Box<T> boxPoint, T pointZ) {
        boxPoint.setNumber(pointZ);
    }

    // метод для задачи 3.1
    public static <T, P> List<P> applyToList(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}

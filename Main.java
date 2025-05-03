
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Главный класс программы, управляющий списком холодильников.
 */
public class Main {

  /**
   * Главный метод, запускающий приложение.
   *
   * @param args аргументы командной строки (не используются)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Refrigerator> refrigerators = new ArrayList<>();
    boolean running = true;

    // Основной цикл программы
    while (running) {
      System.out.println("\nМеню:");
      System.out.println("1. Добавить пустой холодильник");
      System.out.println("2. Добавить холодильник с заполнением полей");
      System.out.println("3. Редактировать холодильник");
      System.out.println("4. Показать все холодильники");
      System.out.println("5. Отсортировать холодильники по вместимости");
      System.out.println("6. Выход");
      System.out.print("Выберите пункт: ");

      String choice = scanner.nextLine();

      switch (choice) {
        case "1":
          refrigerators.add(new Refrigerator());
          System.out.println("Пустой холодильник добавлен.");
          break;
        case "2":
          refrigerators.add(createRefrigerator(scanner));
          System.out.println("Холодильник добавлен.");
          break;
        case "3":
          editRefrigerator(refrigerators, scanner);
          break;
        case "4":
          printRefrigerators(refrigerators);
          break;
        case "5":
          sortRefrigerators(refrigerators);
          System.out.println("Список отсортирован.");
          break;
        case "6":
          running = false;
          break;
        default:
          System.out.println("Некорректный ввод. Попробуйте снова.");
      }
    }

    scanner.close();
  }

  /**
   * Создает новый холодильник на основе пользовательского ввода.
   *
   * @param scanner объект Scanner для ввода данных
   * @return новый объект Refrigerator
   */
  private static Refrigerator createRefrigerator(Scanner scanner) {
    System.out.print("Введите бренд: ");
    String brand = scanner.nextLine();
    System.out.print("Введите модель: ");
    String model = scanner.nextLine();
    System.out.print("Введите вместимость (л): ");
    int capacity = parsePositiveInt(scanner);
    System.out.print("Введите потребление энергии (кВт/ч): ");
    double powerConsumption = parsePositiveDouble(scanner);
    System.out.print("Введите высоту (м): ");
    double height = parsePositiveDouble(scanner);

    return new Refrigerator(brand, model, capacity, powerConsumption, height);
  }

  /**
   * Позволяет пользователю редактировать поля существующего холодильника.
   *
   * @param refrigerators список холодильников
   * @param scanner       объект Scanner для ввода данных
   */
  private static void editRefrigerator(
      ArrayList<Refrigerator> refrigerators, Scanner scanner) {
    if (refrigerators.isEmpty()) {
      System.out.println("Список холодильников пуст.");
      return;
    }

    printRefrigerators(refrigerators);
    System.out.print("Введите индекс холодильника для редактирования: ");
    int index = parsePositiveInt(scanner);

    if (index >= 0 && index < refrigerators.size()) {
      Refrigerator r = refrigerators.get(index);

      System.out.println("Выберите поле для редактирования:");
      System.out.println("1. Бренд");
      System.out.println("2. Модель");
      System.out.println("3. Вместимость");
      System.out.println("4. Потребление энергии");
      System.out.println("5. Высота");

      String field = scanner.nextLine();

      switch (field) {
        case "1":
          System.out.print("Введите новый бренд: ");
          r.setBrand(scanner.nextLine());
          break;
        case "2":
          System.out.print("Введите новую модель: ");
          r.setModel(scanner.nextLine());
          break;
        case "3":
          System.out.print("Введите новую вместимость (л): ");
          r.setCapacity(parsePositiveInt(scanner));
          break;
        case "4":
          System.out.print("Введите новое потребление энергии (кВт/ч): ");
          r.setPowerConsumption(parsePositiveDouble(scanner));
          break;
        case "5":
          System.out.print("Введите новую высоту (м): ");
          r.setHeight(parsePositiveDouble(scanner));
          break;
        default:
          System.out.println("Некорректный выбор поля.");
      }
    } else {
      System.out.println("Индекс вне диапазона.");
    }
  }

  /**
   * Печатает список всех холодильников.
   *
   * @param refrigerators список холодильников
   */
  private static void printRefrigerators(ArrayList<Refrigerator> refrigerators) {
    if (refrigerators.isEmpty()) {
      System.out.println("Список холодильников пуст.");
      return;
    }

    for (int i = 0; i < refrigerators.size(); i++) {
      System.out.println("[" + i + "] " + refrigerators.get(i));
    }
  }

  /**
   * Сортирует список холодильников по вместимости.
   *
   * @param refrigerators список холодильников
   */
  private static void sortRefrigerators(ArrayList<Refrigerator> refrigerators) {
    Collections.sort(refrigerators, Comparator.comparingInt(Refrigerator::getCapacity));
  }

  /**
   * Читает положительное целое число с консоли.
   *
   * @param scanner объект Scanner
   * @return положительное целое число
   */
  private static int parsePositiveInt(Scanner scanner) {
    int value = -1;
    while (value < 0) {
      try {
        value = Integer.parseInt(scanner.nextLine());
        if (value < 0) {
          System.out.print("Введите положительное число: ");
        }
      } catch (NumberFormatException e) {
        System.out.print("Введите корректное целое число: ");
      }
    }
    return value;
  }

  /**
   * Читает положительное вещественное число с консоли.
   *
   * @param scanner объект Scanner
   * @return положительное вещественное число
   */
  private static double parsePositiveDouble(Scanner scanner) {
    double value = -1.0;
    while (value <= 0.0) {
      try {
        value = Double.parseDouble(scanner.nextLine());
        if (value <= 0.0) {
          System.out.print("Введите положительное число: ");
        }
      } catch (NumberFormatException e) {
        System.out.print("Введите корректное число: ");
      }
    }
    return value;
  }
}

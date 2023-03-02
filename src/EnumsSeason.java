import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnumsSeason {
  enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  public static Map<Month, Integer> buildMonthsMap() { // сделать словарь с месяцами и днями
    Map<Month, Integer> months = new HashMap<>(); // словарь с месяцами и днями

    months.put(Month.JANUARY, 31);
    months.put(Month.FEBRUARY, 28);
    months.put(Month.MARCH, 31);
    months.put(Month.APRIL, 30);
    months.put(Month.MAY, 31);
    months.put(Month.JUNE, 30);
    months.put(Month.JULY, 31);
    months.put(Month.AUGUST, 31);
    months.put(Month.SEPTEMBER, 30);
    months.put(Month.OCTOBER, 31);
    months.put(Month.NOVEMBER, 30);
    months.put(Month.DECEMBER, 31);

    return months; // возвращаем готовый словарь с месяцами и днями
  }

  // программа получает название месяца
  // возвращает количество дней
  public static void main(String[] args) throws IOException {
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter the month: "); // Введите название месяца
    String month = inputReader.readLine();

    // ИмяТипа.valueOf("ЗНАЧЕНИЕ") - вернёт соответствующее ИмяТипа.ЗНАЧЕНИЕ
    // ИмяТипа.ЗНАЧЕНИЕ.toString() - вернёт строку "ЗНАЧЕНИЕ"
    Month monthToLook = Month.valueOf(month.toUpperCase()); // месяц для поиска в словаре

    Map<Month, Integer> monthDays = buildMonthsMap();

    // ИмяТипа.ЗНАЧЕНИЕ.ordinal() - вернёт порядковый номер ЗНАЧЕНИЕ в enum, начиная с 0
    if (monthDays.containsKey(monthToLook)) {
      // "Месяц %s содержит %d дней"
      System.out.printf("The month '%s' contains %d days%n", month, monthDays.get(monthToLook));
      // "У месяца %s вот такой (%d) порядковый номер"
      System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
    } else {
      System.out.println("No such month: " + month); // Нет такого месяца
    }

    // ИмяТипа.values() - возвращает массив всех значений ИмяТипа[] по порядку
    // Month.values() == Month[]
  }
}

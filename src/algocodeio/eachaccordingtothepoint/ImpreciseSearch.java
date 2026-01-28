package algocodeio.eachaccordingtothepoint;

public class ImpreciseSearch {

  public static void main(String[] args) {
    System.out.println("Result №1:");
    System.out.println(fuzzyMatch("abc", "a1b2tyc3"));

    System.out.println("Result №2:");
    System.out.println(fuzzyMatch("abcd", "efgklmn"));

    System.out.println("Result №3:");
    System.out.println(fuzzyMatch("abcd", "eafbgckdlmn"));

    System.out.println("Result №4:");
    System.out.println(fuzzyMatch("cartwheel", "lw"));

    System.out.println("Result №5:");
    System.out.println(fuzzyMatch("cwhl", "cartwheel"));

    System.out.println("Result №6:");
    System.out.println(fuzzyMatch("lw", "cartwheel"));
  }

  /**
   * Даны две строки s и t. Необходимо определить, можно ли получить строку s, удаляя некоторые
   * (возможно, ни одного) символы из строки t, не изменяя порядок оставшихся символов.

   * Пример 1: Ввод: s = "abc", t = "a1b2c3" Вывод: True
   * Объяснение: Можно удалить цифры из t, чтобы получить t = "abc"

   * Пример 2: Ввод: s = "abc", t = "acb" Вывод: False

   * Ограничения: len(s) ≥ 0 len(t) ≥ 0 Строки s и t содержат только ascii символы

   * Оценка сложности
   * Время: O(n + m), где n — длина s, m — длина t
   * Память: O(1)
   */
  public static boolean fuzzyMatch(String word1, String word2) {
    int p1 = 0;
    int p2 = 0;

    // Пока не достигли конца хотя бы одной из строк
    while (p1 < word1.length() && p2 < word2.length()) {
      if (word1.charAt(p1) == word2.charAt(p2)) {
        // Если символы совпадают — продвигаем указатель по word1
        p1++;
      }
      // Всегда двигаем указатель по word2
      p2++;
    }

    return p1 == word1.length();
  }
}

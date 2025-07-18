package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindUniqWordsMain {

  public static void main(String[] args) {
    String text = "Hello, world! Hello Java. Java is great.";

    List<String> words = findUniqWords(text);

    for (String word : words) {
      System.out.println(word);
    }
  }

  public static List<String> findUniqWords(String text) {
    // Проверка на пустую строку
    if (text == null || text.trim().isEmpty()) {
      return Collections.emptyList();
    }

    // Приводим текст к нижнему регистру и заменяем знаки препинания на пробелы
    String normalizedText = text.replaceAll("\\p{Punct}", " ").toLowerCase();

    // Разбиваем текст на слова
    String[] words = normalizedText.split("\\s+");

    // Используем TreeSet для автоматической сортировки и уникальности
    Set<String> set = new TreeSet<>(Arrays.asList(words));

    // Возвращаем отсортированный список уникальных слов
    return new ArrayList<>(set);
  }
}
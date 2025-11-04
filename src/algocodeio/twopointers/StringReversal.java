package algocodeio.twopointers;

import java.util.Arrays;
import java.util.List;

public class StringReversal {

    public static void main(String[] args) {
        System.out.print("Result №1 of solution 1 is ");
        System.out.println(reverseString(Arrays.asList('p','e','r','f','e','c','t','i','o','n')));
        System.out.println(reverseString(Arrays.asList('r','e','v','e','r','s','e')));
    }

    /**
     Дан список символов chars. Нужно развернуть chars и вернуть измененный список в качестве ответа.

     Пример 1:
     Ввод: chars = ["p","e","r","f","e","c","t","i","o","n"]
     Вывод: ["n","o","i","t","c","e","f","r","e","p"]

     Пример 2:
     Ввод: chars = ["r","e","v","e","r","s","e"]
     Вывод: ["e","s","r","e","v","e","r"]

     Ограничения:
     len(chars) >= 0
     chars содержит только ascii символы
     */

    public static List<Character> reverseString(List<Character> chars) {
        int p1 = 0;
        int p2 = chars.size() - 1;

        while (p1 < p2) {
            Character tmp = chars.get(p1);

            chars.set(p1, chars.get(p2));
            chars.set(p2, tmp);

            p1++;
            p2--;
        }

        return chars;
    }
}

package algocodeio.twopointers;

public class RegularPalindrome {
    public static void main(String[] args) {
        System.out.print("Result №1 of solution 1 is ");
        System.out.println(defineIsARegularPalindrome1("Re, b1 1 B e r"));
        System.out.print("Result №2 of solution 2 is ");
        System.out.println(defineIsARegularPalindrome2("Abaddaba"));
    }

    /**
     Дана строка s. Верните true, если s является палиндромом, или false в противном случае.
     Фраза является палиндромом, если после преобразования всех заглавных букв в строчные и удаления всех символов,
     кроме букв и цифр, она читается одинаково слева направо и справа налево.

     Буквенно-цифровые символы включают латинские буквы и цифры.

     Пример 1:
     Ввод: s = "A man, a plan, a canal: Panama"
     Вывод: true
     Объяснение: строка "amanaplanacanalpanama" является палиндромом

     Пример 2:
     Ввод: s = "AbaCdaba"
     Вывод: false

     Ограничения:
     len(s) >= 1
     */

    // Solution 1
    public static boolean defineIsARegularPalindrome1(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Solution 2
    public static boolean defineIsARegularPalindrome2(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return  false;
            }

            left++;
            right--;
        }

        return true;
    }
}

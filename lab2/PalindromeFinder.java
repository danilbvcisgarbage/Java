import java.util.Scanner;

public class PalindromeFinder {

    /**
     * Основний метод для запуску програми.
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            // Ініціалізація сканера для зчитування тексту від користувача
            scanner = new Scanner(System.in);
            System.out.println("Enter a text to find the longest palindrome:");

            // Зчитування тексту від користувача
            String inputText = scanner.nextLine();

            // Виклик методу для пошуку найдовшого паліндрому
            String longestPalindrome = findLongestPalindrome(inputText);

            // Виведення результату
            System.out.println("The longest palindrome in the text: " + longestPalindrome);
        } catch (Exception e) {
            // Обробка виключних ситуацій
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Закриття сканера
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Метод для пошуку найдовшого підрядка, що є паліндромом.
     *
     * @param text текст, у якому виконується пошук
     * @return найдовший підрядок-паліндром
     */
    public static String findLongestPalindrome(String text) {
        // Перевірка, чи рядок є порожнім або null
        if (text == null || text.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";
        int maxLength = 0;

        // Перебір усіх можливих підрядків
        for (int start = 0; start < text.length(); start++) {
            for (int end = start + 1; end <= text.length(); end++) {
                // Виділення підрядка
                String substring = text.substring(start, end);

                // Перевірка, чи є підрядок паліндромом
                if (isPalindrome(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    longestPalindrome = substring;
                }
            }
        }

        return longestPalindrome;
    }

    /**
     * Метод для перевірки, чи є рядок паліндромом.
     *
     * @param text рядок, що перевіряється
     * @return true, якщо рядок є паліндромом; false, якщо ні
     */
    public static boolean isPalindrome(String text) {
        int length = text.length();

        // Перевірка символів з початку і кінця рядка
        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) != text.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

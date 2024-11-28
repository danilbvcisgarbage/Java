import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeFinder {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter a text to find the longest palindrome:");

            // Зчитування тексту
            String inputText = scanner.nextLine();

            // Парсинг тексту у відповідні класи
            Text text = Text.parse(inputText);

            // Пошук найдовшого паліндрома
            String longestPalindrome = text.findLongestPalindrome();

            System.out.println("The longest palindrome in the text: " + longestPalindrome);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

/**
 * Клас для представлення літери.
 */
class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}

/**
 * Клас для представлення слова, яке складається з літер.
 */
class Word {
    private List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }
}

/**
 * Клас для представлення речення, яке складається зі слів і розділових знаків.
 */
class Sentence {
    private List<Object> elements; // Слова та розділові знаки

    public Sentence(String sentence) {
        elements = new ArrayList<>();
        String[] words = sentence.split("(?=[,.!?])|(?<=[,.!?])"); // Розбивання на слова та знаки
        for (String part : words) {
            if (part.matches("[,.!?]")) {
                elements.add(part); // Розділовий знак
            } else {
                elements.add(new Word(part.trim()));
            }
        }
    }

    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Object element : elements) {
            sentence.append(element.toString());
        }
        return sentence.toString();
    }
}

/**
 * Клас для представлення тексту, який складається з речень.
 */
class Text {
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public static Text parse(String text) {
        Text parsedText = new Text();
        String[] sentences = text.split("(?<=[.!?])\\s*");
        for (String sentence : sentences) {
            parsedText.sentences.add(new Sentence(sentence));
        }
        return parsedText;
    }

    public String findLongestPalindrome() {
        String allText = this.toString().replaceAll("\\s+", " ").toLowerCase();
        allText = allText.replaceAll("[^a-zA-Z]", "");  // Видалення всіх не алфавітних символів

        String longestPalindrome = "";
        int maxLength = 0;

        // Перебір усіх можливих підрядків
        for (int start = 0; start < allText.length(); start++) {
            for (int end = start + 1; end <= allText.length(); end++) {
                String substring = allText.substring(start, end);
                if (isPalindrome(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    longestPalindrome = substring;
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) != text.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder fullText = new StringBuilder();
        for (Sentence sentence : sentences) {
            fullText.append(sentence.toString()).append(" ");
        }
        return fullText.toString().trim();
    }
}

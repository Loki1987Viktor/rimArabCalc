package Calculate;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        String userInput = null;
        Scanner scan = new Scanner(System.in);
        // Считываем строку userInput которую ввёл пользователь(цикл)
        while (true) {
            System.out.println("Введите 2 цифры и арифметическую операцию между ними, через проблел и нажмите клавишу Enter");
            System.out.println("Для выхода из программы введите exit");
            userInput = scan.nextLine();
            if (userInput.equals("exit")) break;
            calc(userInput);
        }
    }
    public static String calc(String calc) {
        int resultArab = 0;
        String resultRim;
        try {
            String[] splitUserImport = calc.split(" ");

            if (splitUserImport.length < 3) {
                throw new Exception("Строка не является математической операцией");
            }
            if (splitUserImport.length > 3) {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            String symbol1 = splitUserImport[0];
            String symbol2 = splitUserImport[2];
            String operation = splitUserImport[1];
            int num1 = romanToNumber(symbol1);
            int num2 = romanToNumber(symbol2);
            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

            if (symbol1.matches(Arrays.toString(roman)) || symbol2.matches(Arrays.toString(roman))) {
                throw new Exception("Используются одновременно разные системы счисления");
            }

            if (symbol1.matches(Arrays.toString(roman)) & symbol2.matches(Arrays.toString(roman))) {
                if (operation.equals("+")) {
                    resultArab = num1 + num2;
                    resultRim = String.valueOf(convertNumToRoman(resultArab));
                    System.out.println(resultRim);
                } else if (operation.equals("-")) {
                    if (num1 < num2) {
                        throw new Exception("В римской системе нет отрицательных чисел");
                    }
                    resultArab = num1 - num2;
                    resultRim = String.valueOf(convertNumToRoman(resultArab));
                    System.out.println(resultRim);
                } else if (operation.equals("*")) {
                    resultArab = num1 * num2;
                    resultRim = String.valueOf(convertNumToRoman(resultArab));
                    System.out.println(resultRim);
                } else if (operation.equals("/")) {
                    resultArab = num1 / num2;
                    resultRim = String.valueOf(convertNumToRoman(resultArab));
                    System.out.println(resultRim);
                }
            } else if (operation.equals("+")) {
                resultArab = Integer.parseInt(symbol1) + Integer.parseInt(symbol2);
                System.out.println(resultArab);
            } else if (operation.equals("-")) {
                resultArab = Integer.parseInt(symbol1) - Integer.parseInt(symbol2);
                System.out.println(resultArab);
            } else if (operation.equals("*")) {
                resultArab = Integer.parseInt(symbol1) * Integer.parseInt(symbol2);
                System.out.println(resultArab);
            } else if (operation.equals("/")) {
                resultArab = Integer.parseInt(symbol1) / Integer.parseInt(symbol2);
                System.out.println(resultArab);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
        private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
        final String s = roman[numArabian];
        return s;
    }
    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (Exception e) {
            System.out.println("Используются одновременно разные системы счисления");
        }
        return 0;
    }
}


package Calculate;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        String userInput;
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
        int resultArab;

        try {
            String[] splitUserImport = calc.split(" ");

            if (splitUserImport.length < 3) {
                throw new Exception("Строка не является математической операцией!");
            }

            if (splitUserImport.length > 3) {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            String symbol1 = splitUserImport[0];
            String symbol2 = splitUserImport[2];
            String operation = splitUserImport[1];
            int num1 = romanToNumber(symbol1);
            int num2 = romanToNumber(symbol2);
            boolean flag1 = false;
            boolean flag2 = false;

            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

            for (int i = 0; i < roman.length; i++) {
                if (symbol1.equals(roman[i])) {
                    flag1 = true;
                }
            }
            for (int y = 0; y < roman.length; y++) {
                if (symbol2.equals(roman[y])) {
                    flag2 = true;
                }
            }

            if (num1 > 0 & num2 > 0 & num1 < 11 & num2 < 11) {
                if (flag1 & flag2) {
                    if (operation.equals("+")) {
                        resultArab = num1 + num2;
                        System.out.println(convertNumToRoman(resultArab));
                    } else if (operation.equals("-")) {
                        if (num1 < num2) {
                            throw new Exception("В римской системе нет отрицательных чисел!");
                        } else {
                            resultArab = num1 - num2;
                            if (resultArab < 1) {
                                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более!");
                            }
                            System.out.println(convertNumToRoman(resultArab));
                        }
                    } else if (operation.equals("*")) {
                        resultArab = num1 * num2;
                        System.out.println(convertNumToRoman(resultArab));
                    } else if (operation.equals("/")) {
                        resultArab = num1 / num2;
                        System.out.println(convertNumToRoman(resultArab));
                    } else {
                        throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более!");
                    }
                } else if (!flag1 & !flag2) {
                    if (operation.equals("+")) {
                        resultArab = num1 + num2;
                        System.out.println(resultArab);
                    } else if (operation.equals("-")) {
                        resultArab = num1 - num2;
                        System.out.println(resultArab);
                    } else if (operation.equals("*")) {
                        resultArab = num1 * num2;
                        System.out.println(resultArab);
                    } else if (operation.equals("/")) {
                        resultArab = num1 / num2;
                        System.out.println(resultArab);
                    }
                } else {
                    throw new Exception("Используются одновременно разные системы счисления");
                }
            } else {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более!");
            }
        } catch (ArrayIndexOutOfBoundsException abe) {
            System.out.println("Калькулятор принимает на вход числа от 1 до 10 включительно, не более!");
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
            if (roman.equals("I") | roman.equals("1")) {
                return 1;
            } else if (roman.equals("II") | roman.equals("2")) {
                return 2;
            } else if (roman.equals("III") | roman.equals("3")) {
                return 3;
            } else if (roman.equals("IV") | roman.equals("4")) {
                return 4;
            } else if (roman.equals("V") | roman.equals("5")) {
                return 5;
            } else if (roman.equals("VI") | roman.equals("6")) {
                return 6;
            } else if (roman.equals("VII") | roman.equals("7")) {
                return 7;
            } else if (roman.equals("VIII") | roman.equals("8")) {
                return 8;
            } else if (roman.equals("IX") | roman.equals("9")) {
                return 9;
            } else if (roman.equals("X") | roman.equals("10")) {
                return 10;
            }
        } catch (Exception e) {
            System.out.println("Используются одновременно разные системы счисления");
        }
        return -1;
    }
}


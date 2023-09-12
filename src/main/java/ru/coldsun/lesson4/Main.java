package ru.coldsun.lesson4;

import ru.coldsun.lesson4.myExceptions.MyArrayDataException;
import ru.coldsun.lesson4.myExceptions.MyArraySizeException;

import java.util.Scanner;

public class Main {
    /**
     * Основной метод
     * @inputArr двумерный массив строк
     * @result возвращаемый результат суммы элементов массива Int
     */
    public static void main(String[] args) throws Exception {

        String inputArr[][] = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        PrintArr(inputArr);

        int result = 0;
        try {
            result = SumElemet(inputArr);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }
        catch (Exception e) {
            System.out.println("Ошибка не определена: " + e);
        }

        System.out.println("Результат: " + result);

    }

    /**
     * Печать исходного двумерного массива строк
     *
     */
    static void PrintArr(String[][] arrStr) {
        if (arrStr != null) {
            for (int i = 0; i < arrStr.length; i++) {
                for (int j = 0; j < arrStr[0].length; j++) {
                    System.out.printf("%-4s", arrStr[i][j] );
                }
                System.out.println();
            }
        }
    }
    /**
    * Метод суммы элементов двумерного массива
     * Проверяет ссоответствие количество столбцов количеству строк
     * Проверяет общее условие на размер массива 4х4
     * Производит преобразование элеманта строки в значения типа Int
     * Суммирует элементы
     *
    */
    static int SumElemet(String[][]arrStrInt) throws Exception {
        int[][] arrResult;
        int sum = 0;
        if (arrStrInt.length == arrStrInt[0].length && arrStrInt.length == 4) {
            for (int i = 0; i < arrStrInt.length; i++) {
                for (int j = 0; j < arrStrInt.length; j++) {
                    try {
                        sum += Integer.parseInt(arrStrInt[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException(i+1,j+1);
                    }
                }
            }
            System.out.println();
        } else {
            throw new MyArraySizeException(arrStrInt.length);
        }
        return sum;
    }
}

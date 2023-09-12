package ru.coldsun.lesson4.myExceptions;

public class MyArraySizeException extends Exception{
    private static int row;

    public MyArraySizeException(String msg) {
        super(msg);
    }
    public MyArraySizeException(int row) {

        super("В ячейке не верный тип данных");

        this.row = row;

    }

    @Override
    public String toString() {
        return "Заданный массив не соответсвует параметрам " + this.row + "x" + this.row;
    }
}

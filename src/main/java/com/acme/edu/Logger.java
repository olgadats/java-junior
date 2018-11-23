package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    private static final Integer MAX_INTEGER = Integer.MAX_VALUE;
    private static final Byte MAX_BYTE = Byte.MAX_VALUE;

    private static boolean isPrevInt = false;
    private static int intSum = 0;
    private static int stringsCount = 0;
    private static String prevString = "";

    public static void log(int message) {
        if (isPrevInt) {
            if (MAX_INTEGER.equals(message)) {
                print();
                print(PRIMITIVE_PREFIX + MAX_INTEGER);
                isPrevInt = false;
                intSum = 0;
            } else {
                intSum += message;
            }
        } else {
            print();
            intSum = message;
            isPrevInt = true;
        }
    }

    public static void log(byte message) {
        if (MAX_BYTE.equals(message)) {}
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (stringsCount > 0) {
            if (prevString.equals(message)) {
                stringsCount++;
            } else {
                print();
                prevString = message;
                stringsCount = 0;
            }
        } else {
            print();
            prevString = message;
            stringsCount++;
        }
//        print(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        print(REFERENCE_PREFIX + message);
    }

    private static void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    public static void print() {
        if (isPrevInt) {
            print(PRIMITIVE_PREFIX + intSum);
            isPrevInt = false;
            intSum = 0;
        } else if (stringsCount > 0) {
            if (stringsCount == 1) {
                print(STRING_PREFIX + prevString);
            } else {
                print(STRING_PREFIX + prevString + " (x" + stringsCount + ")");
            }

            prevString = "";
            stringsCount =0;
        }
    }

    public static void log(int[][] matrix) {
        StringBuilder decoratedMessage = new StringBuilder(PRIMITIVE_MATRIX_PREFIX).append("{").append(System.lineSeparator());

        for (int i = 0; i < matrix.length; i++) {
            decoratedMessage.append("{");
            for (int j = 0; j < matrix.length - 1; j++) {
                decoratedMessage.append(matrix[i][j]).append(", ");
            }
            decoratedMessage.append(matrix[i][matrix.length - 1]).append("}").append(System.lineSeparator());
        }
        decoratedMessage.append("}");
        print(decoratedMessage.toString());
    }

    public static void log(int[] array) {
        StringBuilder decoratedMessage = new StringBuilder(PRIMITIVE_ARRAY_PREFIX + "{");

        for (int i = 0; i < array.length - 1; i++) {
            decoratedMessage.append(array[i]).append(", ");
        }
        decoratedMessage.append(array[array.length - 1]).append("}");

        print(decoratedMessage.toString());

    }

}

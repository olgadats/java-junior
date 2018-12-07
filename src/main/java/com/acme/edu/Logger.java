package com.acme.edu;

public class Logger {

    private static LoggerController loggerController = new LoggerController();

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    public static void log(int message) {
       loggerController.log(message);
    }

    public static void log(byte message) {
        if (MAX_BYTE.equals(message)) {}
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        loggerController.log(message);
    }

    public static void log(boolean message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        print(REFERENCE_PREFIX + message);
    }

//    private static void print(String decoratedMessage) {
//        System.out.println(decoratedMessage);
//    }

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

package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private static final Integer MAX_INTEGER = Integer.MAX_VALUE;
    private static final Byte MAX_BYTE = Byte.MAX_VALUE;

    private static boolean isPrevInt = false;
    private static int stringsCount = 0;
    private static String prevString = "";

    public static void log(int message) {
        if (MAX_INTEGER.equals(message)) {

        }
        if (isPrevInt) {

        }
        else
    }

    public static void log(byte message) {
        if (MAX_BYTE.equals(message)) {}
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        print(STRING_PREFIX + message);
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
    private static void print() {
        if (isPrevInt)
        System.out.println(decoratedMessage);
    }
}

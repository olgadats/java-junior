package com.acme.edu;

public class LoggerController {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String STRING_PREFIX = "string: ";
    private final String CHAR_PREFIX = "char: ";
    private final String REFERENCE_PREFIX = "reference: ";
    private final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    private static final Integer MAX_INTEGER = Integer.MAX_VALUE;
    private static final Byte MAX_BYTE = Byte.MAX_VALUE;

    private IntegerMessage integerMessage = new IntegerMessage();
    private StringMessage stringsMessage = new StringMessage();

    private PrefixDecorator prefixDecorator = new PrefixDecorator();
    private ConsolePrinter consolePrinter = new ConsolePrinter();

    public void log(int message) {
        if (integerMessage.isPrevInt()) {
            if (MAX_INTEGER.equals(message)) {
                flush();
                consolePrinter.print(PRIMITIVE_PREFIX + MAX_INTEGER);
                integerMessage.setPrevInt(false);
                integerMessage.setIntSum(0);
            } else {
                integerMessage.incrementSum(message);
            }
        } else {
            flush();
            integerMessage.setIntSum(message);
            integerMessage.setPrevInt(true);
        }
    }

    public void log(String message) {
        if (stringsMessage.getStringsCount() > 0) {
            if (stringsMessage.equalsPrev(message)) {
                stringsMessage.incrementStringsCount();
            } else {
                flush();
                stringsMessage.setPrevString(message);
                stringsMessage.setStringsCount(0);
            }
        } else {
            flush();
            stringsMessage.setPrevString(message);
            stringsMessage.incrementStringsCount();
        }
    }

    public void flush() {
        if (integerMessage.isPrevInt()) {
            consolePrinter.print(PRIMITIVE_PREFIX + integerMessage.getIntSum());
            integerMessage.setPrevInt(false);
            integerMessage.setIntSum(0);
        } else if (stringsMessage.getStringsCount() > 0) {
            if (stringsMessage.getStringsCount() == 1) {
                consolePrinter.print(STRING_PREFIX + stringsMessage.getPrevString());
                consolePrinter.print(prefixDecorator.decorate(
                        STRING_PREFIX, stringsMessage.getPrevString()));
            } else {
                consolePrinter.print(STRING_PREFIX + stringsMessage.getPrevString() +
                        " (x" + stringsMessage.getStringsCount() + ")");
            }

            stringsMessage.setPrevString("");
            stringsMessage.setStringsCount(0);
        }
    }
}

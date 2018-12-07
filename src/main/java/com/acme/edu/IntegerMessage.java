package com.acme.edu;

public class IntegerMessage {
    private boolean isPrevInt;
    private int intSum;

    public IntegerMessage() {
        isPrevInt = false;
        intSum = 0;
    }

    public void setPrevInt(boolean prevInt) {
        isPrevInt = prevInt;
    }

    public void setIntSum(int intSum) {
        this.intSum = intSum;
    }

    public boolean isPrevInt() {
        return isPrevInt;
    }

    public int getIntSum() {
        return intSum;
    }

    public void incrementSum(int message) {
        intSum += message;
    }
}

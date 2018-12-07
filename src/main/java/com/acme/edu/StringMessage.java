package com.acme.edu;

public class StringMessage {
    private int stringsCount;
    private String prevString;

    public StringMessage() {
        stringsCount = 0;
        prevString = "";
    }

    public int getStringsCount() {
        return stringsCount;
    }

    public void setStringsCount(int stringsCount) {
        this.stringsCount = stringsCount;
    }

    public String getPrevString() {
        return prevString;
    }

    public void setPrevString(String prevString) {
        this.prevString = prevString;
    }

    public void incrementStringsCount() {
        stringsCount++;
    }

    public boolean equalsPrev(String message) {
        return prevString.equals(message);
    }
}

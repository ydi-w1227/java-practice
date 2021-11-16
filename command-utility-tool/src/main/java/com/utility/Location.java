package com.utility;

public class Location {
    private int lineNumber;
    private int column;

    public Location(int lineNumber, int column) {
        this.lineNumber = lineNumber;
        this.column = column;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "ln=" + lineNumber +
                " column=" + column;
    }
}

package dataholder;

import java.util.List;

public class DataHolder {

    private byte aByte;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private boolean aBoolean;
    private char aChar;

    private String aString;

    private int[] intArray;
    private String[] stringArray;

    private List<Integer> integerList;

    // Getters for primitive types
    public byte getByte() {
        return aByte;
    }

    public short getShort() {
        return aShort;
    }

    public int getInt() {
        return anInt;
    }

    public long getLong() {
        return aLong;
    }

    public float getFloat() {
        return aFloat;
    }

    public double getDouble() {
        return aDouble;
    }

    public boolean isBoolean() {
        return aBoolean;
    } // Using `is` for boolean getters

    public char getChar() {
        return aChar;
    }

    // Getter for String
    public String getString() {
        return aString;
    }

    // Getters for arrays (returning a copy to avoid modification)
    public int[] getIntArray() {
        return intArray.clone();
    }

    public String[] getStringArray() {
        return stringArray.clone();
    }

    // Getter for List (returning the actual list, be cautious of modification)
    public List<Integer> getIntegerList() {
        return integerList;
    }

    // Constructor (optional, for setting initial values)
    public DataHolder(byte aByte, short aShort, int anInt, long aLong, float aFloat, double aDouble, boolean aBoolean, char aChar, String aString, int[] intArray, String[] stringArray, List<Integer> integerList) {
        this.aByte = aByte;
        this.aShort = aShort;
        this.anInt = anInt;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
        this.aBoolean = aBoolean;
        this.aChar = aChar;
        this.aString = aString;
        this.intArray = intArray;
        this.stringArray = stringArray;
        this.integerList = integerList;
    }
}

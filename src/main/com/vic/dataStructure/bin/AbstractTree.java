package com.vic.dataStructure.bin;

public abstract class AbstractTree {
    public int count = 0;

    public abstract Node find(int value);

    public abstract boolean insert(int value);

    public abstract boolean delete(int value);

    public int getCount() {
        return this.count;
    }

}

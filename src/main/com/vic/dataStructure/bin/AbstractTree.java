package com.vic.dataStructure.bin;

import java.util.List;

public abstract class AbstractTree {
    public int count = 0;

    public abstract Node find(int value);

    public abstract boolean insert(int value);

    public abstract boolean delete(int value);

    public int getCount() {
        return this.count;
    }

    public abstract List<Integer> preOrderStack(Node tree);
    public abstract List<Integer> preOrderRecursion(Node tree);
    public abstract List<Integer> inOrderStack(Node tree);
    public abstract List<Integer> inOrderRecursion(Node tree);
    public abstract List<Integer> afterOrderStack(Node tree);
    public abstract List<Integer> afterOrderRecursion(Node tree);
}

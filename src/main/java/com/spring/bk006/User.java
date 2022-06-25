package com.spring.bk006;

public class User {
    private String lmyName;
    private int lmyId;


    public String getLmyName() {
        return lmyName;
    }

    public void setLmyName(String lmyName) {
        this.lmyName = lmyName;
    }

    public int getLmyId() {
        return lmyId;
    }

    public void setLmyId(int lmyId) {
        this.lmyId = lmyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "lmyName='" + lmyName + '\'' +
                ", lmyId=" + lmyId +
                '}';
    }
}

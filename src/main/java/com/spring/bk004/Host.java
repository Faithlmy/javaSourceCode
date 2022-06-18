package com.spring.bk004;

public class Host implements Rent{
    @Override
    public void rent(String address) {
        System.out.println("出租位于"+address+"处的房屋");
    }

    @Override
    public void buyFurniture() {
        System.out.println("添置家具");
    }

}

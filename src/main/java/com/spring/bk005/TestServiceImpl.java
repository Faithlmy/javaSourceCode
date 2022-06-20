package com.spring.bk005;

public class TestServiceImpl implements ITestService{
    @Override
    public void testSave() {
        System.out.println("保存方法执行");
    }

    @Override
    public void testUpdate() {
        System.out.println("更新方法执行");
    }
}

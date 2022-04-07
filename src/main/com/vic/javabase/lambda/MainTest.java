package com.vic.javabase.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 0000
 */
public class MainTest {
    public static void main(String[] args) {
        TestSuplier testSuplier = new TestSuplier();
        testSuplier.test2();
    }

}

/******************************ConsumerInterface**********start*******************************************************/

@FunctionalInterface
interface ConsumerInterface<T>{
    void accept(T t);
}

class  TestStream<T> {
    private List<T> list;

    public void setList(List list){
        this.list = list;
    }

    public void myForEach(ConsumerInterface<T> consumer) {// 1
        for (T t : list) {
            consumer.accept(t);
        }
    }
}

class  TestStreamMain{
    public  void testMain(){
        TestStream<String> stream = new TestStream<String>();
        List list = Arrays.asList("11", "22", "33");
        stream.setList(list);
        stream.myForEach(str -> System.out.println(str));// 使用自定义函数接口书写Lambda表达式
    }
}
/******************************ConsumerInterface**********END*******************************************************/

/******************************Supplier**********start*******************************************************/

class TestSuplier{

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
    public void test2(){
        List list = Arrays.asList(121, 1231, 455, 56, 67,78);
        List<Integer> numList = getNumList(1, () -> (int)(Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

}



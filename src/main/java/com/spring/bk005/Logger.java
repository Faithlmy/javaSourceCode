package com.spring.bk005;


public class Logger {
    /**
     * 用于打印日志信息，计划让其在切入点方法执行之前执行
     */
    public void printLogBefore(){
        System.out.println("前置日志打印");
    }

    /**
     * 用于打印日志信息，计划让其在切入点方法执行之后执行
     */
    public void printLogAfter(){
        System.out.println("后置日志打印");
    }

    /**
     * 用于打印日志信息，计划让其在切入点方法执行结束并返回后执行
     */
    public void printLogReturn(){
        System.out.println("后置返回日志打印");
    }

    /**
     * 用于打印日志信息，计划让其在切入点方法执行异常后执行
     */
    public void printLogThrow(){
        System.out.println("异常日志打印");
    }

    /**
     * 环绕通知
     * 在环绕通知中 需要我们有明确的切入点方法的调用否则切人点方法不会执行
     * 前置、后置、返回、异常通知也都需要我们自己去写
     * 在spring中框架为我们提供了一个接口：ProceedingJoinPoint,该接口有一个方法proceed（）
     * 此方法就相当于明确的调用切入点方法，该接口可以作为环绕统治的方法参数，在程序执行时
     * spring框架会为我们提供接口的实现类供我们使用
     * 环绕通知 可以用来计算切人点方法执行时间 很香的！！！
     */
    public Object printLogAround(ProceedingJoinPoint proceedingJoinPoint){
        Object retValue = null;
        try {
            System.out.println("前置通知执行");
            //获取参数
            Object[] args = proceedingJoinPoint.getArgs();
            //执行切点方法
            retValue = proceedingJoinPoint.proceed(args);
            System.out.println("后置通知执行");
            return retValue;
            /**
             * 注意：此处不可以用Exception来捕获 他捕获不住
             * 因为proceedingJoinPoint.proceed(args);
             * 抛出的是Throwable
             */

        }catch (Throwable throwable){
            System.out.println("异常通知执行");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知执行");
        }
    }
}

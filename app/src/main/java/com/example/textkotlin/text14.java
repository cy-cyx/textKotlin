package com.example.textkotlin;

/**
 * java 泛类
 */
public class text14<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * <\? extends T> 接受包括他的子类
     * <\? super T> 接受包括他的父类
     */
    public void copy(text14<? extends T> src, text14<? super T> dst) {
        dst.setT(src.getT());
    }

    // 为了同一个文件用静态内部类
    public static class text14_1<T extends cla2> {
        T a;
    }
}

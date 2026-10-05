package com.itextpdf.text.log;

/* JADX INFO: loaded from: classes3.dex */
public class CounterFactory {
    private static CounterFactory myself = new CounterFactory();
    private Counter counter = new DefaultCounter();

    private CounterFactory() {
    }

    public static Counter getCounter(Class<?> cls) {
        return myself.counter.getCounter(cls);
    }

    public static CounterFactory getInstance() {
        return myself;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter() {
        return this.counter;
    }
}

package org.example;

public interface Pool<T> {
    T acquire();
    void release(T t);
}

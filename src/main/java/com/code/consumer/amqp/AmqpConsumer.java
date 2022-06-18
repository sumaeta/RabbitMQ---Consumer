package com.code.consumer.amqp;

public interface AmqpConsumer<T> {
    void consumer(T t);
}

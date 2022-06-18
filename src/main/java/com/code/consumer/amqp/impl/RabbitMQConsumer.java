package com.code.consumer.amqp.impl;

import com.code.consumer.amqp.AmqpConsumer;
import com.code.consumer.dto.Message;
import com.code.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    @Autowired
    private ConsumerService service;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(Message message) {
        try {
            service.action(message);
        }catch (Exception e){
            //Se ocorrer erro, a exception AmqpRejectAndDontRequeueException joga na deadletter
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }
}

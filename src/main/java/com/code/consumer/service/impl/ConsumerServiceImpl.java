package com.code.consumer.service.impl;

import com.code.consumer.dto.Message;
import com.code.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(Message message) throws Exception{
        System.out.println(message.getText());
    }
}

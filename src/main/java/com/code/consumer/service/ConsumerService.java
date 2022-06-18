package com.code.consumer.service;

import com.code.consumer.dto.Message;

public interface ConsumerService {

    void action(Message message) throws Exception;
}

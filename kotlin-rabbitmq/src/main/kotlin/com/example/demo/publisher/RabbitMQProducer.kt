package com.example.demo.publisher

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitMQProducer(
    @Autowired
    val rabbitTemplate: RabbitTemplate,

    @Value("\${rabbitmq.exchange.name}")
    var exchange: String,

    @Value("\${rabbitmq.routing.key}")
    var routingKey: String
) {


    fun sendMessage(message: Any) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
       // rabbitTemplate.
    }
}
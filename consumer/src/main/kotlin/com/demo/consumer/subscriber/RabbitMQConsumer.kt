package com.demo.consumer.subscriber

import com.demo.consumer.dto.WorkCenters
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitMQConsumer(

    @Autowired
    val rabbitTemplate: RabbitTemplate,

    /*@Value("\${rabbitmq.queue.name}")
    val queue: String,

    @Value("\${rabbitmq.exchange.name}")
    var exchange: String,

    @Value("\${rabbitmq.routing.key}")
    var routingKey: String*/
) {

    @RabbitListener(queues = ["queue_demo_message"], id = "listener")
    fun receive(message: String) {
        print("---------------MESSAGE RECEIVE----------------")
        println(message)
        val mapper = jacksonObjectMapper()
        // list of workcenter
        val workCenter: WorkCenters = mapper.readValue(message,WorkCenters::class.java)
        print("size of whatever received:: "+workCenter.workCenterList.size)
    }

}
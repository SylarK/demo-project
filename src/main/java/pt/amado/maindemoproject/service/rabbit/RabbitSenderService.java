package pt.amado.maindemoproject.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pt.amado.maindemoproject.entity.Employee;

@Service
public class RabbitMQSenderService {

    private AmqpTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSenderService(AmqpTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${data.rabbitmq.exchange}")
    private String exchange;
    @Value(value = "${data.rabbitmq.routing-key}")
    private String routingKey;

    public void send(Employee company){
        rabbitTemplate.convertAndSend(exchange, routingKey, company);
        System.out.println("Send msg = " + company);
    }
}

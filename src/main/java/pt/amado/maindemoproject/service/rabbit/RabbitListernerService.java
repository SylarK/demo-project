package pt.amado.maindemoproject.service.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitListernerService implements MessageListener {

    public void onMessage(Message message){
        System.out.println("Consuming message - " + new String(message.getBody()));
    }

}

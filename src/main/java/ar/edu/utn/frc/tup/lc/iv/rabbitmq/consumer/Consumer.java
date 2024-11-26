package ar.edu.utn.frc.tup.lc.iv.rabbitmq.consumer;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Address;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    /**
     * This decorator allows passing a list of queue names that the consumer will be listening to.
     */
    @RabbitListener(queues = { "${tpi.queue.name}" })
    public void receive(@Payload Message msj) throws IOException {
      log.info("Message Received: {}", msj);
      RabbitMessage<Address> rabbitMessage = objectMapper.readValue(
              msj.getBody(),
              new TypeReference<RabbitMessage<Address>>() { }
      );
      log.info("HEADERS: {}", msj.getMessageProperties().getHeaders());
      log.info("DATA: {}", rabbitMessage.toString());
      sleep();
    }

    /**
     * Timeout period for attempting to read the queue, preventing potential API crashes due to overload.
     */
    private void sleep(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

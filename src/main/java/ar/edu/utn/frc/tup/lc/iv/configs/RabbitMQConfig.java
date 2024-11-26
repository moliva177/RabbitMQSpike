package ar.edu.utn.frc.tup.lc.iv.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RabbitMQConfig {

    /**
     * Queue configuration where we will publish.
     */
    @Value("${tpi.queue.name}")
    private String queueName;

    /**
     * The queue is created as an object.
     */
    @Bean
    public Queue queue(){
        return  new Queue(queueName, true);
    }

    /**
     * The necessary classes are configured to perform message serialization.
     */
    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("java.util.LinkedHashMap",
                "java.util.HashMap",
                "java.time.Ser",
                "java.util.ArrayList",
                "ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage"));
        return converter;
    }
}

package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService
{
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息到kafka
     */
    public void sendChannelMess(String channel, String message)
    {
        kafkaTemplate.send(channel, message);
    }

    @KafkaListener(topics = {"seckill"})
    public void receiveMessage(String message)
    {
        System.out.println(message);
    }
}

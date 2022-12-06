package com.example.kinokorme.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kinokorme", groupId = "groupId")
    void listener(String data) {
        System.out.println("Movie with id: " + data + " successfully deleted 🎉");
    }
}

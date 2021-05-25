package com.beilie.test.config;

import com.beilie.core.logging.config.AbstractCustomPipeConfigurer;
import com.beilie.core.logging.config.CustomPipe;
import com.beilie.core.logging.config.CustomPipeRegistry;
import com.beilie.core.logging.config.EnableCustomLogging;
import com.beilie.core.message.MessageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@EnableCustomLogging
@Configuration
public class CustomLoggingConfiguration extends AbstractCustomPipeConfigurer {
    public class KafkaPipe implements CustomPipe {
        private KafkaTemplate<String, String> kafkaTemplate;

        public KafkaPipe(KafkaTemplate<String, String> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        @Override
        public void push(MessageItem source) {
            this.kafkaTemplate.send("com-beilie-logging", source.toJson());
        }
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void config(CustomPipeRegistry registry) {
        registry.register(new KafkaPipe(this.kafkaTemplate));
    }
}

package com.wr.movies.config;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJcaListenerContainerFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import javax.jms.ConnectionFactory;
import java.awt.*;

@Configuration
public class JMSConfiguration {

    //para filas
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer,
                                                    JmsErrorHandler jmsErrorHandler){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setErrorHandler(jmsErrorHandler);
        configurer.configure((factory, connectionFactory));
        return factory;
    }

    //para topicos
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory,
                                                               DefaultJmsListenerContainerFactoryConfigurer configurer,){
       DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
       factory.setPubSubDomain(true);
       configurer.configure(factory, connectionFactory);
       return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdProperTyName("_type");
        return converter;
    }
}

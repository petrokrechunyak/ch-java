package org.example.hibernate;

import org.example.hibernate.config.HibernateConfig;
import org.example.hibernate.model.Chat;
import org.example.hibernate.model.ChatUser;
import org.example.hibernate.model.Message;
import org.example.hibernate.model.User;
import org.example.hibernate.service.ChatService;
import org.example.hibernate.service.ChatUserService;
import org.example.hibernate.service.MessageService;
import org.example.hibernate.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    private static ChatService chatService;
    private static UserService userService;
    private static ChatUserService chatUserService;
    private static MessageService messageService;


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        getServices(context);

    }

    private static void getServices(ApplicationContext context){
        chatService = context.getBean(ChatService.class);
        userService = context.getBean(UserService.class);
        chatUserService = context.getBean(ChatUserService.class);
        messageService = context.getBean(MessageService.class);
    }
}

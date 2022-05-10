package org.example.hibernate;

import net.bytebuddy.utility.RandomString;
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


        Chat chat = new Chat("other chat");
        User user = new User("username1", "password2");


        chatUserService.save(new ChatUser(
                userService.save(user),
                chatService.save(chat))
        );

        ChatUser chatUser = new ChatUser(
                user,
                chatService.save(new Chat("some title")));
        chatUserService.save(chatUser);

        ChatUser chatUser_2 = new ChatUser(
                userService.save(new User("some username", "some password")),
                chat);
        chatUserService.save(chatUser_2);


        messageService.save(new Message(
                "some text",
                chatUser
        ));

        chatUserService.save(new ChatUser(
                user,
                chat
        ));
    }

    private static void getServices(ApplicationContext context){
        chatService = context.getBean(ChatService.class);
        userService = context.getBean(UserService.class);
        chatUserService = context.getBean(ChatUserService.class);
        messageService = context.getBean(MessageService.class);
    }
}

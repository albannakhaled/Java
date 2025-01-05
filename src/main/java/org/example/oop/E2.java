package org.example;

public class E2 {
    public static void main(String[] args) {
        String type = "sms";
        SendMessage byEmail = new SendByEmail();
        SendMessage bySms = new SendBySms();

        MessageServiceFactory.getMessageService(type).sendMessage("hello khaled");// using factory pattern

        SendMessage sendMessage = MessageServiceFactory.getMessageService(type); // sendMessage --> instance of SendByEmail || ---> instance of SendBySms
        NotificationSender sender = new NotificationSender(sendMessage);
        sender.send("hello using DI");
        

    }
}
interface SendMessage{
    void sendMessage(String message);
}

class SendByEmail implements SendMessage{

    @Override
    public void sendMessage(String message) {
        System.out.println("You're message send it by Email is "+message);
    }
}
class SendBySms implements SendMessage{

    @Override
    public void sendMessage(String message) {
        System.out.println("You're message send it by SMS is "+message);
    }
}

class MessageServiceFactory {
    public static SendMessage getMessageService(String type) {
        if ("email".equalsIgnoreCase(type)) {
            return new SendByEmail();
        } else if ("sms".equalsIgnoreCase(type)) {
            return new SendBySms();
        }
        throw new IllegalArgumentException("Unknown service type");
    }
}

class NotificationSender {
    private final SendMessage sendMessage;

    public NotificationSender(SendMessage messageService) {
        this.sendMessage = messageService;
    }

    public void send(String message) {
        sendMessage.sendMessage(message);
    }
}


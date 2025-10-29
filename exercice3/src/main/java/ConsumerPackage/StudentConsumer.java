package ConsumerPackage;

import com.rabbitmq.client.*;

public class StudentConsumer {


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        System.out.println("Étudiant : en attente de notifications...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Notification [Étudiant] : " + message);
        };
        channel.basicConsume("studentQueue", true, deliverCallback, consumerTag -> {});
    }
}

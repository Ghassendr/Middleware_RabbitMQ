package ConsumerPackage;

import com.rabbitmq.client.*;

public class AdminConsumer {


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        System.out.println("Administration : en attente de notifications...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Notification [Administration] : " + message);
        };
        channel.basicConsume("adminQueue", true, deliverCallback, consumerTag -> {});
    }
}

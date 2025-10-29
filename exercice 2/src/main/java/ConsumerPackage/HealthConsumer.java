package ConsumerPackage;

import com.rabbitmq.client.*;

public class HealthConsumer {


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        System.out.println("Ministere de la Sante : en attente dannonces...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Annonce reçue [Santé] : " + message);
        };
        channel.basicConsume("healthQueue", true, deliverCallback, consumerTag -> {});
    }
}

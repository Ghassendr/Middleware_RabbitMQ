package ConsumerPackage;

import com.rabbitmq.client.*;

public class EducationConsumer {


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        System.out.println("Ministère de l’Éducation : en attente d’annonces...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Annonce reçue [Éducation] : " + message);
        };
        channel.basicConsume("educationQueue", true, deliverCallback, consumerTag -> {});
    }
}

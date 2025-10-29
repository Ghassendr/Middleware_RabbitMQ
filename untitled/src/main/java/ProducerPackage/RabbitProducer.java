package ProducerPackage;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class RabbitProducer {
    private static final String QUEUE_NAME = "Welcome-Queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "Bienvenue sur RabbitMQ !";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Message envoyé : '" + message + "'");
        }
    }
}

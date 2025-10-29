package ConfigPackage;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class BrokerConfigs {
    private static final String QUEUE_NAME = "Welcome-Queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // RabbitMQ doit être démarré sur ta machine

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Déclaration de la file d’attente
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Queue '" + QUEUE_NAME + "' déclarée avec succès.");
        }
    }
}

package ConfigPackage;

import com.rabbitmq.client.*;

public class BrokerConfigs {
    private static final String EXCHANGE_NAME = "governmentExchange";
    private static final String QUEUE_HEALTH = "healthQueue";
    private static final String QUEUE_EDUCATION = "educationQueue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {


            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, false, false, null);


            channel.queueDeclare(QUEUE_HEALTH, false, false, false, null);
            channel.queueDeclare(QUEUE_EDUCATION, false, false, false, null);


            channel.queueBind(QUEUE_HEALTH, EXCHANGE_NAME, "");
            channel.queueBind(QUEUE_EDUCATION, EXCHANGE_NAME, "");

            System.out.println("Configuration RabbitMQ terminée avec succès.");
        }
    }
}

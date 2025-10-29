package ConfigPackage;
import com.rabbitmq.client.*;
public class BrokerConfigs {
    private static final String EXCHANGE_NAME = "universityExchange";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {


            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, null);


            channel.queueDeclare("studentQueue", false, false, false, null);
            channel.queueDeclare("teacherQueue", false, false, false, null);
            channel.queueDeclare("adminQueue", false, false, false, null);


            channel.queueBind("studentQueue", EXCHANGE_NAME, "student");
            channel.queueBind("teacherQueue", EXCHANGE_NAME, "teacher");
            channel.queueBind("adminQueue", EXCHANGE_NAME, "admin");

            System.out.println("Configuration RabbitMQ terminée avec succès !");
        }
    }
}

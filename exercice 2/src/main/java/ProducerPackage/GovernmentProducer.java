package ProducerPackage;

import com.rabbitmq.client.*;

public class GovernmentProducer {


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "New National Vaccination Campaign in Schools";
            channel.basicPublish("governmentExchange", "", null, message.getBytes("UTF-8"));
            System.out.println("Annonce envoyée : '" + message + "'");
        }
    }
}

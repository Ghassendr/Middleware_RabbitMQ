package ProducerPackage;

import com.rabbitmq.client.*;

public class NotificationProducer {
    private static final String EXCHANGE_NAME = "universityExchange";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {


            String message1 = "Exam schedule released!";
            String message2 = "Teacher meeting at 10 AM.";
            String message3 = "Administrative system update.";

            channel.basicPublish(EXCHANGE_NAME, "student", null, message1.getBytes("UTF-8"));
            System.out.println("Message envoyé aux étudiants : " + message1);

            channel.basicPublish(EXCHANGE_NAME, "teacher", null, message2.getBytes("UTF-8"));
            System.out.println("Message envoyé aux enseignants : " + message2);

            channel.basicPublish(EXCHANGE_NAME, "admin", null, message3.getBytes("UTF-8"));
            System.out.println("Message envoyé à l’administration : " + message3);
        }
    }
}

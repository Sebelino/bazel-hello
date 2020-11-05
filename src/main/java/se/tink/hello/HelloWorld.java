package se.tink.hello;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {

        AmazonSQS sqs = AmazonSQSClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_1)
                .build();

        ListQueuesResult result = sqs.listQueues();
        System.out.println("Listing queues:");
        for (String url : result.getQueueUrls()) {
            System.out.println("URL = " + url);
        }

        String endpoint = "https://sqs.eu-west-1.amazonaws.com/015661541584/myqueue3";

        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(endpoint)
                .withMessageBody("hello world")
                .withDelaySeconds(5);

        SendMessageResult sendResult = sqs.sendMessage(request);

        System.out.println("RESULT = " + sendResult);

        System.exit(0);

        for (int i = 0; i < 3; i++) {
            System.out.println("hoyworld");
            Thread.sleep(1000);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

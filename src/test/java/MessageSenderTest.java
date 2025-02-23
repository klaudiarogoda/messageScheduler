import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MessageSenderTest {

    @Test
    public void messageService_sendTestMessage() {
        MessageService service = new MessageService();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        service.sendMessage("Test");

        String output = baos.toString();
        assertTrue(output.contains("Message sent"));
    }

    @Test
    public void messageScheduler_randomMessage_selectsRandom() {
        MessageService service = new MessageService();
        String[] messagesTest = {"Test1", "Test2", "Test3", "Test4", "Test5"};
        MessageScheduler scheduler = new MessageScheduler(service, messagesTest);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            set.add(scheduler.randomMessage());
        }

        assertTrue(set.size() > 1);
    }

    @Test
    public void messageScheduler_randomMessage_selectsFromList() {
        MessageService service = new MessageService();
        String[] messagesTest = {"Test1", "Test2", "Test3", "Test4", "Test5"};
        MessageScheduler scheduler = new MessageScheduler(service, messagesTest);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            set.add(scheduler.randomMessage());
        }

        for (String s : set) {
            assertTrue(Arrays.asList(messagesTest).contains(s));
        }
    }
}

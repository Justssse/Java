package desin;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("send SMS");
    }
}

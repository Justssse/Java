package desin;

public class SmsFactory implements Provider {
    @Override
    public Sender provide() {
        return new SmsSender();
    }
}

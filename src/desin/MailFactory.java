package desin;

public class MailFactory implements Provider {
    @Override
    public Sender provide() {
        return new MailSender();
    }
}

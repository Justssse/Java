package desin;

/**
 * 简单静态工厂
 */
public class SimpleFactory {

    static Sender produceMail(){
        return new MailSender();
    }

    static Sender produceSms(){
        return new SmsSender();
    }

}

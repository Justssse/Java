package desin;

public class Test {

    public static void main(String[] args) {
        //简单工厂
        Sender sender1 = SimpleFactory.produceSms();
        Sender sender2 = SimpleFactory.produceMail();
        sender1.send();
        sender2.send();

        //抽象工厂
        Provider provider1 = new MailFactory();
        Provider provider2 = new SmsFactory();
        Sender sender3 = provider1.provide();
        Sender sender4 = provider2.provide();
        sender3.send();
        sender4.send();
    }

}

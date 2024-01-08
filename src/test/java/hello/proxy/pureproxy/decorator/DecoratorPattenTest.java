package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPattenTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPattenClient decoratorPattenClient = new DecoratorPattenClient(realComponent);
        decoratorPattenClient.execute();
    }

    @Test
    void Decorator1() {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPattenClient decoratorPattenClient = new DecoratorPattenClient(messageDecorator);
        decoratorPattenClient.execute();
    }

    @Test
    void Decorator2() {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPattenClient decoratorPattenClient = new DecoratorPattenClient(timeDecorator);
        decoratorPattenClient.execute();
    }
}

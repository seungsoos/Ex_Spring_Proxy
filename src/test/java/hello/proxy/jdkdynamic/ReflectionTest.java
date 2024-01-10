package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0(){
        Hello target = new Hello();

        //공통로직 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result ={}", result1);
        //공통로직 종료

        // 공통로직 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result ={}", result2);
        //공통로직 종료
    }

    @Test
    void reflection1() throws Exception{
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();
        Method callA = classHello.getMethod("callA");
        Object result1 = callA.invoke(target);
        log.info("result = {}", result1);

        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(target);
        log.info("result = {}", result2);
    }

    @Test
    void reflection2() throws Exception{
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();
        Method callA = classHello.getMethod("callA");
        dynamicCall(callA, target);

        Method callB = classHello.getMethod("callB");
        dynamicCall(callB, target);
    }



    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }




    @Slf4j
    static class Hello{
        public String callA() {
            log.info("callA");
            return "A";
        }
        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}

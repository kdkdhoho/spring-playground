package test.beanscope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.TestApplication;
import test.beanscope.OtherSingletonObject;
import test.beanscope.PrototypeObject;
import test.beanscope.SingletonObject;

@SpringBootTest
public class PrototypeTest {

    private final ApplicationContext context = new AnnotationConfigApplicationContext(TestApplication.class);

    @Test
    @DisplayName("Container에 올라간 프로토타입 빈이 프로토타입 빈인지 확인한다.")
    void isPrototypeObjectPrototypeBean() {
        boolean isPrototype = context.isPrototype("prototypeObject");
        boolean isSingleton = context.isSingleton("prototypeObject");

        System.out.println("isPrototype = " + isPrototype);
        System.out.println("isSingleton = " + isSingleton);

        assertThat(isPrototype).isTrue();
        assertThat(isSingleton).isFalse();
    }

    @Test
    @DisplayName("ApplicationContext에서 프로토타입 빈을 2번 요청하고 이 둘을 비교한다")
    void differentInstancePrototypeBean() {
        PrototypeObject prototypeObject1 = context.getBean("prototypeObject", PrototypeObject.class);
        PrototypeObject prototypeObject2 = context.getBean("prototypeObject", PrototypeObject.class);

        System.out.println(prototypeObject1 + " // " + prototypeObject2);
        assertThat(prototypeObject1).isNotEqualTo(prototypeObject2);
    }

    @Test
    @DisplayName("두 개의 다른 타입의 싱글톤 객체 내에 프로토타입 객체가 있을 때 이 두 프로토타입 객체를 비교한다")
    void showPrototypeScope() {
        SingletonObject singletonObject = context.getBean("singletonObject", SingletonObject.class);
        System.out.println("singletonObject = " + singletonObject);
        System.out.println("singletonObject.getPrototypeObject() = " + singletonObject.getPrototypeObject());

        System.out.println();
        OtherSingletonObject otherSingletonObject = context.getBean("otherSingletonObject", OtherSingletonObject.class);
        System.out.println("otherSingletonObject = " + otherSingletonObject);
        System.out.println("otherSingletonObject.getPrototypeObject() = " + otherSingletonObject.getPrototypeObject());

        assertThat(singletonObject.getPrototypeObject()).isNotEqualTo(otherSingletonObject.getPrototypeObject());
    }
}

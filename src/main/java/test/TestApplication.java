package test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.config.AppConfig;
import test.order.OrderService;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
//        SpringApplication.run(TestApplication.class);
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean(OrderService.class);

        System.out.println("orderService = " + orderService);
    }
}

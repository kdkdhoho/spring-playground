package test;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.config.AppConfig;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ApplicationContextInfoTest {
    private final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 모든_빈_출력하기() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = ac.getBean(beanName);
            System.out.println("name = " + beanName + " object = " + bean);
        }
    }

    @Test
    void 애플리케이션_빈_출력하기() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + beanDefinitionName + " || beanDefinition = " + beanDefinition);
            }
        }
    }
}

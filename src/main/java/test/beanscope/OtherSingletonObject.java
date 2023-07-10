package test.beanscope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class OtherSingletonObject {

    private final PrototypeObject prototypeObject;
}

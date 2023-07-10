package test.beanscope;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.beanscope.SingletonObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@AllArgsConstructor
public class TestController {

    private final SingletonObject singletonObject;

    @GetMapping("/show")
    @ResponseBody
    public String show() {
        return "singletonObject = " + singletonObject.toString() + "\n" +
                "protoTypeObject = " + singletonObject.getPrototypeObject().toString() + "\n" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"));
    }
}

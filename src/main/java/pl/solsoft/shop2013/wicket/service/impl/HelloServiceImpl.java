package pl.solsoft.shop2013.wicket.service.impl;

import org.springframework.stereotype.Service;
import pl.solsoft.shop2013.wicket.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    public String getHelloWorldMsg() {
        return "Spring : hello world";
    }

}

package servertest.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan("servertest.demo")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

}

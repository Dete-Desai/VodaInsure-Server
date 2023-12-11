package io.springboot.vodainsure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
      @GetMapping("/hi")
    public String hi(){
        return "hiiiiiii";
    }
}

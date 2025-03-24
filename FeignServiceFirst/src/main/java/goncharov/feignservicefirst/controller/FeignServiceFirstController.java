package goncharov.feignservicefirst.controller;

import goncharov.feignservicefirst.client.Service2Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignServiceFirstController {
    @Autowired
    private Service2Client service2Client;

    @GetMapping("/call-other-service")
    @CircuitBreaker(name = "service2", fallbackMethod = "fallbackMethod")
    public String callOtherService() {
        return service2Client.callService2();
    }

    public String fallbackMethod(Throwable t) {
        return "Resilience4j Fallback: Service2 is down - " + t.getMessage();
    }
}

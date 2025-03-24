package goncharov.feignservicefirst.client;

import goncharov.feignservicefirst.Service2Fallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "SERVICE2", fallback = Service2Fallback.class)
public interface Service2Client {
    @GetMapping("/hello")
    String callService2();
}

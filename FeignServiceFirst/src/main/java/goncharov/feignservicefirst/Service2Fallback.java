package goncharov.feignservicefirst;

import goncharov.feignservicefirst.client.Service2Client;

public class Service2Fallback implements Service2Client {
    @Override
    public String callService2() {
        return "Service2 is unavailable - Fallback response";
    }
}

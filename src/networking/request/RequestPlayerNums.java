package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import networking.response.ResponsePlayerNums;

public class RequestPlayerNums extends GameRequest {
    // Responses
    private final ResponsePlayerNums responsePlayerNums;

    public RequestPlayerNums() {
        responses.add(responsePlayerNums = new ResponsePlayerNums());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
    }
}

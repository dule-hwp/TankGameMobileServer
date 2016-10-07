package networking.response;

// Other Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseTest extends GameResponse {
    
    private int result;

    public ResponseTest() {
        responseCode = Constants.SMSG_TEST;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(getResult());
        System.out.println("test");
        System.out.println(getResult());
        return packet.getBytes();
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }
}

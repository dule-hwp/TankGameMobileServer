package networking.response;

// Other Imports
import java.nio.ByteBuffer;
import metadata.Constants;
import model.Player;
import utility.GamePacket;

/**
 * The ResponseLogin class contains information about the authentication
 * process.
 */
public class ResponseLogin extends GameResponse {

    private short status;
    private Player player;

    public ResponseLogin() {
        responseCode = Constants.SMSG_AUTH;
    }

    @Override
    public byte[] constructResponseInBytes() {
        byte[] playerBytes = player.toBytes();
        byte[] resultBytesArray = ByteBuffer.allocate(playerBytes.length+4)
                .putShort((short) (playerBytes.length+2))
                .putShort(responseCode)
                .put(playerBytes)
                .array();
        return resultBytesArray;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

package networking.response;

// Other Imports
import core.GameServer;
import metadata.Constants;
import utility.GamePacket;

public class ResponsePlayerNums extends GameResponse {

    public ResponsePlayerNums() {
//        responseCode = Constants.SMSG_PLAYER_NUMS;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(GameServer.getInstance().getActivePlayers().size());
        return packet.getBytes();
    }
}

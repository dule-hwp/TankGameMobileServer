package networking.request;

// Java Imports
import core.GameServer;
import java.awt.Point;
import java.io.IOException;
import model.Player;

// Other Imports

/**
 * The RequestHeartbeat class is mainly used to release all pending responses
 * the client. Also used to keep the connection alive.
 */
public class RequestPlayerUpdate extends GameRequest {
    private Player mPlayer;
//    private ArrayList<Bullet>  mBullets;

    public RequestPlayerUpdate() {
    }

    @Override
    public void parse() throws IOException {
        mPlayer = new Player();
        mPlayer.fromDataInputStream(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Player activePlayer = GameServer.getInstance().getActivePlayer(mPlayer.getID());
        activePlayer.setPlayerData(mPlayer);
    }
}

package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import core.GameClient;
import core.GameServer;
import java.awt.Point;
import model.Player;
import networking.response.ResponseLogin;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */
public class RequestLogin extends GameRequest {

    // Data
//    private String version;
//    private int user_id;
//    private String password;
    // Responses
    private ResponseLogin responseLogin;
    Player mPlayer;

    public RequestLogin() {
        responses.add(responseLogin = new ResponseLogin());
    }

    @Override
    public void parse() throws IOException {
        mPlayer = new Player();
        mPlayer.fromDataInputStream(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("User '%s' is connecting...", mPlayer.getID());

        Player player = GameServer.getInstance().getActivePlayer(mPlayer.getID());
        // Checks if the connecting client meets the minimum version required
//        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
        if (mPlayer.getID() == -1 && player == null) {
            // Verification Needed
            player = new Player(GameServer.getInstance().getActivePlayers().size()); // just hard coded
            player.setPlayerData(mPlayer);
        }

        if (player == null) {
            responseLogin.setStatus((short) 1); // User info is incorrect
            Log.printf("User '%s' has failed to log in.", mPlayer.getID());
        } else {
            if (client.getPlayer() == null || player.getID() != client.getPlayer().getID()) {
                GameClient thread = GameServer.getInstance().getThreadByPlayerID(player.getID());
                // If account is already in use, remove and disconnect the client
                if (thread != null) {
                    responseLogin.setStatus((short) 2); // Account is in use
                    thread.removePlayerData();
                    thread.newSession();
                    Log.printf("User '%s' account is already in use.", mPlayer.getID());
                } else {
                    // Continue with the login process
                    GameServer.getInstance().setActivePlayer(player);
                    GameServer.getInstance().addUiInfo(player);
                    player.setClient(client);
                    // Pass Player reference into thread
                    client.setPlayer(player);
                    // Set response information
                    responseLogin.setStatus((short) 0); // Login is a success
                    responseLogin.setPlayer(player);

                    Log.printf("User '%d' has successfully logged in.", player.getID());
                }
            }
        }
    }
}

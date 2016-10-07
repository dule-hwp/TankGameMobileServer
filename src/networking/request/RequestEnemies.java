package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import core.GameServer;
import java.util.ArrayList;
import java.util.List;
import model.Player;
import networking.response.ResponseEnemies;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */
public class RequestEnemies extends GameRequest {

    // Data
//    private String version;
//    private int user_id;
//    private String password;
    // Responses
    private ResponseEnemies responseEnemies;
//    Player mPlayer;
    private int playerRequesterID;

    public RequestEnemies() {
        responses.add(responseEnemies = new ResponseEnemies());
    }

    @Override
    public void parse() throws IOException {
        playerRequesterID = dataInput.readInt();
    }

    @Override
    public void doBusiness() throws Exception {
//        Log.printf("User '%s' is connecting...", mPlayer.getID());

        List<Player> players = GameServer.getInstance().getActivePlayers();
        List<Player> enemies = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getID()!=playerRequesterID)
                enemies.add(player);
        }
        responseEnemies.setEnemies(enemies);
//        ArrayList<Bullet> alBullets = new ArrayList<>(GameServer.getInstance().getBullets().values());
//        Iterator<Bullet> iterator = alBullets.iterator();
//        while (iterator.hasNext()) {
//            Bullet next = iterator.next();
//            if (!next.isShow())
//                iterator.remove();
//        }
//        responseEnemies.setBullets(alBullets);
    }
}

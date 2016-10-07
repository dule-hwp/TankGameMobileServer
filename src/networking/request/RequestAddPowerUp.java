package networking.request;

// Java Imports
import core.GameServer;
import core.NetworkManager;
import java.io.IOException;
import java.util.Map;
import metadata.Constants;
import model.PowerUp;
import networking.response.ResponsePowerUp;

// Other Imports
/**
 * The RequestHeartbeat class is mainly used to release all pending responses
 * the client. Also used to keep the connection alive.
 */
public class RequestAddPowerUp extends GameRequest {

//    private Bullet mBullet;
    private PowerUp mPowerUp;
//    private ResponsePowerUp responsePowerUp;
//    private ArrayList<Bullet>  mBullets;

    public RequestAddPowerUp() {
//        responsePowerUp = new ResponsePowerUp();
    }

    @Override
    public void parse() throws IOException {
        mPowerUp = new PowerUp();
        mPowerUp.fromDataInputStream(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Map<Integer, PowerUp> powerUps = GameServer.getInstance().getPowerUps();
//        PowerUp pu = powerUps.get(mPowerUp.getId());
        ResponsePowerUp responsePowerUp;
        if (!powerUps.containsKey(mPowerUp.getId())) {
            mPowerUp.setId(GameServer.getInstance().getNextBulletID());
            powerUps.put(mPowerUp.getId(), mPowerUp);
            responsePowerUp = new ResponsePowerUp(Constants.SMSG_ADD_POWER_UP);
        }
        else{
            responsePowerUp = new ResponsePowerUp(Constants.SMSG_REMOVE_POWER_UP);
        }
        responsePowerUp.setPowerUp(mPowerUp);
        NetworkManager.addResponseForAllOnlinePlayers(-1, responsePowerUp);

    }
}

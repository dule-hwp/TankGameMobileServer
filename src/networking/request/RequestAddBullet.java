package networking.request;

// Java Imports
import core.GameServer;
import core.NetworkManager;
import java.awt.Point;
import java.io.IOException;
import java.util.Map;
import metadata.Constants;
import model.Bullet;
import networking.response.ResponseBullet;

// Other Imports
/**
 * The RequestHeartbeat class is mainly used to release all pending responses
 * the client. Also used to keep the connection alive.
 */
public class RequestAddBullet extends GameRequest {

    private Bullet mBullet;
    private ResponseBullet responseBullet;
//    private ArrayList<Bullet>  mBullets;

    public RequestAddBullet() {
        responseBullet = new ResponseBullet(Constants.SMSG_ADD_BULLET);
    }

    @Override
    public void parse() throws IOException {
        mBullet = new Bullet(dataInput.readInt());
        int x = dataInput.readInt();
        int y = dataInput.readInt();
        mBullet.setLocationPoint(new Point(x, y));
        mBullet.setHeading(dataInput.readFloat());
        short show = dataInput.readShort();
        mBullet.setShow(show == 1);
        mBullet.setOwnerId(dataInput.readInt());
        mBullet.setBulletTypeId(dataInput.readShort());
    }

    @Override
    public void doBusiness() throws Exception {
        Map<Integer, Bullet> bullets = GameServer.getInstance().getBullets();
        Bullet bullet = bullets.get(mBullet.getID());
        if (bullet == null) {
            mBullet.setID(GameServer.getInstance().getNextBulletID());
            bullets.put(mBullet.getID(), mBullet);
            responseBullet.setBullet(mBullet);
//            responses.add(responseBullet);
            NetworkManager.addResponseForAllOnlinePlayers(-1, responseBullet);
        } 

    }
}

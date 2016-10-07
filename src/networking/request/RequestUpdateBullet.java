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
public class RequestUpdateBullet extends GameRequest {

    private Bullet mBullet;
//    private ArrayList<Bullet>  mBullets;

    public RequestUpdateBullet() {
//        responseBullet = new ResponseBullet();
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
    }

    @Override
    public void doBusiness() throws Exception {
        Map<Integer, Bullet> bullets = GameServer.getInstance().getBullets();
        Bullet bullet = bullets.get(mBullet.getID());
        if (bullet != null) {
            if (mBullet.isShow())
                bullet.setBulletData(mBullet);
            else
                bullets.remove(mBullet.getID());
            ResponseBullet rb = new ResponseBullet(Constants.SMSG_UPDATE_BULLET);
            rb.setBullet(mBullet);
            NetworkManager.addResponseForAllOnlinePlayers(-1, rb);  //instead of -1 should be owner of the bullet
        } 

    }
}

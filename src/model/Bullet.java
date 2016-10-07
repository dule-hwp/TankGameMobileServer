package model;

// Other Imports
import core.GameClient;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class Bullet implements INetworkable{

    private int bullet_id;
//    private String username;
//    private String password;
    private Point locationPoint;
    private float heading;
    private boolean show;
//    private GameClient client; // References GameClient instance
    private int mOwnerId;
    private short bulletTypeId;

    public Bullet(int bullet_id) {
        this.bullet_id = bullet_id;
    }

    public int getID() {
        return bullet_id;
    }

    public int setID(int player_id) {
        return this.bullet_id = player_id;
    }

    

//    public GameClient getClient() {
//        return client;
//    }
//
//    public GameClient setClient(GameClient client) {
//        return this.client = client;
//    }

    public Point getLocationPoint() {
        return locationPoint;
    }

    public void setLocationPoint(Point locationPoint) {
        this.locationPoint = locationPoint;
    }

    public float getHeading() {
        return heading;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }
    
    @Override
    public byte[] toBytes()
    {
        byte[] bts = ByteBuffer.allocate(SIZE)
                .putInt(bullet_id)
                .putInt(locationPoint.x)
                .putInt(locationPoint.y)
                .putFloat(heading)
                .putShort((short) (show ? 1 : 0))
                .putInt(mOwnerId)
                .putShort(bulletTypeId)
                .array();
        return bts;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }
    
    public static final int SIZE = 24;
    
    public void setBulletData(Bullet data) {
        heading = data.getHeading();
        locationPoint = data.getLocationPoint();
        mOwnerId = data.getmOwnerId();
        bulletTypeId = data.getBulletTypeId();
    }

    public void setBulletTypeId(short bulletTypeId) {
        this.bulletTypeId = bulletTypeId;
    }

    public short getBulletTypeId() {
        return bulletTypeId;
    }
    
    public void setOwnerId(int readInt) {
        mOwnerId = readInt;
    }

    public int getmOwnerId() {
        return mOwnerId;
    }

    @Override
    public void fromDataInputStream(DataInputStream dataInput) throws IOException {
        
    }
    
    
    
}

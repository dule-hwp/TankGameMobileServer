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
public class Player implements INetworkable{

    private int player_id;
    private String username;
//    private String password;
    private Point locationPoint;
    private float heading;
    private GameClient client; // References GameClient instance
//    private int health;
//    private int score;

    public Player(int player_id) {
        this.player_id = player_id;
    }

    public Player() {
        
    }

    public int getID() {
        return player_id;
    }

    public int setID(int player_id) {
        return this.player_id = player_id;
    }

    

    public GameClient getClient() {
        return client;
    }

    public GameClient setClient(GameClient client) {
        return this.client = client;
    }

    public Point getLocationPoint() {
        return locationPoint;
    }

//    public void setLocationPoint(Point locationPoint) {
//        this.locationPoint = locationPoint;
//    }

    public float getHeading() {
        return heading;
    }

//    public void setHeading(float heading) {
//        this.heading = heading;
//    }
    
    public byte[] toBytes()
    {
        byte[] nameBytes = username.getBytes();
        byte[] bts = ByteBuffer.allocate(SIZE+nameBytes.length+2)
                .putInt(player_id)
                .putInt(locationPoint.x)
                .putInt(locationPoint.y)
                .putFloat(heading)
                .putShort((short) nameBytes.length)
                .put(nameBytes)
                .array();
        return bts;
    }
    private static final int SIZE = 16;
    
    public short getSizeInBytes()
    {
        return (short) (username.getBytes().length+2+SIZE);
    }
    
    @Override
    public void fromDataInputStream(DataInputStream dataInput) throws IOException {
        this.player_id = dataInput.readInt();
        int x = dataInput.readInt();
        int y = dataInput.readInt();
        this.locationPoint = new Point(x, y);
        this.heading = dataInput.readFloat();
        short nameBytesSize = dataInput.readShort();
        byte [] nameBytes = new byte[nameBytesSize];
        dataInput.read(nameBytes);
        username = new String(nameBytes);
//        this.health = dataInput.readInt();
//        this.score = dataInput.readInt();
    }
    
    public void setPlayerData(Player mPlayer) {
        heading = mPlayer.getHeading();
        locationPoint = mPlayer.getLocationPoint();
        username = mPlayer.getUsername();
//        health = mPlayer.getHealth();
//        score = mPlayer.getScore();
    }
    
    

//    public int getScore() {
//        return score;
//    }
//
//    public int getHealth() {
//        return health;
//    }
//
//    public void setHealth(int health) {
//        this.health = health;
//    }

    public String getUsername() {
        return username;
    }

    
    
    
}

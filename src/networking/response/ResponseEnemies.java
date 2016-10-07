package networking.response;

// Other Imports
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import metadata.Constants;
import model.Bullet;
import model.Player;
import utility.GamePacket;

/**
 * The ResponseLogin class contains information about the authentication
 * process.
 */
public class ResponseEnemies extends GameResponse {

//    private short status;
    private List<Player> enemies;
//    private List<Bullet> mBullets;

    public ResponseEnemies() {
        responseCode = Constants.SMSG_ENEMIES;
    }

    @Override
    public byte[] constructResponseInBytes() {
//        short enNum = (short) enemies.size();
//        ByteBuffer resultBytesBuffer;
//        if (enNum == 0) {
//            resultBytesBuffer = ByteBuffer.allocate(6)
//                    .putShort((short)4)
//                    .putShort(responseCode)
//                    .putShort(enNum);
//        } else {
//            short enemiesSizeInBytes = (short) (enNum*enemies.get(0).toBytes().length);
//            resultBytesBuffer = 
//                    ByteBuffer.allocate(enemiesSizeInBytes+6)
//                            .putShort((short) (enemiesSizeInBytes+4))
//                            .putShort(responseCode)
//                            .putShort(enNum);
//            for (Player enemy : enemies) {
//                byte[] playerBytes = enemy.toBytes();
//                resultBytesBuffer.put(playerBytes);
//            }
//        }
        int enemiesBytesSize = 0;
        
        for (Player p:enemies)
        {
            enemiesBytesSize+=p.getSizeInBytes();
        }
        short messageSize = (short) (enemiesBytesSize +4+2);//4 is for two short-s 2 is for response code
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageSize+2);
        byteBuffer.putShort(messageSize);
        byteBuffer.putShort(responseCode);
        byteBuffer.putShort((short) enemies.size());
        for (Player p:enemies)
        {
            byteBuffer.put(p.toBytes());
        }
//        byteBuffer.putShort((short) mBullets.size());
//        for (Bullet b:mBullets)
//        {
//            byteBuffer.put(b.toBytes());
//        }
        return byteBuffer.array();
        
//        return resultBytesBuffer.array();
    }

//    public void setStatus(short status) {
//        this.status = status;
//    }
    public void setEnemies(List<Player> lPlayers) {
        this.enemies = lPlayers;
    }

//    public void setBullets(List<Bullet> values) {
//        mBullets = values;
//    }

}

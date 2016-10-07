/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

import com.sun.jmx.snmp.InetAddressAcl;
import java.nio.ByteBuffer;
import metadata.Constants;
import model.Bullet;
import model.Player;
import utility.NetworkUtil;

/**
 *
 * @author dusan_cvetkovic
 */
public class ResponseBullet extends GameResponse{
//    private short mResponseCode;
    private Bullet mBullet;
    
    public ResponseBullet(short responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public byte[] constructResponseInBytes() {
        byte[] bulletBytes = mBullet.toBytes();
        byte[] resultBytesArray = ByteBuffer.allocate(bulletBytes.length+4)
                .putShort((short) (bulletBytes.length+2))
                .putShort(responseCode)
                .put(bulletBytes)
                .array();
        return resultBytesArray;
//        return NetworkUtil.marshall(mBullet,responseCode);
    }

//    public void setStatus(short status) {
//        this.status = status;
//    }

    public void setBullet(Bullet bullet) {
        this.mBullet = bullet;
    }
    
}

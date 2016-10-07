/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

import model.PowerUp;
import networking.response.GameResponse;
import utility.NetworkUtil;

/**
 *
 * @author dusan_cvetkovic
 */
public class ResponsePowerUp extends GameResponse{
    private PowerUp mPowerUp;

    public ResponsePowerUp(short responseCode) {
        this.responseCode = responseCode;
    }

    public void setPowerUp(PowerUp pu) {
        mPowerUp = pu;
    }

    @Override
    public byte[] constructResponseInBytes() {
//        byte[] bulletBytes = mPowerUp.toBytes();
//        byte[] resultBytesArray = ByteBuffer.allocate(bulletBytes.length+4)
//                .putShort((short) (bulletBytes.length+2))
//                .putShort(responseCode)
//                .put(bulletBytes)
//                .array();
//        return resultBytesArray;
        return NetworkUtil.marshall(mPowerUp, responseCode);
    }
    
}

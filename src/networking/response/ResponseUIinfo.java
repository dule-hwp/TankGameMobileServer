/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.response;

import java.nio.ByteBuffer;
import model.Player;
import model.UiInfo;
import networking.response.ResponseBullet;

/**
 *
 * @author dusan_cvetkovic
 */
public class ResponseUIinfo extends GameResponse{
    private UiInfo mUIInfo;

    public ResponseUIinfo(short resID) {
        responseCode = resID;
    }

    @Override
    public byte[] constructResponseInBytes() {
//        short messageSize = (short) ();//4 is for two short-s 2 is for response code
        ByteBuffer byteBuffer = ByteBuffer.allocate(UiInfo.SIZE+4);
        byteBuffer.putShort((short)(UiInfo.SIZE+2));
        byteBuffer.putShort(responseCode);
        byteBuffer.put(mUIInfo.toBytes());
        return byteBuffer.array();
    }

    public void setUiInfo(UiInfo uiInfo) {
        mUIInfo = uiInfo;
    }
    
}

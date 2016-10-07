/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.nio.ByteBuffer;
import model.INetworkable;

/**
 *
 * @author dusan_cvetkovic
 */
public class NetworkUtil {
    public static byte[] marshall(INetworkable in, short reqCode) {
        byte[] bytes = in==null ? new byte[0] : in.toBytes();
        int msgSize = bytes.length;
        byte[] baToSend = ByteBuffer.allocate(4+msgSize)
                .putShort((short) (msgSize+2))
                .putShort(reqCode)
                .put(bytes)
                .array();
        return baToSend;
    }

    public static byte[] marshall(byte[] bytes, short reqCode) {
        int msgSize = bytes.length;
        byte[] baToSend = ByteBuffer.allocate(4+msgSize)
                .putShort((short) (msgSize+2))
                .putShort(reqCode)
                .put(bytes)
                .array();
        return baToSend;
    }
}

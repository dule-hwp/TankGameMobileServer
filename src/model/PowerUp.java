/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author dusan_cvetkovic
 */
public class PowerUp implements INetworkable{
    private int x;
    private int y;
    private int pickUpIndex;
    private int id;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPickUpIndex() {
        return pickUpIndex;
    }

    public void setPickUpIndex(int pickUpIndex) {
        this.pickUpIndex = pickUpIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public byte[] toBytes() {
        byte[] bts = ByteBuffer.allocate(SIZE)
                .putInt(id)
                .putInt(x)
                .putInt(y)
                .putInt(pickUpIndex)
                .array();
        return bts;
    }
    public static final int SIZE = 16;
    @Override
    public void fromDataInputStream(DataInputStream dis) throws IOException {
        id = dis.readInt();
        x = dis.readInt();
        y = dis.readInt();
        pickUpIndex = dis.readInt();
    }
    
}

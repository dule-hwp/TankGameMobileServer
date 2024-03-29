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
public class UiInfo implements INetworkable{
    int score;
    int health;
    int weaponId;
    private int ownerID;

    public UiInfo(int ownerId, int score, int health, int weaponId) {
        this.ownerID = ownerId;
        this.score = score;
        this.health = health;
        this.weaponId = weaponId;
    }

    public UiInfo() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }
    public static final int SIZE = 16;
    @Override
    public byte[] toBytes() {
        byte[] bts = ByteBuffer.allocate(SIZE)
                .putInt(ownerID)
                .putInt(score)
                .putInt(health)
                .putInt(weaponId)
                .array();
        return bts;
    }

    @Override
    public void fromDataInputStream(DataInputStream dataInput) throws IOException {
        ownerID = dataInput.readInt();
        this.score = dataInput.readInt();
        this.health = dataInput.readInt();
        this.weaponId = dataInput.readInt();
    }
    
}

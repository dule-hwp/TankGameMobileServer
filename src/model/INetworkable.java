/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author dusan_cvetkovic
 */
public interface INetworkable {
    byte [] toBytes();
    void fromDataInputStream(DataInputStream dataInput) throws IOException;
}

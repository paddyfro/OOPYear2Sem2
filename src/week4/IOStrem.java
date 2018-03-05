/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author patri
 */
public class IOStrem {

    static final String dataFile = "invoicedata.dat";
    static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99,9.99};
    static final int[] units = {12, 8, 13, 29, 50,69};
    static final String[] descs = {
        "Java T-shirt",
        "Java Mug",
        "Duke Juggling Dolls",
        "Java Pin",
        "Java Key Chain",
        "Dónals big boy pants"
    };

    public static void main(String args[]) throws IOException {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(dataFile)));

        for (int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeInt(units[i]);
            out.writeUTF(descs[i]);
        }
        //flush buffer and lcose utput stream
        out.flush();
        out.close();
        
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

        double price;
        int unit;
        String desc;
        double total = 0.0;
//Now DataStreams can read each record in the stream, reporting on the data it encounters.

        try {
            while (true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                        unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) {
        }
        in.close();
    }
}

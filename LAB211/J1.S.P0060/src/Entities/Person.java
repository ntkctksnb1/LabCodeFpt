/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author DELL
 */
public class Person {

    private Wallet wallet;
    private float[] bills;

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    public Person() {
    }

    public Wallet getWallet() {
        return wallet;
    }

    public float[] getBills() {
        return bills;
    }

}

class Wallet {

    private int value;

    public Wallet(int value) {
        this.value = value;
    }

    public Wallet() {
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}

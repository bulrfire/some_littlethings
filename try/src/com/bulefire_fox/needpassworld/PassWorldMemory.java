package com.bulefire_fox.needpassworld;

public class PassWorldMemory {
    private String passWorld;
    private String EncryptVersion;

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public String getEncryption() {
        return EncryptVersion;
    }

    public void setEncryption(String encrypt) {
        EncryptVersion = encrypt;
    }

    public PassWorldMemory(String passWorld, String encrypt) {
        this.passWorld = passWorld;
        EncryptVersion = encrypt;
    }

    public PassWorldMemory(){

    }
}

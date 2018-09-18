package com.hoho.monitor;

public class IpAddress {
    private String ip;
    private int port;

    public IpAddress(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public IpAddress() {
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

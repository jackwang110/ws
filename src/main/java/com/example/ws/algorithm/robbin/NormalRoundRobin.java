package com.example.ws.algorithm.robbin;

import java.util.ArrayList;
import java.util.List;

public class NormalRoundRobin {
        private List<Server> servers;

        private int currentIndex;
        private int totalServer;

    public NormalRoundRobin() {
            servers = new ArrayList<>();
            servers.add(new Server("192.168.1.2"));
            servers.add(new Server("192.168.1.3"));
            servers.add(new Server("192.168.1.4"));
            servers.add(new Server("192.168.1.5"));
            servers.add(new Server("192.168.1.6"));
            servers.add(new Server("192.168.1.7"));
            servers.add(new Server("192.168.1.8"));
            totalServer = servers.size();
            currentIndex = totalServer - 1;
        }
    public Server round() {
        currentIndex = (currentIndex + 1) % totalServer;
        System.out.println(currentIndex);
        return servers.get(currentIndex);
    }

    public static void main(String[] args) {
        NormalRoundRobin robin = new NormalRoundRobin();
        for (int i = 0; i < 14; i++) {
            System.out.println(robin.round());
        }
    }

}

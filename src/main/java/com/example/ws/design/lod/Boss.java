package com.example.ws.design.lod;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public void chekNumBeforeCourse(TeamLeader teamLeader){
        List list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i+toString());
        }
        teamLeader.chekNumBeforeCourse(list);
    }

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader leader = new TeamLeader();
        boss.chekNumBeforeCourse(leader);
    }
}

package com.example.ws.algorithm.robbin;

import java.util.List;

public class WeightedRoundRobinScheduling {
    private int currentIndex = -1;// 上一次选择的服务器
     private int currentWeight = 0;// 当前调度的权值
     private int maxWeight = 0; // 最大权重
     private int gcdWeight = 0; //所有服务器权重的最大公约数
     private int serverCount = 0; //服务器数量
      private List<Server> serverList; //服务器集合
}

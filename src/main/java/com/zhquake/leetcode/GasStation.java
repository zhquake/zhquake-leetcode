package com.zhquake.leetcode;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 14, 2014
 */
public class GasStation {
    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int num = gas.length;

            if (num != cost.length)
                return -1;

            int[] rest = new int[num];
            int restSum = 0;
            for (int i = 0; i < num; i++) {
                rest[i] = gas[i] - cost[i];
                restSum += rest[i];
            }

            if (restSum < 0)
                return -1;

            int partSum = 0;
            int pos = -1;
            for (int i = 0; i < num; i++) {
                partSum += rest[i];
                if (partSum < 0) {
                    pos = i;
                    partSum = 0;
                }
            }

            return pos + 1;
        }
    }

}

package ru.job4j.algo.greedy;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int current = start;
        int fuel = 0;
        for (int i = 0; i < n; i++) {
            fuel += gas[current] - cost[current];
            if (fuel < 0) {
                return -1;
            }
            current = (current + 1) % n;
        }
        return start;
    }
}
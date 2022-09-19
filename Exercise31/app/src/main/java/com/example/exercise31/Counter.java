package com.example.buttonsinputs;

public class Counter {
    private int maxValue;
    private int minValue;
    private int startValue;
    private int steps;
    private int currentValue;


    public Counter(int maxCount, int minCount, int startValue, int steps) {
        this.maxValue = maxCount;
        this.minValue = minCount;
        this.startValue = startValue;
        this.steps = steps;
    }

    public Counter(){
        this.minValue = -100;
        this.maxValue = 100;
        this.startValue = 0;
        this.steps = 1;
    }

    public String startVal(){
        return Integer.toString(startValue);
    }

    public String increment(){
        if (currentValue + steps <= maxValue){
            currentValue += steps;
            return Integer.toString(currentValue);
        }
        return Integer.toString(currentValue);
    }

    public String decrement(){
        if (currentValue - steps >= minValue){
            currentValue -= steps;
            return Integer.toString(currentValue);
        }
        return Integer.toString(currentValue);
    }

    public String reset() {
        this.currentValue = startValue;
        return Integer.toString(currentValue);
    }




}
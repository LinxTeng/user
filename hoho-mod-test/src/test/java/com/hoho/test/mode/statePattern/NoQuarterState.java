package com.hoho.test.mode.statePattern;

/**
 * 没有硬币
 */
public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投入了一枚硬币");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你没有投入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄，但没有硬币");
    }

    @Override
    public void dispense() {
        System.out.println("你首先需要支付");
    }
}

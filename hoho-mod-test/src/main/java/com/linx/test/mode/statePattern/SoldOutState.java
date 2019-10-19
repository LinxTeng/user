package com.linx.test.mode.statePattern;

/**
 * 售罄糖果
 */
public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你不能再投入硬币了，因为糖果以及售罄了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你不能要求返还硬币，你没有投入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄,但没有糖果了");
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果发放");
    }
}

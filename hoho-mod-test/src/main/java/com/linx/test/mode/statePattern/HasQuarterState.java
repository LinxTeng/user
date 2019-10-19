package com.linx.test.mode.statePattern;

import java.util.Random;

/**
 * 有硬币
 */
public class HasQuarterState implements State{
    GumballMachine gumballMachine;

    Random randomWinner=new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你不能再投入另一枚硬币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("硬币返还");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄");
        int winner=randomWinner.nextInt(2);
        if(winner==0 && (gumballMachine.getCout()>1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果发放");
    }
}

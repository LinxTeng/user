package com.hoho.test.mode.statePattern;

/**
 * 售出状态
 */
public class SoldState implements State{
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请稍等,我们正准备给您一颗糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("对不起，你已经转动了曲柄");
    }

    @Override
    public void turnCrank() {
        System.out.println("再次转动曲柄不会给你另一颗糖果");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCout()>0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else {
            System.out.println("糖果正在出来的途中");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}

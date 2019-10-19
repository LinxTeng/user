package com.linx.test.mode.statePattern;

/**
 * 赢家状态，可以获得两个糖果。
 */
public class WinnerState implements State{
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine){
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
        System.out.println("你中奖了,你得到了两个糖果!");
        gumballMachine.releaseBall();
        if(gumballMachine.getCout() ==0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else {
            gumballMachine.releaseBall();
            if(gumballMachine.getCout()>0){
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }else {
                System.out.println("没有糖果了");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}

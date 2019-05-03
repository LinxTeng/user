package com.hoho.test.mode.statePattern;

/**
 * 糖果机
 */
public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int cout=0;

    public GumballMachine(int numberGumballs){
        soldOutState=new SoldOutState(this);
        noQuarterState=new NoQuarterState(this);
        hasQuarterState=new HasQuarterState(this);
        soldState=new SoldState(this);
        winnerState=new WinnerState(this);
        this.cout=numberGumballs;
        if(numberGumballs>0){
            state=noQuarterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    void setState(State state){
        this.state=state;
    }

    void releaseBall(){
        System.out.println("释放了一个糖果");
        if(cout !=0){
            cout=cout-1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCout() {
        return cout;
    }

    public static void main(String[] args) {
        GumballMachine gumballMachine=new GumballMachine(10);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}

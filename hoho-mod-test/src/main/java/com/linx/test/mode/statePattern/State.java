package com.linx.test.mode.statePattern;

public interface State {
    /**
     * 放入硬币
     */
    void insertQuarter();

    /**
     * 退回硬币
     */
    void ejectQuarter();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放
     */
    void dispense();
}

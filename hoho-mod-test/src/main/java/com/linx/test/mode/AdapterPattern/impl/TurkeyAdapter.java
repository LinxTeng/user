package com.linx.test.mode.AdapterPattern.impl;

import com.linx.test.mode.AdapterPattern.Duck;
import com.linx.test.mode.AdapterPattern.Turkey;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey=turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i=0;i<5;i++){
            turkey.fly();
        }
    }
}

package com.hoho.test.mode.AdapterPattern.impl;

import com.hoho.test.mode.AdapterPattern.Duck;

public class DuckTestDrive {
    public static void main(String[] args) {
        WildTurkey turkey=new WildTurkey();
        Duck turkeyAdapter=new TurkeyAdapter(turkey);

        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}

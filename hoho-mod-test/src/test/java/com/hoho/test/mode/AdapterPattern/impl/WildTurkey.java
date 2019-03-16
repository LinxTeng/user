package com.hoho.test.mode.AdapterPattern.impl;

import com.hoho.test.mode.AdapterPattern.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I am fly a short distance");
    }
}

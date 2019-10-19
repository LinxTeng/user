package com.linx.test.mode.CommandPatterm.impl;

import com.linx.test.mode.CommandPatterm.Command;

public class LightOnCommand implements Command {
    Lighter light;

    public LightOnCommand(Lighter light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

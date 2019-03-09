package com.hoho.test.mode.CommandPatterm.impl;

import com.hoho.test.mode.CommandPatterm.Command;

public class LightOffCommand  implements Command {
    Lighter lighter;

    public LightOffCommand(Lighter lighter){
        this.lighter=lighter;
    }

    @Override
    public void execute() {
        lighter.off();
    }

    @Override
    public void undo() {
        lighter.on();
    }
}

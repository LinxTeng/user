package com.hoho.test.mode.CommandPatterm.impl;

import com.hoho.test.mode.CommandPatterm.Command;

/**
 * 什么都不做的命令
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("没有可执行的开关");
    }

    @Override
    public void undo() {
        System.out.println("没有可执行的开关");
    }
}

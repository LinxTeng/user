package com.linx.test.mode.CommandPatterm;

import com.linx.test.mode.CommandPatterm.impl.LightOffCommand;
import com.linx.test.mode.CommandPatterm.impl.LightOnCommand;
import com.linx.test.mode.CommandPatterm.impl.Lighter;
import com.linx.test.mode.CommandPatterm.impl.NoCommand;

/**
 * 遥控器
 */
public class RemoteControl {
    Command[] onCommands;//开的插槽
    Command[] offCommands;//关的插槽
    Command undoCommand;//撤销上一步操作

    public RemoteControl(){
        onCommands=new Command[2];
        offCommands=new Command[2];
        undoCommand=new NoCommand();
        Command noCommand=new NoCommand();
        for (int i=0;i<2;i++){
             onCommands[i]=noCommand;
             offCommands[i]=noCommand;
        }
    }

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot]=onCommand;
        offCommands[slot]=offCommand;
    }

    public void onButtonWasPressed(int slot){
        onCommands[slot].execute();
        undoCommand=onCommands[slot];
    }

    public void offButtonWasPressed(int slot){
        offCommands[slot].execute();
        undoCommand=offCommands[slot];
    }

    public void undoBuuttonWasPressed(){
        undoCommand.undo();
    }

    public static void main(String[] args) {
        RemoteControl remoteControl=new RemoteControl();
        Lighter lighter=new Lighter("卧室");
        LightOnCommand lightOnCommand=new LightOnCommand(lighter);
        LightOffCommand lightOffCommand=new LightOffCommand(lighter);
        remoteControl.setCommand(0,lightOnCommand,lightOffCommand);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        remoteControl.undoBuuttonWasPressed();

        remoteControl.offButtonWasPressed(1);

    }
}

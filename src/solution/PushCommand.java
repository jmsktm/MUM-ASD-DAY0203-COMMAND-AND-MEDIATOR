/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Stack;

/**
 *
 * @author jsingh
 */
public class PushCommand implements Command {

    private Receiver receiver;
    private String value;

    public PushCommand(Receiver receiver, String value) {
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public void execute() {
        receiver.push(value);
    }

    @Override
    public void undo() {
        value = receiver.pop();
    }
}

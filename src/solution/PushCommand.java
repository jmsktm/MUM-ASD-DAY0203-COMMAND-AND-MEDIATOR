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
    
    private Stack<String> undoStack = new Stack<String>();
    
    public PushCommand(Receiver receiver, String value) {
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public Stack execute() {
        if(undoStack.size()>0) {
            undoStack = new Stack<String>();
        }
        return receiver.push(value);
    }

    @Override
    public Stack undo() {
        Stack prevStack = receiver.pop();
        if(prevStack.size()>0) {
            String popped = (String)prevStack.pop();
            undoStack.push(popped);
        }
        return prevStack;
    }
}

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
public class PopCommand implements Command {
    
    Receiver receiver;
    private Stack<String> undoStack = new Stack<String>();
    
    public PopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Stack execute() {
        Stack prevStack = receiver.pop();
        if(prevStack.size()>0) {
            undoStack.push((String)prevStack.pop());
        }
        return prevStack;
    }

    @Override
    public Stack undo() {
        Stack<String> nextStack = new Stack<String>();
        if(undoStack.size()>0){
            String value = undoStack.pop();
            nextStack = receiver.push(value);
        }
        return nextStack;
    }
}

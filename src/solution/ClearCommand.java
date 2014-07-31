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
public class ClearCommand implements Command {
    
    Receiver receiver;
    private Stack<String> history;
    
    public ClearCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        history = receiver.clear();
    }

    @Override
    public void undo() {
        if(history!=null){
            for(String str: history) {
                receiver.push(str);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

/**
 *
 * @author jsingh
 */
public class PopCommand implements Command {
    
    Receiver receiver;
    private String history;
    
    public PopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        history = receiver.pop();
    }

    @Override
    public void undo() {
        if(history!=null){
            receiver.push(history);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import javax.swing.JButton;

/**
 *
 * @author jsingh
 */
public class RedoButton extends JButton implements Collaborator{
    
    public static final String NAME = "UNDO_BUTTON";
    
    private Mediator mediator;
    private String name;
    
    public RedoButton(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    @Override
    public void send(Message message, Mediator mediator) {
        // Never sends, just receives;
    }

    @Override
    public void receive(Message message) {
        if(message.getAbout().equalsIgnoreCase(CommandManager.REDO_AVAILABLE)) {
            this.setEnabled(message.isStatus());
        }
    }    
}

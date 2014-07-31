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
public class PushButton extends JButton implements ReceiverCollaborator{
    
    public static final String NAME = "PUSH_BUTTON";
    
    private Mediator mediator;
    private String name;
    
    public PushButton(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    public String getName() {
        return name;
    }

    @Override
    public void receive(Message message) {
        // Always remains active. Never have to disable it.
    }    
}

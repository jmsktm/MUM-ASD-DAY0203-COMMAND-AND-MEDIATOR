/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsingh
 */
public class MediatorImpl implements Mediator {
    
    private List<Collaborator> collaborList;
    
    public MediatorImpl() {
        collaborList = new ArrayList<Collaborator>();
    }

    @Override
    public void addCollaborator(Collaborator collaborator) {
        collaborList.add(collaborator);
    }

    @Override
    public void send(Collaborator collaborator, Message message) {
        for(Collaborator c: collaborList) {
            if(c!=collaborator) {
                c.receive(message);
            }
        }
    }    
}

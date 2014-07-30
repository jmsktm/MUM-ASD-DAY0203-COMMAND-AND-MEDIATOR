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
public interface Mediator {
    public void send(Collaborator collaborator, Message message);
    public void addCollaborator(Collaborator collaborator);
}

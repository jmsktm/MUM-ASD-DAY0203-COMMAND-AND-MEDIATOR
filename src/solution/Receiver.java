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
public interface Receiver extends Collaborator {
    public void push(String s);
    public String pop();
    public Stack<String> getMainStack();
}

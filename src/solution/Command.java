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
public interface Command {
    public Stack execute();
    public Stack undo();
}

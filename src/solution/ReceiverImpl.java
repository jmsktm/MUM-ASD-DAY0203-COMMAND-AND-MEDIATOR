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
public class ReceiverImpl implements Receiver {
    
    private Stack mainStack = new Stack<String>();

    @Override
    public Stack push(String t) {
        mainStack.push(t);
        return (Stack<String>)mainStack.clone();
    }

    @Override
    public Stack pop() {
        Stack prevStack = new Stack();
        prevStack.addAll(mainStack);
        if(mainStack.size()>0){
            mainStack.pop();
        }
        return prevStack;
    }
}

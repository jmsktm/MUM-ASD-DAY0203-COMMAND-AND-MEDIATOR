/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Stack;
import static solution.CommandManager.UNDO_AVAILABLE;

/**
 *
 * @author jsingh
 */
public class ReceiverImpl implements Receiver {

    public static final String NAME = "RECEIVER";
    public static final String ELEMENTS_IN_STACK = "ELEMENTS_IN_STACK";

    private Mediator mediator;
    private String name;

    public ReceiverImpl(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    private Stack mainStack = new Stack<String>();

    @Override
    public Stack push(String t) {
        mainStack.push(t);
        this.send(new Message(ELEMENTS_IN_STACK, true), mediator);
        return (Stack<String>) mainStack.clone();
    }

    @Override
    public Stack pop() {
        Stack prevStack = new Stack();
        prevStack.addAll(mainStack);
        if (mainStack.size() > 0) {
            mainStack.pop();
        }
        this.send(new Message(ELEMENTS_IN_STACK, mainStack.size()>0), mediator);
        return prevStack;
    }

    @Override
    public void send(Message message, Mediator mediator) {
        mediator.send(this, message);
    }

    @Override
    public void receive(Message message) {
        // Receiver never receives any message, only sends.
    }
}

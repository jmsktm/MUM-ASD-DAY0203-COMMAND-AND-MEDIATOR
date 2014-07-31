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

    public static final String NAME = "RECEIVER";
    public static final String ELEMENTS_IN_STACK = "ELEMENTS_IN_STACK";

    private Stack<String> mainStack = new Stack<String>();

    private Mediator mediator;
    private String name;

    public ReceiverImpl(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    public String getName() {
        return name;
    }

    public Stack<String> getMainStack() {
        return mainStack;
    }

    @Override
    public void push(String t) {
        mainStack.push(t);
        this.send(new Message(ELEMENTS_IN_STACK, true), mediator);
    }

    @Override
    public String pop() {
        String popped = null;
        if (mainStack.size() > 0) {
            popped = mainStack.pop();
        }
        this.send(new Message(ELEMENTS_IN_STACK, mainStack.size() > 0), mediator);
        return popped;
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

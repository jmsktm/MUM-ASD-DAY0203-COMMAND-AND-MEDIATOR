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
public class CommandManager implements Collaborator {

    public static final String NAME = "COMMAND_MANAGER";
    public static final String REDO_AVAILABLE = "REDO_AVAILABLE";
    public static final String UNDO_AVAILABLE = "UNDO_AVAILABLE";

    private Mediator mediator;
    private String name;

    public CommandManager(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    // Commands are put in history as they are executed.
    private Stack<Command> history = new Stack<Command>();
    private Stack<String> state = new Stack<String>();

    // Points to the current cursor position in history stack.
    private int pos = -1;

    /**
     * When a command is executed, if the cursor is not pointing to the last
     * element in the history, remove the history beyond the cursor position.
     * This is, any command execution after undo will cause the undone changes
     * to be lost permanently.
     */
    public Stack execute(Command command) {
        int forwardBy = history.size() - (pos + 1);

        while (forwardBy > 0) {
            history.pop();
            forwardBy--;
        }
        history.push(command);
        pos++;
        state = command.execute();

        this.send(new Message(UNDO_AVAILABLE, true), mediator);
        this.send(new Message(REDO_AVAILABLE, false), mediator);

        return state;
    }

    public Stack undo() {
        if (history.size() > 0 && pos >= 0) {
            Command command = history.elementAt(pos);
            pos--;
            state = command.undo();
            this.send(new Message(UNDO_AVAILABLE, pos>=0), mediator);
            this.send(new Message(REDO_AVAILABLE, pos<(history.size()-1)), mediator);
        }
        return state;
    }

    public Stack redo() {
        if (pos >= -1 && pos < history.size() - 1) {
            Command command = history.elementAt(pos + 1);
            pos++;
            state = command.execute();
            this.send(new Message(UNDO_AVAILABLE, pos>=0), mediator);
            this.send(new Message(REDO_AVAILABLE, pos<(history.size()-1)), mediator);
        }
        return state;
    }

    @Override
    public void send(Message message, Mediator mediator) {
        mediator.send(this, message);
    }

    @Override
    public void receive(Message message) {
        // Never receives, only sends
    }
}

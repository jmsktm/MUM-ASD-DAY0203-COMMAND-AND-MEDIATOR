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

    // Commands are put in history as they are executed.
    private Stack<Command> history = new Stack<Command>();

    // Points to the current cursor position in history stack.
    private int pos = -1;

    private Mediator mediator;
    private String name;

    public CommandManager(Mediator mediator) {
        this.mediator = mediator;
        this.name = NAME;
    }

    public String getName() {
        return name;
    }

    /**
     * When a command is executed, if the cursor is not pointing to the last
     * element in the history, remove the history beyond the cursor position.
     * This is, any command execution after undo will cause the undone changes
     * to be lost permanently.
     */
    public void execute(Command command) {
        int forwardBy = history.size() - (pos + 1);

        while (forwardBy > 0) {
            history.pop();
            forwardBy--;
        }
        pos++;
        command.execute();
        history.push(command);

        this.send(new Message(UNDO_AVAILABLE, true), mediator);
        this.send(new Message(REDO_AVAILABLE, false), mediator);
    }

    public void undo() {
        if (history.size() > 0 && pos >= 0) {
            Command command = history.elementAt(pos);
            pos--;
            command.undo();
            this.send(new Message(UNDO_AVAILABLE, pos>=0), mediator);
            this.send(new Message(REDO_AVAILABLE, pos<(history.size()-1)), mediator);
        }
    }

    public void redo() {
        if (pos >= -1 && pos < history.size() - 1) {
            Command command = history.elementAt(pos + 1);
            pos++;
            command.execute();
            this.send(new Message(UNDO_AVAILABLE, pos>=0), mediator);
            this.send(new Message(REDO_AVAILABLE, pos<(history.size()-1)), mediator);
        }
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

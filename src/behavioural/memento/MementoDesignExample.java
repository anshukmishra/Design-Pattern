package behavioural.memento;

import java.util.ArrayList;
import java.util.List;

// Memento Class
class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator Class
class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EditorState save() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        this.content = state.getContent();
    }
}

// Caretaker Class
class History {
    private final List<EditorState> states = new ArrayList<>();

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        if (states.isEmpty()) {
            return null;
        }
        return states.remove(states.size() - 1);
    }
}

public class MementoDesignExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // User types in the editor
        editor.setContent("Version 1");
        history.push(editor.save());

        editor.setContent("Version 2");
        history.push(editor.save());

        editor.setContent("Version 3");
        System.out.println("Current Content: " + editor.getContent());

        // Undo to previous version
        editor.restore(history.pop());
        System.out.println("After Undo: " + editor.getContent());

        // Undo again to the first version
        editor.restore(history.pop());
        System.out.println("After Second Undo: " + editor.getContent());
    }
}

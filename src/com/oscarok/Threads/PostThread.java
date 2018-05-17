package com.oscarok.Threads;

import com.oscarok.Interpreters.PostInterpreter;
import com.oscarok.Interpreters.UserInterpreter;
import com.oscarok.Resources.Post;
import com.oscarok.Resources.User;

import javax.swing.*;

public class PostThread extends Thread {
    private String title;
    private PostInterpreter postInterpreter;
    private UserInterpreter userInterpreter;
    private JTextArea postArea;

    public PostThread(String title, JTextArea postArea) {
        super(title);
        this.title = title;
        this.postInterpreter = new PostInterpreter();
        this.userInterpreter = new UserInterpreter();
        this.postArea = postArea;
    }

    @Override
    public void run() {
        Post[] posts = postInterpreter.run(title);
        User[] users = userInterpreter.run(posts[0].getUserId());

        String postFinal = title + "\n" +
                "by " + users[0].getName() +
                "\n" + posts[0].getBody();

        postArea.setText(postFinal);
    }
}

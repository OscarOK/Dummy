package com.oscarok.Threads;

import com.oscarok.Interpreters.PostInterpreter;
import com.oscarok.Interpreters.UserInterpreter;
import com.oscarok.Resources.Post;
import com.oscarok.Resources.User;

import javax.swing.*;

public class PostThread extends Thread {
    private String title;
    private Post[] posts;
    private User[] users;
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
        posts = postInterpreter.run();
        users = userInterpreter.run();

        StringBuilder postFinal = new StringBuilder(title);
        postFinal.append("\n");

        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                String userId = post.getUserId();

                for (User user : users) {
                    if (user.getId().equals(userId)) {
                        postFinal.append("by ").append(user.getName());
                        break;
                    }
                }

                postFinal.append("\n").append(post.getBody());
                break;
            }
        }

        postArea.setText(postFinal.toString());
    }
}

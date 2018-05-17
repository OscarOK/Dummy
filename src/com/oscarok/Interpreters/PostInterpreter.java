package com.oscarok.Interpreters;

import com.oscarok.Resources.Post;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class PostInterpreter {
    public Post[] run() {
        ObjectMapper mapper = new ObjectMapper();
        Post[] posts = null;

        try {
            posts = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), Post[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
}

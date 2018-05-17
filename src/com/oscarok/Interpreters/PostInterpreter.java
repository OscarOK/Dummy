package com.oscarok.Interpreters;

import com.oscarok.Resources.Post;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class PostInterpreter {
    public Post[] run(String title) {
        ObjectMapper mapper = new ObjectMapper();
        Post[] posts = null;

        try {
            String url = "https://jsonplaceholder.typicode.com/posts?title=" + title.replaceAll("\\s", "%20");
            posts = mapper.readValue(new URL(url), Post[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
}

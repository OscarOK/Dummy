package com.oscarok.Interpreters;

import com.oscarok.Resources.Photo;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class PhotoInterpreter {
    public Photo[] run() {
        ObjectMapper mapper = new ObjectMapper();
        Photo[] photos = null;
        try {
            photos = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/photos"), Photo[].class);
        } catch (ConnectException e) {
            System.out.println("Time limit exceeded");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photos;
    }
}

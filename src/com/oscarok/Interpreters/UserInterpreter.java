package com.oscarok.Interpreters;

import com.oscarok.Resources.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInterpreter {
    public User[] run() {
        ObjectMapper mapper = new ObjectMapper();
        User[] users = null;
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            users = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), User[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

package com.oscarok.Interpreters;

import com.oscarok.Resources.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInterpreter {
    public User[] run(String userId) {
        ObjectMapper mapper = new ObjectMapper();
        User[] users = null;
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String url = "https://jsonplaceholder.typicode.com/users?userId=" + userId.replaceAll("\\s", "%20");
            users = mapper.readValue(new URL(url), User[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

package com.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("plugin")
public class PluginController {

    @Autowired
    private PluginMapper pluginMapper;

    @GetMapping("test")
    public List<User> testConnection(@RequestParam("username") String username){
        return pluginMapper.getUser(username);
    }

}

package com.example.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class PluginService {

    /**
     * #{}需结合mybatis动态sql
     * @return
     */
    public String getProvider(){
        return new SQL()
                .SELECT("user_id, username, password, role")
                .FROM("user")
                .WHERE("user_id = #{id}", "username=#{username}")
                .toString();
    }

    public String getProvider1(){
        int id = 1;
        String username = "lanluyug";
        return new SQL()
                .SELECT("user_id, username, password, role")
                .FROM("user")
                .WHERE("user_id = '" + id + "'", " username= '" + username + "'")
                .toString();
    }
}

package com.cyn.demo.generic;

import com.cyn.demo.bean.User;
import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class TestResultGeneric {

    @Test
    public ResultTemp<User> getR() {
        User user = new User(1, "1");
        return ResultTemp.ok();
    }
}


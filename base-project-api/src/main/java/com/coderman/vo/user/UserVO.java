package com.coderman.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author coderman
 * @Title: TODO
 * @Description: TOD
 * @date 2022/4/422:09
 */
@Data
@AllArgsConstructor
public class UserVO {
    private String username;

    private String nickname;

    private String password;
}

package com.daydream.shortlink.admin.controller;

import com.daydream.shortlink.admin.dto.resp.UserRespDTO;
import com.daydream.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author daydream
 * Description
 * Date 2024/12/31 15:18
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/shortlink/v1/user/{username}")
    public UserRespDTO getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}

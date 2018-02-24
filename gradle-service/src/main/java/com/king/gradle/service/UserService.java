package com.king.gradle.service;

import com.king.gradle.api.User;

import java.util.List;

public interface UserService {

    User get(long id);

    long save(User user);

    long delete(long id);

    List<User> list();

}

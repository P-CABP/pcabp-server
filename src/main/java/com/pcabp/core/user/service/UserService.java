package com.pcabp.core.user.service;

import java.util.Optional;

import com.pcabp.core.user.dto.UserSearchParam;
import com.pcabp.core.user.vo.User;

public interface UserService {

    Optional<User> getUser(UserSearchParam param);
}

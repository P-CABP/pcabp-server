package com.pcabp.core.user.repository;

import java.util.Optional;

import com.pcabp.core.user.dto.UserSearchParam;
import com.pcabp.core.user.vo.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    Optional<User> findUser(UserSearchParam param);
}

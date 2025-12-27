package com.pcabp.core.user.service;

import java.util.Optional;

import com.pcabp.core.user.dto.UserSearchParam;
import com.pcabp.core.user.repository.UserRepository;
import com.pcabp.core.user.vo.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUser(UserSearchParam param) {
        return userRepository.findUser(param);
    }
}

package com.pcabp.session;

import java.util.Optional;

import com.pcabp.constant.Label;
import com.pcabp.constant.Message;
import com.pcabp.core.user.dto.UserSearchParam;
import com.pcabp.core.user.service.UserService;
import com.pcabp.core.user.vo.User;
import com.pcabp.helper.MessageTranslator;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionAuthenticationService implements UserDetailsService {

    private final UserService userService;

    private final MessageTranslator messageTranslator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSearchParam command = UserSearchParam.ofUsername(username);
        Optional<User> optionalUser = userService.getUser(command);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return SessionUserDetails.ofUser(user);
        }

        log.error(messageTranslator.translate(Message.Exception.NOT_FOUND, Label.User.USER));
        throw new UsernameNotFoundException(messageTranslator.translate(Message.Exception.NOT_FOUND, Label.User.USER));
    }
}

package Korcp.security;

import Korcp.dto.user.UserDTO;
import Korcp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDataService implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public UserDataService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserData loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userMapper.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found");
        }
        return new UserData(username,user.getPassword());
    }
}
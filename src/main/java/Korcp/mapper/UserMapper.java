package Korcp.mapper;

import Korcp.dto.user.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserDTO findUserByEmail(String email);
    void InsertUser(UserDTO user);
}

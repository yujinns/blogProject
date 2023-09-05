package yujinns.bloguser.mapper;

import org.apache.ibatis.annotations.Mapper;
import yujinns.bloguser.dto.UserDto;

@Mapper
public interface UserMapper {

    void insertUser(UserDto userDto);

}

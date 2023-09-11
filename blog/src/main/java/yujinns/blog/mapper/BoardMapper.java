package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.PageRequest;
import yujinns.blog.DTO.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
    void writeAction(Board dto);

    List<Board> list();

    Board selectByIdx(int boardIdx);

    void updateAction(Board dto);

    int deleteById(int boardIdx);

    void list(PageRequest boardIdx);

    void updatehit(int boardIdx);

    List<Board> selectByUserId(String userId);
}

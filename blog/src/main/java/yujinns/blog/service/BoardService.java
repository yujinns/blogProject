package yujinns.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yujinns.blog.DTO.Board;
import yujinns.blog.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public void writeAction(Board dto) {
        boardMapper.writeAction(dto);
    }

    public List<Board> list() {
        return boardMapper.list();
    }
    public List<Board> selectByUserId(String userId){
        return boardMapper.selectByUserId(userId);
    }
    public Board selectByIdx(int boardIdx) {
        return boardMapper.selectByIdx(boardIdx);
    }

    public void updateAction(Board dto) {
        boardMapper.updateAction(dto);
    }

    public Board deleteBoard(int idx) {
        int result = boardMapper.deleteById(idx);
        Board dto = boardMapper.selectByIdx(idx);
        return (result == 1)? dto: null;
    }

    public void updatehit(int boardIdx) {
        boardMapper.updatehit(boardIdx);
    }
}

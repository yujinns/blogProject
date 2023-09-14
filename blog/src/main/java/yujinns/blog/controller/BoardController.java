package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import yujinns.blog.DTO.Board;
import yujinns.blog.DTO.Message;
import yujinns.blog.service.BoardService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String index(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");
        List<Board> list = boardService.selectByUserId(userId);
        model.addAttribute("boardList", list);
        return "elden_ring_list"; //blog_main
    }

    @GetMapping("/details/{id}")
    public String showBoardDetails(@PathVariable int id, Model model){
        Board board = boardService.selectByIdx(id);
        model.addAttribute("board", board);
        return "elden_ring_detail";
    }

//    @GetMapping("/details")
//    public String showBoardDetails(int boardIdx, Model model){
//        Board board = boardService.selectByIdx(boardIdx);
//        model.addAttribute("board", board);
//        return "elden_ring_detail";
//    }

//    @GetMapping("/readform")
//    public String boardDetail(HttpServletRequest request,
//                              HttpServletResponse response, int boardIdx, Model model) {
//
//        // 쿠키에서 이미 조회한 게시글 ID를 확인
//        boolean isViewed = false;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("viewedBoardIds".equals(cookie.getName())) {
//                    String[] viewedIds = cookie.getValue().split(",");
//                    for (String viewedId : viewedIds) {
//                        if (viewedId.equals(String.valueOf(boardIdx))) {
//                            isViewed = true;
//                            break;
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//
//        // 이미 조회한 게시글이 아니라면 조회수를 증가하고 쿠키에 게시글 ID를 추가
//        if (!isViewed) {
//            boardService.updatehit(boardIdx);
//
//            // 쿠키에 게시글 ID 추가
//            String viewedIds = "";
//            Cookie[] existingCookies = request.getCookies();
//            if (existingCookies != null) {
//                for (Cookie cookie : existingCookies) {
//                    if ("viewedBoardIds".equals(cookie.getName())) {
//                        viewedIds = cookie.getValue() + ",";
//                        break;
//                    }
//                }
//            }
//            viewedIds += boardIdx;
//
//            Cookie cookie = new Cookie("viewedBoardIds", viewedIds);
//            cookie.setMaxAge(3600 * 24); // 쿠키 유효기간 설정 (하루: 3600초 * 24시간)
//            response.addCookie(cookie);
//        }
//
//        Board dto = boardService.selectByIdx(boardIdx);
//        model.addAttribute("read", dto);
//        System.out.println(dto);
//
//        return "readform";
//    }

    @GetMapping("/writeform")
    public String writeform(){
        return "elden_ring_writeform";
    }

    @PostMapping("/writeAction")
    public String writeAction(final Board dto, Model model) {
        System.out.println("yujinns board::"+ dto);
        boardService.writeAction(dto);
        Message message = new Message("게시글 생성이 완료되었습니다.", "/board", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @GetMapping("/updateform/{id}")
    public String updateform(@PathVariable int id, Model model) throws Exception{
        Board dto = boardService.selectByIdx(id);
        System.out.println(dto);
        model.addAttribute("update", dto);
        return "elden_ring_updateForm";
    }

    @PostMapping("/updateAction")
    public String updateAction(Board dto, Model model) throws Exception {
        System.out.println("yujinns update::"+ dto);
        boardService.updateAction(dto);
        Message message = new Message("게시글 수정이 완료되었습니다.", "/board", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam int id, Model model) throws Exception{
        Board result = boardService.deleteByIdx(id);
        Message message = new Message("게시글 삭제가 완료되었습니다.", "/board", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    private String showMessageAndRedirect(final Message params, Model model){
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}

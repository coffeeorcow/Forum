package com.forum.web.user;

import com.forum.dto.BoardInfo;
import com.forum.dto.ItemInfo;
import com.forum.dto.ReplyInfo;
import com.forum.entity.Board;
import com.forum.entity.Item;
import com.forum.entity.Reply;
import com.forum.entity.User;
import com.forum.service.BoardService;
import com.forum.service.ItemService;
import com.forum.service.ManageUserService;
import com.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserCore {

    @Autowired
    private ManageUserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ReplyService replyService;

    // 进入主页
    @RequestMapping("/main")
    public String main(Model model) {
        List<BoardInfo> boardList = boardService.queryPageBoard();
        model.addAttribute("boardList", boardList);
        List<ItemInfo> itemInfos = itemService.queryPageItem();
        model.addAttribute("itemInfos", itemInfos);
        return "user/main";
    }

    // 显示board页，根据boardId
    @RequestMapping("/board/boardId={boardId}")
    public String boardById(@PathVariable(value = "boardId") Long boardId,
                            Model model) {
        List<ItemInfo> itemInfos = itemService.queryItemByBoardId(boardId);
        model.addAttribute("itemInfos", itemInfos);
        return "user/board";
    }

    // 显示board页，根据boardName
    @RequestMapping("/board")
    public String boardByName(@RequestParam(value = "boardName") String boardName, Model model) {
        List<BoardInfo> boardList = boardService.queryBoardByName(boardName);
        List<ItemInfo> itemInfos = itemService.queryItemByBoardName(boardName);
        model.addAttribute("boardList", boardList);
        model.addAttribute("itemInfos", itemInfos);
        return "user/board";
    }

    // 显示item页，根据itemId
    @RequestMapping("/item/itemId={itemId}")
    public String item(@PathVariable(value = "itemId") Long itemId,
                       @RequestParam(value = "replyContent", required = false) String replyContent,
                       HttpServletRequest request,
                       Model model) {
        ItemInfo itemInfo = itemService.queryItemByItemId(itemId);
        model.addAttribute("itemInfo", itemInfo);
        if (replyContent != null) {
            if (!replyContent.equals("")) {
                HttpSession session = request.getSession();
                replyService.addReply((Long) session.getAttribute("userId"), itemId, replyContent);
            }
        }
        List<ReplyInfo> replyList = replyService.queryPageByItemId(itemId, 1);
        model.addAttribute("replyList", replyList);
        return "user/item";
    }



    // 查看我的item
    @RequestMapping("/oldItem")
    public String oldItem(HttpServletRequest request, Model model){
        HttpSession session= request.getSession();
        Long userId = (Long)session.getAttribute("userId");
        List<ItemInfo> itemInfoList = itemService.queryItemByUserId(userId);
        model.addAttribute("itemInfoList", itemInfoList);
        return "user/oldItem";
    }

    // 进入添加新的item页面
    @RequestMapping("/newItem")
    public String newItem(@RequestParam(value = "boardName", required = false) String boardName,
                          Model model){
        if (boardName != null){
            if (!boardName.trim().equals("")){
                List<BoardInfo> boardList = boardService.queryBoardByName(boardName);
                model.addAttribute("boardList", boardList);
                return "user/newItem";
            }
        }
        List<BoardInfo> boardList = boardService.queryPageBoard();
        model.addAttribute("boardList", boardList);
        return "user/newItem";
    }

    // 进入修改item信息页面
    @RequestMapping("/updateItem/itemId={itemId}")
    public String updateItem(@PathVariable(value = "itemId") Long itemId,
                             Model model){
        ItemInfo itemInfo = itemService.queryItemByItemId(itemId);
        model.addAttribute("itemInfo", itemInfo);
        return "user/update";
    }

    // 查看我的评论
    @RequestMapping("/reply")
    public String reply(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long)session.getAttribute("userId");
        List<ReplyInfo> replyInfoList = replyService.queryPageByUserId(userId, 1);
        model.addAttribute("replyInfoList", replyInfoList);
        return "user/reply";
    }

    // 修改我的评论
    @RequestMapping("/updateReply")
    public String updateReply(Reply reply){
        replyService.updateReply(reply);
        return "redirect:/user/reply";
    }

    // 删除我的评论
    @RequestMapping("/deleteReply/replyId={replyId}")
    public String deleteReply(@PathVariable(value = "replyId") Long replyId){
        replyService.deleteReply(replyId);
        return "redirect:/user/reply";
    }

    // 进入设置我的信息页面
    @RequestMapping("/setting")
    public String setUser(HttpServletRequest request,
                          Model model){
        Long userId = (Long)request.getSession().getAttribute("userId");
        User user = userService.queryInfoById(userId);
        model.addAttribute("user", user);
        return "user/setting";
    }

    // 修改我的信息
    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userName") String userName,
                             @RequestParam("password") String password,
                             @RequestParam("userEmail") String userEmail,
                             HttpServletRequest request){
        Long userId = (Long)request.getSession().getAttribute("userId");
        userService.updateInfo(userId, userName, password, userEmail);
        return "redirect:/user/setting";
    }
}

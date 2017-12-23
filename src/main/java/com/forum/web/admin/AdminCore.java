package com.forum.web.admin;

import com.forum.dto.BoardInfo;
import com.forum.dto.ItemInfo;
import com.forum.entity.Board;
import com.forum.entity.User;
import com.forum.service.BoardService;
import com.forum.service.ItemService;
import com.forum.service.ManageUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminCore {

    @Autowired
    private ManageUserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/main")
    public String main(@RequestParam(value = "userName", required = false) String userName,
                       Model model){
        if (userName != null){
            if (!userName.trim().equals("")) {
                List<User> userList = userService.queryByName(userName);
                model.addAttribute("userList", userList);
                return "admin/main";
            }
        }
        List<User> userList = userService.queryPageUser(1);  // 查询第一页
        model.addAttribute("userList", userList);
        return "admin/main";
    }

    @RequestMapping("/board")
    public String board(@RequestParam(value = "boardName", required = false) String boardName,
                        Model model){
        if (boardName != null) {
            if (!boardName.trim().equals("")){
                List<BoardInfo> boardList = boardService.queryBoardByName(boardName);
                model.addAttribute("boardList", boardList);
                return "admin/board";
            }
        }
        List<BoardInfo> boardList = boardService.queryPageBoard();
        model.addAttribute("boardList", boardList);
        return "admin/board";
    }

    @RequestMapping("/newBoard")
    public String newBoard(){
        return "admin/newBoard";
    }

    @RequestMapping("/item")
    public String item(@RequestParam(value = "itemTitle", required = false) String itemTitle,
                       Model model){
        if (itemTitle != null) {
            if (!itemTitle.trim().equals("")){
                List<ItemInfo> itemList = itemService.queryByItemTitle(itemTitle);
                model.addAttribute("itemList", itemList);
                return "admin/item";
            }
        }
        List<ItemInfo> itemList = itemService.queryPageItem();
        model.addAttribute("itemList", itemList);
        return "admin/item";
    }

    @RequestMapping("/setting")
    public String setting(HttpServletRequest request, Model model){
        Long userId = (Long)request.getSession().getAttribute("userId");
        User admin = userService.queryInfoById(userId);
        model.addAttribute("admin", admin);
        return "admin/setting";
    }


    @RequestMapping("/updateAdmin")
    public String updateAdmin(User user){
        userService.updateInfo(user.getUserId(), user.getUserName(), user.getPassword(), user.getUserEmail());
        return "redirect:/admin/setting";
    }

    @RequestMapping("/deleteItem/itemId={itemId}")
    public String deleteItem(@PathVariable(value = "itemId") Long itemId){
        itemService.deleteItem(itemId);
        return "redirect:/admin/delete";
    }

    @RequestMapping("/addBoard")
    public String addBaord(@RequestParam(value = "boardName") String boardName,
                           @RequestParam(value = "boardDescription") String boardDescription){
        boardService.addBoard(boardName,boardDescription);
        return "redirect:/admin/newBoard";
    }

    @RequestMapping("/updateBoard")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "redirect:/admin/board";
    }

    @RequestMapping("/deleteBoard/boardId={boardId}")
    public String deleteBoard(@PathVariable(value = "boardId") Long boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/admin/board";
    }

    @RequestMapping("/lockUser/userId={userId}")
    public String lockUser(@PathVariable(value = "userId") Long userId){
        userService.lock(userId);
        return "redirect:/admin/main";
    }

    @RequestMapping("/activeUser/userId={userId}")
    public String activeUser(@PathVariable(value = "userId") Long userId){
        userService.active(userId);
        return "redirect:/admin/main";
    }

    @RequestMapping("/changeToUser/userId={userId}")
    public String changeToUser(@PathVariable(value = "userId") Long userId){
        userService.beUser(userId);
        return "redirect:/admin/main";
    }

    @RequestMapping("/changeToAdmin/userId={userId}")
    public String changeToAdmin(@PathVariable(value = "userId") Long userId){
        userService.beAdmin(userId);
        return "redirect:/admin/main";
    }
}
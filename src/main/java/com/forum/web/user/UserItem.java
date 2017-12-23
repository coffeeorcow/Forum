package com.forum.web.user;

import com.forum.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userItem")
public class UserItem {
    @Autowired
    private ItemService itemService;

    // 添加新的item
    @RequestMapping("/newItem")
    public String newItem(@RequestParam("boardId") Long boardId,
                          @RequestParam("itemTitle") String itemTitle,
                          @RequestParam("itemContent") String itemContent,
                          HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        itemService.addItem(boardId, userId, itemTitle, itemContent);
        return "redirect:/user/oldItem";
    }

    // 修改item信息
    @RequestMapping("/updateItem")
    public String updateItem(@RequestParam("itemId") Long itemId,
                             @RequestParam("itemTitle") String itemTitle,
                             @RequestParam("itemContent") String itemContent) {
        itemService.updateItem(itemId, itemTitle, itemContent);
        return "redirect:/user/oldItem";
    }

    // 删除我的item
    @RequestMapping("/deleteItem/itemId={itemId}")
    public String deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return "redirect:/user/oldItem";
    }
}

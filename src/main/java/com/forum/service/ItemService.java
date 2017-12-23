package com.forum.service;

import com.forum.dto.ItemInfo;
import com.forum.entity.Item;

import java.util.List;

/**
 * item 相关操作
 */
public interface ItemService {
    /**
     * 添加idea
     */
    void addItem(Long boardId, Long userId,  String itemTitle, String itemContent);

    /**
     * 删除idea
     */
    void deleteItem(Long itemId);

    /**
     * 根据板块id查找idea
     * @return
     */
    List<ItemInfo> queryItemByBoardId(Long boardId);

    /**
     * 根据模块名查找item
     * @param boardName
     * @return
     */
    List<ItemInfo> queryItemByBoardName(String boardName);

    /**
     * 根据用户id查找idea
     * @return
     */
    List<ItemInfo> queryItemByUserId(Long userId);

    /**
     * 根据用户名查找idea
     * @return
     */
    List<ItemInfo> queryItemByUserName(String userName);

    /**
     * 根据itemId查找idea
     * @return
     */
    ItemInfo queryItemByItemId(Long itemId);

    /**
     * 根据itemTitle查找idea
     * @return
     */
    List<ItemInfo> queryByItemTitle(String itemTitle);

    /**
     * 查询一页item
     * @return
     */
    List<ItemInfo> queryPageItem();

    /**
     * 修改idea信息
     * @param itemTitle  idea标题
     * @param itemContent  idea内容
     */
    void updateItem(Long itemId, String itemTitle, String itemContent);
}

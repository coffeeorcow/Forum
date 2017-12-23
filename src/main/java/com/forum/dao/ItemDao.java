package com.forum.dao;

import com.forum.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * item 相关操作
 */
public interface ItemDao {
    /**
     * 添加item
     * @param boardId  模块id
     * @param userId  用户id
     * @param itemTitle item 标题
     * @return 操作数
     */
    int addItem(@Param("boardId") Long boardId, @Param("userId") Long userId,
                @Param("itemTitle") String itemTitle, @Param("itemContent") String itemContent);

    /**
     * 删除Item
     * @param  itemId
     * @return
     */
    int deleteItem(Long itemId);

    /**
     * 根据模块id查找item
     * @param boardId
     * @return
     */
    List<Item> queryItemByBoardId(Long boardId);

    /**
     * 根据用户名查找item
     * @param userName
     * @return
     */
    List<Item> queryItemByUserName(String userName);

    /**
     * 根据itemId查询item
     * @param itemId
     * @return
     */
    Item queryItemById(Long itemId);

    /**
     * 分页查询item
     * @param offset
     * @param limit
     * @return
     */
    List<Item> queryPageOfItem(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据item名称查找item
     * @param itemTitle
     * @return
     */
    List<Item> queryByItemTitle(String itemTitle);

    /**
     * 根据用户id查询item
     * @param userId
     * @return
     */
    List<Item> queryItemByUserId(Long userId);

    /**
     * 根据模块名查找item
     * @param boardName 模块名
     * @return item信息表
     */
    List<Item> queryItemByBoardName(String boardName);

    /**
     * 修改Item信息
     * @param itemId
     * @param itemTitle
     * @param itemContent
     * @return
     */
    int updateItem(@Param("itemId") Long itemId, @Param("itemTitle") String itemTitle,
                   @Param("itemContent") String itemContent);

}

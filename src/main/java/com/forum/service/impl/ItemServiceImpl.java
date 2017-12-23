package com.forum.service.impl;

import com.forum.dao.BoardDao;
import com.forum.dao.ItemDao;
import com.forum.dao.ReplyDao;
import com.forum.dao.UserDao;
import com.forum.dto.ItemInfo;
import com.forum.entity.Item;
import com.forum.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private ReplyDao replyDao;

    public void addItem(Long boardId, Long userId, String itemTitle, String itemContent) {
        if (!itemTitle.equals("")){
            // 标题为空时不能添加
            itemDao.addItem(boardId, userId, itemTitle, itemContent);
        }
    }

    public void deleteItem(Long itemId) {
        itemDao.deleteItem(itemId);
    }

    public List<ItemInfo> queryItemByBoardId(Long boardId) {
        List<ItemInfo> itemInfos = new ArrayList<ItemInfo>();
        List<Item> items = itemDao.queryItemByBoardId(boardId);
        if (items != null) {
            if (items.size() > 0) {
                for (Item item : items) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.setItem(item);
                    itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
                    itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
                    itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
                    itemInfos.add(itemInfo);
                }
            }
        }
        return itemInfos;
    }

    public List<ItemInfo> queryItemByBoardName(String boardName) {
        List<Item> items = itemDao.queryItemByBoardName(boardName);
        List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
        if (items != null) {
            if (items.size() > 0) {
                for (Item item : items) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.setItem(item);
                    itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
                    itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
                    itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
                    itemInfoList.add(itemInfo);
                }
            }
        }
        return itemInfoList;
    }

    public List<ItemInfo> queryItemByUserId(Long userId) {
        List<Item> itemList = itemDao.queryItemByUserId(userId);
        List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
        for (Item item : itemList){
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setItem(item);
            itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
            itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
            itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
            itemInfoList.add(itemInfo);
        }
        return itemInfoList;
    }

    public List<ItemInfo> queryItemByUserName(String userName) {
        return null;
    }

    public ItemInfo queryItemByItemId(Long itemId) {
        Item item = itemDao.queryItemById(itemId);
        ItemInfo itemInfo = new ItemInfo();
        if (item != null) {
            itemInfo.setItem(item);
            itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
            itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
            itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
        }
        return itemInfo;
    }

    public List<ItemInfo> queryByItemTitle(String itemTitle) {
        List<Item> itemList = itemDao.queryByItemTitle(itemTitle);
        List<ItemInfo> itemInfos = new ArrayList<ItemInfo>();
        if (itemList != null) {
            if (itemList.size() > 0) {
                for (Item item : itemList) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.setItem(item);
                    itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
                    itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
                    itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
                    itemInfos.add(itemInfo);
                }
            }
        }
        return itemInfos;
    }

    public List<ItemInfo> queryPageItem() {
        List<Item> itemList = itemDao.queryPageOfItem(1, 6);
        List<ItemInfo> itemInfos = new ArrayList<ItemInfo>();
        if (itemList != null) {
            if (itemList.size() > 0) {
                for (Item item : itemList) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.setItem(item);
                    itemInfo.setBoardName(boardDao.queryById(item.getBoardId()).getBoardName());
                    itemInfo.setUserName(userDao.queryUserById(item.getUserId()).getUserName());
                    itemInfo.setReplyCount(replyDao.queryReplyCount(item.getItemId()));
                    itemInfos.add(itemInfo);
                }
            }
        }
        return itemInfos;
    }

    public void updateItem(Long itemId, String itemTitle, String itemContent) {
        itemDao.updateItem(itemId, itemTitle, itemContent);
    }
}

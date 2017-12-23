package com.forum.dao;

import com.forum.entity.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardDao {
    /**
     *  添加板块
     * @param boardName 板块名称
     * @return 成功数
     */
    int addBoard(@Param("boardName") String boardName, @Param("boardDescription") String boardDescription);

    /**
     * 删除board
     * @param boardId 模块id
     * @return 成功数
     */
    int deleteBoard(Long boardId);

    /**
     * 分页查询board
     * @param offset
     * @param limit
     * @return
     */
    List<Board> queryPageOfBoard(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 按模块名查找board
     * @param boardName
     * @return
     */
    List<Board> queryByName(String boardName);

    /**
     * 根据模块id查询模块
     * @param boardId
     * @return 模块
     */
    Board queryById(Long boardId);

    /**
     * 查询board包含item数
     * @param boardId
     * @return
     */
    int queryNum(Long boardId);

    /**
     * 修改板块信息（名称）
     * @param boardId
     * @param boardName
     * @return
     */
    int updateBoard(@Param("boardId") Long boardId, @Param("boardName") String boardName, @Param("boardDescription") String  boardDescription);
}

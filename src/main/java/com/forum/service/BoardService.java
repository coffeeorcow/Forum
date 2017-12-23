package com.forum.service;

import com.forum.dto.BoardInfo;
import com.forum.entity.Board;

import java.util.List;

/**
 * 和模块相关的服务
 */
public interface BoardService {
    /**
     * 添加模块
     * @param boardName
     * @param boardDescription
     */
    void addBoard(String boardName, String boardDescription);

    /**
     * 查询所有模块
     * @return 所有模块构成的表
     */
    List<Board> queryAllBoard();

    /**
     * 查询一页模块
     * @return 一页模块返回四个
     */
    List<BoardInfo> queryPageBoard();

    /**
     * 根据模块名查询模块
     * @param boardName
     * @return
     */
    List<BoardInfo> queryBoardByName(String boardName);

    /**
     * 删除模块
     * @param boardDelete
     */
    void deleteBoard(Long boardDelete);

    /**
     * 修改模块
     * @param board
     */
    void updateBoard(Board board);
}

package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/2 15:03
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {
}

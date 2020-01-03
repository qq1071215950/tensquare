package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/2 11:22
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public int selectCount(String userid, String friendid);

    @Modifying
    @Query("update Friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2")
    public void updateLike(String userid, String friendid, String islike);


    /**
     * 删除喜欢的好友
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query("delete from Friend f where f.userid=?1 and f.friendid=?2")
    public void deleteFriend(String userid, String friendid);
}
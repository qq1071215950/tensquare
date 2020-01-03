package com.tensquare.qa.dao;

import javafx.scene.chart.ValueAxis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /**
     * 最新回答
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY replytime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelid, Pageable pageable);

    /**
     * 最热门回答
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY reply DESC",nativeQuery = true)
    public Page<Problem> hostList(String labelid, Pageable pageable);

    /**
     * 等待回答
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? AND reply=0 ORDER BY createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelid, Pageable pageable);

}

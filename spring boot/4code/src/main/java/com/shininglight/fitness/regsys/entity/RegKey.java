package com.shininglight.fitness.regsys.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 22:43 2018/2/3 0003
 */
public class RegKey implements Serializable {

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "user_id")
    private Integer userId;
}

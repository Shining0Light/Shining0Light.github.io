package com.shininglight.fitness.regsys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 17:05 2018/2/3 0003
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "dead_date")
    private Date deadate;

    @Column(name = "game_date")
    private Date gameDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private Integer status;
}

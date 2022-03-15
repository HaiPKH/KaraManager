/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.sql.Time;
/**
 *
 * @author haiph
 */
public class Invoice {
    private int bid;
    private int rid;
    private Timestamp datecreated;
    private Timestamp timestarted;
    private Timestamp timeended;
    private Time timeelapsed;
    private int othercost;
    private int totalcost;

    public Invoice() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    public Timestamp getTimestarted() {
        return timestarted;
    }

    public void setTimestarted(Timestamp timestarted) {
        this.timestarted = timestarted;
    }

    public Timestamp getTimeended() {
        return timeended;
    }

    public void setTimeended(Timestamp timeended) {
        this.timeended = timeended;
    }

    public Time getTimeelapsed() {
        return timeelapsed;
    }

    public void setTimeelapsed(Time timeelapsed) {
        this.timeelapsed = timeelapsed;
    }

    public int getOthercost() {
        return othercost;
    }

    public void setOthercost(int othercost) {
        this.othercost = othercost;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(int totalcost) {
        this.totalcost = totalcost;
    }

}   


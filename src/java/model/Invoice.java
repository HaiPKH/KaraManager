/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.sql.Date;
/**
 *
 * @author haiph
 */
public class Invoice {
    private int bid;
    private int rid;
    private Date timestarted;
    private Date timeended;
    private Date timeelapsed;
    private int othercost;
    private int totalcost;

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

    public Date getTimestarted() {
        return timestarted;
    }

    public void setTimestarted(Date timestarted) {
        this.timestarted = timestarted;
    }

    public Date getTimeended() {
        return timeended;
    }

    public void setTimeended(Date timeended) {
        this.timeended = timeended;
    }

    public Date getTimeelapsed() {
        return timeelapsed;
    }

    public void setTimeelapsed(Date timeelapsed) {
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

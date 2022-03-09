/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author haiph
 */
public class Room {
    private int rid;
    private String name;
    private int priceperhour;
    private boolean isUsed;
    private int timestarted;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceperhour() {
        return priceperhour;
    }

    public void setPriceperhour(int priceperhour) {
        this.priceperhour = priceperhour;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public int getTimestarted() {
        return timestarted;
    }

    public void setTimestarted(int timestarted) {
        this.timestarted = timestarted;
    }
    
    
}

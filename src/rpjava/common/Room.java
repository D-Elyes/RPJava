/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 *
 * @author Florent BERLAND
 */
public class Room {
    
    private Room previousRoom;
    private ConnectedTo direction;
    private String story;
    
    public Room(){}
    public Room(Room previousRoom, ConnectedTo direction, String story){
        this.previousRoom = previousRoom;
        this.direction = direction;
        this.story = story;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    public ConnectedTo getDirection() {
        return direction;
    }

    public void setDirection(ConnectedTo direction) {
        this.direction = direction;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
    
    
    public enum ConnectedTo{
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }
}

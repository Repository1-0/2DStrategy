package core;

import java.awt.event.KeyEvent;

public class GameManager {
    private String[][] mapTiles;
    private Soldier[] soldierList;
    private int cursor_X, cursor_Y, dx, dy;
    private int soldierIndex = -1;
    
    public GameManager(String[][] mTiles, Soldier[] sList){
        mapTiles = mTiles;
        soldierList = sList;
        cursor_X = 0;
        cursor_Y = 0;
    }
    
    public void runGame(){
        while(true){
            
        }
    }
    
    public int getCursor_X() {
        return cursor_X;
    }

    public void setCursor_X(int cursor_X) {
        this.cursor_X = cursor_X;
    }

    public int getCursor_Y() {
        return cursor_Y;
    }

    public void setCursor_Y(int cursor_Y) {
        this.cursor_Y = cursor_Y;
    }
    
    public void adjustCursor_X(int dx){
        cursor_X += dx;
        if (cursor_X >= mapTiles.length){
            cursor_X = mapTiles.length - 1;
        }
        else if (cursor_X < 0){
            cursor_X = 0;
        }
        System.out.println("Cursor_X " + cursor_X);
    }
    
    public void adjustCursor_Y(int dy){
        cursor_Y += dy;
        if (cursor_Y >= mapTiles[0].length){
            cursor_Y = mapTiles[0].length - 1;
        }
        else if (cursor_Y < 0){
            cursor_Y = 0;
        }
        System.out.println("Cursor_Y " + cursor_Y);
    }
    
    private void selectSoldier(){
        for(int i = 0; i < soldierList.length; i++){
           Soldier soldier = soldierList[i];
           if (soldier.getPosX() == cursor_X && soldier.getPosY() == cursor_Y){
               soldierIndex = i;
               return;
           }
        }
        soldierIndex = -1;
    }
    
    private void moveSoldier(){
        if(soldierIndex >= 0){
            Soldier s = soldierList[soldierIndex];
            s.setPosX(cursor_X);
            s.setPosY(cursor_Y);
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            adjustCursor_X(-1);
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            adjustCursor_X(1);
        }

        if (key == KeyEvent.VK_UP) {
            dy = 1;
            adjustCursor_Y(-1);
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = -1;
            adjustCursor_Y(1);
        }
        
        if (key == KeyEvent.VK_ENTER) {
            if (soldierIndex < 0){
                selectSoldier();
            }
            else{
                moveSoldier();
                soldierIndex = -1;
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        
    }
}

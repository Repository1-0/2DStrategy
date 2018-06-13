package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{

    private final int B_WIDTH = 900;
    private final int B_HEIGHT = 600;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
      
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int scaleX = 0;
    private int scaleY = 0;
    private Timer timer;
    private String[][] mapTiles;
    private Soldier[] soldierList;
    private Image[][] mapImageList;
    private int x, y;
    private GameManager gm;

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        initBoard();
        gm = new GameManager(mapTiles,soldierList);
    }

    private void loadMap() {
        
        getMapInformation();
        mapImageList = new Image[mapTiles.length][mapTiles[0].length];
        scaleX = B_WIDTH / mapImageList.length;
        scaleY = B_HEIGHT / mapImageList[0].length;
        for(int i = 0; i < mapImageList.length; i++){
            for(int j = 0; j < mapImageList[0].length; j++){
                String imageFilePath = "src/images/" + mapTiles[i][j] + ".png";
                ImageIcon icon = new ImageIcon(imageFilePath);
                Image temp = icon.getImage();
                Image newImage = temp.getScaledInstance(scaleX, scaleY, Image.SCALE_FAST);
                mapImageList[i][j] = newImage;
            }
        }
        for(int i = 0; i < soldierList.length; i++){
            String imageFilePath = "src/images/" + soldierList[i].getSoldierImageName() + ".png";
            ImageIcon icon = new ImageIcon(imageFilePath);
            Image temp = icon.getImage();
            Image newImage = temp.getScaledInstance(scaleX, scaleY, Image.SCALE_FAST);
            soldierList[i].setImage(newImage);
        }
        
        
    }
    
    private void getMapInformation(){
        
        try{
            Scanner in = new Scanner(new File("src/maps/testmap.txt"));
            int mapWidth = Integer.parseInt(in.nextLine());
            int mapHeight = Integer.parseInt(in.nextLine());
            String[][] tileNames = new String[mapWidth][mapHeight];
            int currentRow = 0;
            
            while(in.hasNextLine() && currentRow < mapHeight){
                String line = in.nextLine();
                String[] row = line.split(" ");
                tileNames[currentRow] = row;
                currentRow++;
            }
            mapTiles = tileNames;
            
            int numSoldiers = Integer.parseInt(in.nextLine());
            soldierList = new Soldier[numSoldiers];
            int count = 0;
            while(in.hasNextLine() && count < numSoldiers){
                String[] soldierInfo = in.nextLine().split(" ");
                int x = Integer.parseInt(soldierInfo[0]);
                int y = Integer.parseInt(soldierInfo[1]);
                soldierList[count] = new Soldier(x, y, "soldier");
            }
            in.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println("Map not found");
            System.exit(1);
        }
        
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadMap();
        
        x = INITIAL_X;
        y = INITIAL_Y;
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 
                INITIAL_DELAY, PERIOD_INTERVAL);        
    
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawMap(g);
        drawSoldiers(g);
        drawCursor(g);
    }

    private void drawCursor(Graphics g){
        int x = 0;
        int y = 0;
        
        x = scaleX * gm.getCursor_X();
        y = scaleY * gm.getCursor_Y();
        
        g.drawRect(x, y, scaleX, scaleY);
    }
    
    private void drawMap(Graphics g) {
        int x = 0;
        int y = 0;
        for(Image list[] : mapImageList){
            for(Image image : list){
                g.drawImage(image, x, y, this);
                x += scaleX;
               
                Toolkit.getDefaultToolkit().sync();
            }
            x = 0;  y += scaleY;
        }
    }
    
    private void drawSoldiers(Graphics g){
        int x = 0;
        int y = 0;
        for(Soldier soldier : soldierList){
            x = soldier.getPosX() * scaleX;
            y = soldier.getPosY() * scaleY;
            g.drawImage(soldier.getImage(), x, y, this);
            Toolkit.getDefaultToolkit().sync();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(gm.getCursor_X()*scaleX, gm.getCursor_Y()*scaleY, scaleX, scaleY);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            
            repaint();
        }
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            gm.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            gm.keyPressed(e);
        }
    }
}

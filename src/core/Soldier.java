package core;


import java.awt.Image;


public class Soldier {
    private String soldierImageName;
    private Weapon equippedWeapon;
    private float health;
    private int posX;
    private int posY;
    private Image image;
    public Soldier(int x, int y, String imageName){
        posX = x;
        posY = y;
        soldierImageName = imageName;
    }

    /**
     * @return the equippedWeapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * @param equippedWeapon the equippedWeapon to set
     */
    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    /**
     * @return the health
     */
    public float getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(float health) {
        this.health = health;
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the soldierImage
     */
    public String getSoldierImageName() {
        return soldierImageName;
    }

    /**
     * @param soldierImage the soldierImage to set
     */
    public void setSoldierImageName(String soldierImageName) {
        this.soldierImageName = soldierImageName;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
}

package core;


public class Weapon {
    private String weaponName;
    private String weaponDescription;
    private int maxRange;
    private int capacity;
    private int maxDamage;

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * @param weaponName the weaponName to set
     */
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    /**
     * @return the weaponDescription
     */
    public String getWeaponDescription() {
        return weaponDescription;
    }

    /**
     * @param weaponDescription the weaponDescription to set
     */
    public void setWeaponDescription(String weaponDescription) {
        this.weaponDescription = weaponDescription;
    }

    /**
     * @return the maxRange
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * @param maxRange the maxRange to set
     */
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the maxDamage
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     * @param maxDamage the maxDamage to set
     */
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}

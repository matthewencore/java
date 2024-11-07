package Battle;
public class Knight {
    public String name = "Nicolas";
    private int healthPoint = 1140;
    private int damage = 100;
    private boolean isAlive = true;

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        if (this.healthPoint <= 0){
            this.healthPoint = 0;
        }
        this.healthPoint = healthPoint;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Knight() {}

    public Knight(String name) {
        this.name = name;
    }

    public Knight(int healthPoint, String name) {
        this.healthPoint = healthPoint;
        this.name = name;
    }

    public Knight(String name, int healthPoint, int damage) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.damage = damage;
    }

    public Knight(String name, int healthPoint, int damage, boolean isAlive) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.damage = damage;
        this.isAlive = isAlive;
    }

    public boolean checkHP() {
        if (this.healthPoint <= 0 || !this.isAlive) {
            setAlive(false);
            return isAlive();
        }
        return true;
    }

    public int attack() {
        return this.damage;
    }

    public void getAttack(int dmg) {
        int formulaAttack = getHealthPoint() - dmg;
        if(formulaAttack <= 0){
            setHealthPoint(0);
            return;
        }
        setHealthPoint(getHealthPoint() - dmg);
    }


}
package Week5;

public class Player {
    private String name;
    private int attack, defense, health;

    Player(String userName, int userAttack, int userDefense, int userHealth) {
        this.name = userName;
        this.attack = userAttack;
        this.defense = userDefense;
        this.health = userHealth;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void attack(Player opponent) {
        int overallDamage = this.attack - opponent.defense; 
        opponent.health = opponent.health - overallDamage;
    }
    
    public void setHealth(int health) {
        this.health = this.health = health;
    }
    
    public boolean isALive() {
        return this.health > 0;
    }
}

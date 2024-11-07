package Battle;

import java.util.Random;

public class Arena {
    public static void battle(Warrior w1, Knight k1) {
        System.out.printf("%s и %s вступили в бой", w1.name, k1.name);
        int round = 0;

        while (true) {
            Random rnd1 = new Random();
            int permissionOnDamage = rnd1.nextInt(2);
            round++;
            if (!w1.checkHP() && !k1.checkHP()) {
                System.out.println("Arena | Одновременно погибло два участника схватки...");
                break;
            } else if (!w1.checkHP()) {
                System.out.printf("Arena | %s погиб от рук %s", w1.name, k1.name);
                break;
            } else if (!k1.checkHP()) {
                System.out.printf("Arena | %s погиб от рук %s", k1.name, w1.name);
                break;
            }

            if (permissionOnDamage == 0) {
                k1.getAttack(w1.attack());
                System.out.printf("Arena Раунд:[%s] | %s ударил %s \n -> Текущее состояние здоровья: %s\n",
                        round, w1.name, k1.name, k1.getHealthPoint());
                continue;
            } else {
                w1.getAttack(k1.attack());
                System.out.printf("Arena Раунд:[%s] | %s ударил %s \n  -> Текущее состояние здоровья: %s\n",
                        round, k1.name, w1.name, w1.getHealthPoint());
                continue;
            }
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class GuesNumber {
    private int lifeGame = 3;
    private int upBorder = 0;
    private int downBorder = 0;


    public GuesNumber(int upBorder, int downBorder) {
        this.upBorder = upBorder;
        this.downBorder = downBorder;
    }

    public GuesNumber(int lifeGame,int upBorder,int downBorder) {
        this.lifeGame = lifeGame;
        this.upBorder = upBorder;
        this.downBorder = downBorder;
    }

    public void gameRnd() {
        Random rnd = new Random();
        int guesNumber = 0;
        int lifeGame = this.lifeGame;


        if (this.upBorder != 0 && this.downBorder != 0){
            guesNumber = rnd.nextInt(this.upBorder, this.downBorder);
        } else {
            System.out.println("Не заданы границы, либо они нулевые.");
            return;
        }

        while (true){
            if (lifeGame == 0){
                System.out.println("Попытки закончились... Игра окончена.");
                break;
            }
            Scanner sc = new Scanner(System.in);
            System.out.printf("Осталось жизней [%S] Границы[x:%s y:%s] :> ",lifeGame,this.upBorder, this.downBorder);
            int inputNum = sc.nextInt();

            if (inputNum > guesNumber){
                System.out.println("Рандомное число меньше...");
                --lifeGame;
                continue;
            } else if (inputNum < guesNumber) {
                System.out.println("Рандомное число больше...");
                --lifeGame;
                continue;
            } else  {
                System.out.printf("Вы угадали число! Загаданное: [%s]",guesNumber);
                break;
            }
        }
    }

}

package org.example.kotiki._2023_03_17.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 1. Generator--для генерации участников,
 * имен участников, и листов Action.
 * Для генерации имен участников использовать
 * библиотеку Faker
 *
 * 2. Организовать игру таким образом, что бы
 * все сыграли со всеми 5 игр
 *
 * 3. Вывести на экран количество побед каждого участника
 * начиная с лидера
 *
 * 4. В методе main должен быть один метод
 * который принимает в качестве параметра
 * количество участников и ВСЕ!
 */
public class EXC {
    public static void main(String[] args) {
        //play(25)
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> P1AL = new ArrayList<>();
        P1AL.add(Action.SCISSORS);
        P1AL.add(Action.SCISSORS);
        P1AL.add(Action.STONE);
        P1AL.add(Action.SCISSORS);

        List<Action> P2AL = new ArrayList<>();
        P2AL.add(Action.STONE);
        P2AL.add(Action.SCISSORS);
        P2AL.add(Action.STONE);
        P2AL.add(Action.PAPER);

        new Participant("ParticipantOne", P1AL, exchanger);
       // new Participant("ParticipantTwo", P2AL, exchanger);

    }
}

enum Action {
    STONE,
    SCISSORS,
    PAPER
}

class Participant extends Thread{
    private String name;
    private List<Action> actionList;
    private Exchanger<Action> exchanger;

    public Participant(String name, List<Action> actionList, Exchanger<Action> exchanger) {
        this.name = name;
        this.actionList = actionList;
        this.exchanger = exchanger;
        this.start();
    }

    private void getWinner(Action P1, Action P2) {
        if (P1 == Action.PAPER && P2 == Action.STONE ||
            P1 == Action.SCISSORS && P2 == Action.PAPER ||
            P1 == Action.STONE && P2 == Action.SCISSORS) {
            System.out.println("[" + name + ": WON!]");
        }
    }

    @Override
    public void run() {
        Action rep;
        for (Action action : actionList) {
            try {
                rep = exchanger.exchange(action);
                getWinner(action, rep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
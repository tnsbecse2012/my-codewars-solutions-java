package main.java.codewars.kata.kyu5;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private static Random random = new Random();

    public static void main(String[] args) {

        try {
            System.out.println(play(5, true)); // "You didn't win
            System.out.println(play(7, true)); // "You didn't win
            System.out.println(play(12, true)); // "You didn't win
            System.out.println(play(13, true)); // "You didn't win
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player(int cakes) {
    }

    // Decide who move first - player or opponent (true if player)
    public boolean firstMove(int cakes) {
        if (cakes > 2) {
            if (cakes % 4 != 2) {
                return true;
            }
        }
        return false;
    }

    // Decide your next move
    public int move(int cakes, int last) {

        int restCakes = cakes % 4;
        if (restCakes < 3) {
            return 3;
        } else {
            return 1;
        }

    }

    public static boolean play(int cakes, boolean debug) throws Exception {
        if (cakes < 0) {
            throw new Exception("At least one cake required");
        }
        Player player = new Player(cakes);
        // First, ask the player if they wish to move first.
        boolean first = player.firstMove(cakes);
        int last = 0;
        int x = 2;
        if (debug) {
            System.out.println(plural(cakes) + " on the table.  You decided to move " + (first ? "first" : "last"));
        }
        // Now, let the game begin.
        while (true) {
            // My move
            if (!first) {
                x = 3 - x;
                ArrayList<Integer> allow = new ArrayList<Integer>();
                for (int i = 1; i < 4; i++) {
                    if (cakes >= i && i != last) {
                        allow.add(i);
                    }
                }
                if (allow.isEmpty()) {
                    throw new Exception("Game over: stalemate");
                }
                last = sample(allow);
                cakes -= last;
                if (cakes == 0) {
                    if (debug) {
                        System.out.println("Yum!  I ate the last cake, you win!");
                    }
                    return true;
                }
                if (debug) {
                    System.out.println("I ate " + plural(last) + ", " + plural(cakes) + " still left");
                }
            } else {
                first = false;
            }
            // Your move
            if (cakes == 1 && last == 1) {
                if (debug) {
                    System.out.println("I lead you to stalemate, so you are the winner!");
                }
                return true;
            }
            int move = player.move(cakes, last);
            if (move > 4) {
                throw new Exception("Error: You are so greedy!  Don't try to eat more than 3 cakes.");
            }
            if (move < 1) {
                throw new Exception("Error: You have to eat at least one cake");
            }
            if (move == last) {
                throw new Exception("Error: You cannot eat the same quantity of cakes as you opponent on previous move");
            }
            if (move > cakes) {
                throw new Exception("Error: Don't try to eat more cakes than are left on the table");
            }
            if (move == cakes) {
                throw new Exception("Game over: You ate the last cake!");
            }
            cakes -= move;
            last = move;
            if (debug) {
                System.out.println("You ate " + plural(move) + ", " + plural(cakes) + " still left");
            }
        }
    }

    private static int sample(ArrayList<Integer> arr) {
        return arr.get(random.nextInt(arr.size()));
    }

    private static String plural(int n) {
        return n == 1 ? "1 cake" : n + " cakes";
    }
}

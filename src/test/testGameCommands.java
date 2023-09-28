package test;

import java.util.*;

public class testGameCommands {

    public static void main(String[] args) {
        Map<Integer, String> moves = new HashMap<Integer, String>();
        Map<String, Map<Integer, String>> player_moves = new HashMap<String, Map<Integer, String>>();
        //map.put("name", "demo");
        //map.put("fname", "fdemo");
        // etc
        //System.out.println();
        //map.get("name"); // returns "demo"
        int turn = 0;
        //h black 1
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();

                String[] commandParts = input.split(" ");
                String baseCommand = commandParts.length > 0 ? commandParts[0] : null;
                String player = commandParts.length > 1 ? commandParts[1] : null;
                Integer n_move = commandParts.length > 2 ? Integer.parseInt(commandParts[2]) : null;

                moves.put(turn, "a move");
                player_moves.put(player, moves);
                if (turn != 0) {
                    System.out.println(n_move);
                    if (n_move != null) {
                        assert false;
                        System.out.println(player.substring(0, 1).toUpperCase() + player.substring(1) + " moves: " + player_moves.get(player).get(n_move));
                    } else if (player != null) {
                        System.out.println(player.substring(0, 1).toUpperCase() + player.substring(1) + " move: " + player_moves.get(player).toString());
                    } else {
                        System.out.println("Black moves: " + player_moves.get("black").toString() + "\n" + "White moves: " + player_moves.get("white").toString());
                    }
                }
                turn++;
                if (turn == 10)
                    break;
            }
        }
    }
}

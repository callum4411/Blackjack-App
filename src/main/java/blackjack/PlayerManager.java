package blackjack;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private static final String RELATIVE_FILE_PATH = "src/main/resources/blackjack/players.txt";
    private static final File FILE = Paths.get(RELATIVE_FILE_PATH).toFile();
    private List<Player> players;

    public PlayerManager() {
        players = loadPlayers();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player createPlayer(String name) {
        Player newPlayer = new Player(name);
        players.add(newPlayer);
        savePlayers();
        return newPlayer;
    }

    public void savePlayers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(players);
        } catch (IOException e) {
            System.out.println("Error saving players: " + e.getMessage());
        }
    }

    public List<Player> loadPlayers() {
        if (!FILE.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (List<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading players: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void updatePlayer(Player player) {
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                p.setWins(player.getWins());
                p.setLosses(player.getLosses());
                break;
            }
        }
        savePlayers();
    }
}

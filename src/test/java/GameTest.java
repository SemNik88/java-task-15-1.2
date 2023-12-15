import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testRegister() {
        Game game = new Game();

        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 20);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.players.size());
    }

    @Test
    public void testRound() throws NotRegisteredException {
        Game game = new Game();

        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 20);

        game.register(player1);
        game.register(player2);

        int result = game.round("Player 1", "Player 2");
        Assertions.assertEquals(2, result);

        result = game.round("Player 2", "Player 1");
        Assertions.assertEquals(1, result);

        result = game.round("Player 1", "Player 1");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testRoundWithNotRegisteredPlayer() {
        Game game = new Game();

        try {
            game.round("Player 1", "Player 2");
        } catch (NotRegisteredException e) {
            Assertions.assertEquals("Player 1 not registered", e.getMessage());
        }
    }
}


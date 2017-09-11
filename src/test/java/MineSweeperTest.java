import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineSweeperTest {
    @Test
    public void shouldReturnCorrectHintFieldWhenGiven2x2MineField() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(".*\n..");

        String hintField = mineSweeper.getHintField();

        assertEquals("1*\n11", hintField);
    }
}

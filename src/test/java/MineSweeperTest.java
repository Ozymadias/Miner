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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGivenMineFieldWithImproperCharacter() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(".*\n.w");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGivenNotRectangularMineField() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(".*\n...");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGivenNotRectangularMineField2() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(".*\n..\n.");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenEmptyString() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField("");

        String hintField = mineSweeper.getHintField();

        assertEquals("", hintField);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionWhenSetMineFieldWasNotCalled() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();

        mineSweeper.getHintField();
    }
}

package edu.rpi.legup.puzzle.battleship;

import edu.rpi.legup.model.gameboard.Element;
import edu.rpi.legup.puzzle.treetent.TreeTentType;

public class BattleShipClue extends Element
{

    private BattleShipCellType type;

    public BattleShipClue(int value, int index, BattleShipCellType type)
    {
        super(value);
        this.index = index;
        this.type = type;
    }

    /**
     * Gets the int value that represents this element
     *
     * @return int value
     */
    @Override
    public Integer getData()
    {
        return (Integer) super.getData();
    }

    public static String colNumToString(int col)
    {
        final StringBuilder sb = new StringBuilder();
        col--;
        while(col >= 0)
        {
            int numChar = (col % 26) + 65;
            sb.append((char) numChar);
            col = (col / 26) - 1;
        }
        return sb.reverse().toString();
    }

    public static int colStringToColNum(String col)
    {
        int result = 0;
        for(int i = 0; i < col.length(); i++)
        {
            result *= 26;
            result += col.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public BattleShipCellType getType()
    {
        return type;
    }

    public void setType(BattleShipCellType type)
    {
        this.type = type;
    }

    public BattleShipClue copy()
    {
        return null;
    }
}
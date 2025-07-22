package com.technogise.assesment.logic;

public class GameLogicFactory {
    public static GameLogic getDefaultGameLogic() {
        return new DefaultGameLogic();
    }
}

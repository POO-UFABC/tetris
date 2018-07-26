package base;

import java.util.Random;

public class Randomizer{
    
    //função retorna um dos tipos presentes de formas
    public PlayableStructure getRandomPiece(int posX, int posY){
        Random r = new Random ();
        PlayableStructure s;
        int val = r.nextInt(7);
        switch (val){
            case 0:
                s = new PlayableStructureInvL(posX, posY);
                return s;
            case 1:
                s = new PlayableStructureInvZ(posX, posY);
                return s;
            case 2:
                s = new PlayableStructureL(posX, posY);
                return s;
            case 3:
                s = new PlayableStructureZ(posX, posY);
                return s;
            case 4:
                s = new PlayableStructureLine(posX, posY);
                return s;
            case 5:
                s = new PlayableStructureSquare(posX, posY);
                return s;
            case 6:
                s =  new PlayableStructureT(posX, posY);
                return s;
        }
        return null;
    }
}

import stanford.karel.*;
public class Homework extends SuperKarel {
    public  int mc=0;
    public void run() {
        int r,c;
        c=countRoad();
        turnLeft();
        r=countRoad();
        turnLeft();
        if (c!=1 && c!=2 && r!=1 && r!=2) {
            //odd column
            //even row
            if (c % 2 == 1) {
                moveHalf(c);
                Split(r);
                moveHalf(c);
                //odd row
            }
            //even column
            else {
                doubleSplit(c,r);

            }
            if (r % 2 == 1) {
                moveHalf(r);
                Split(c);
                moveHalf(r);
            }
            //even row
            else {
                doubleSplit(r,c);
            }

            if (facingWest()){
                while (frontIsClear()){move();mc++;}
                turnLeft();
                while (frontIsClear()){move();mc++;}
            }
        }
        else{
            punnySplit(r,c);
        }
       // System.out.println(mc);
    }
    private void doubleSplit(int first, int second) {
        moveHalf(first-1);
        Split(second);
        turnAround();
        move();
        mc++;
        turnRight();
        Split(second);
        moveHalf(first-1);
    }
    private void Split(int x) {
        while(x-->0 && frontIsClear()){
            if(!beepersPresent())
                putBeeper();
            move();
            mc++;
        }
        if(!beepersPresent())
            putBeeper();
        turnLeft();
    }
    private void punnySplit(int r, int c) {
        if (r == 1 && c != 1 && c != 2)
            PSplit(c, false);
        else if (r == 2 && c != 1 && c != 2) {
            PSplit(c, false);
            turnAround();
            while (frontIsClear()){ move();mc++;}
            turnRight();
            move();
            mc++;
            turnRight();
            PSplit(c, false);

        } else if (c == 1 && r != 1 && r != 2)
            PSplit(r, true);
        else if (c == 2 && r != 1 && r != 2) {
            PSplit(r, true);
            turnAround();
            while (frontIsClear()) {move();mc++;}
            turnLeft();
            move();
            mc++;
            PSplit(r, true);
        } else {
            if (c == 2 && r == 2) {
                putBeeper();
                move();
                mc++;
                turnLeft();
                move();
                mc++;
                putBeeper();
            } else if (c!=r) {
                putBeeper();
                if (r==2){ turnLeft();move();mc++;}
                else {move();mc++;}
            }
        }
    }
    private void PSplit(int w , boolean ch) {
        int mod = w % 4;
        int x = 4;
        int q = 0;
        if (mod == 3) q = 1;
        int count = w / 4 + q - 1;
        // Vertical split
        if (ch) turnLeft();
        if (w < 7) {
            int c = 0;
            while (frontIsClear()) {
                move();
                mc++;
                if (c % 2 == 0)
                    putBeeper();
                c++;
            }
        } else {
            while (x-- > 0) {
                while (count-- > 0) {
                    if (frontIsClear()){ move();mc++;}
                }
                if (mod != 3 || x != 0)
                    putBeeper();
                count = w / 4 + q;
            }
            while (frontIsClear()) {
                move();
                mc++;
                putBeeper();
            }

        }
    }
    private void moveHalf(int y) {
        int x=y/2;
        while (x-->0){
            move();
            mc++;
        }
        turnLeft();
    }
    private int countRoad(){
        int c=1;
        while (frontIsClear()) {
            move();
            mc++;
            c++;
        }
        return c;
    }
}

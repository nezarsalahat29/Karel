import stanford.karel.SuperKarel;


public class Homework extends SuperKarel {

    /* You fill the code here */
    public void run() {
        int r,c;
        c=countRoad();
        turnLeft();
        r=countRoad();
        turnLeft();
        if(c%2==1 && r%2==1 && c!=1){
            moveHalf(c);
            Split(r);
            moveHalf(c);
            moveHalf(r);
            Split(c);
            moveHalf(r);
        } else if (c==r && c!=1 && c!=2) {
            zigzagTR(c-1);
            turnRight();
            while(frontIsClear())
                move();
            turnRight();
            zigzagTL(c-1);

        }
        else if(c%2==0 && r%2==0 ){
            //doubleSplit(c,r);
            moveHalf(c);
            Split(r);
            move();
            //moveHalf(c);
            Split(c);
            //moveHalf(r);
        }

        //turnLeft();
    }

    private void doubleSplit(int c, int r) {

    }

    /*
    zigzag Top Left
    it is making a zigzag putting beepers
    */
    private void zigzagTL(int c) {
        if(!beepersPresent())
            putBeeper();
        while(c-->0){
            if(!beepersPresent())
                putBeeper();
            move();
            turnRight();
            move();
            turnLeft();
        }
        if(!beepersPresent())
            putBeeper();
    }
    /*
        zigzag Top Right
        it is making a zigzag putting beepers
        */
    private void zigzagTR(int c) {
        if(!beepersPresent())
            putBeeper();
        while(c-->0){

            move();
            turnLeft();
            move();
            turnRight();
            if(!beepersPresent())
                putBeeper();
        }

    }

    /*
        Split the map by straight beepers
    */
    private void Split(int x) {
        while(x-->0 && frontIsClear()){
            if(!beepersPresent())
                putBeeper();
            move();
        }
        if(!beepersPresent())
            putBeeper();
        turnLeft();
    }
    /*
        moveHalf
        move the robot to halfway of odd map
    */
    private void moveHalf(int y) {
        int x=y/2;
        while (x-->0){
            move();
        }
        turnLeft();
    }
    /*
        count number of row or column
    */
    private int countRoad(){
        int c=1;
        while (frontIsClear()) {
            move();
            c++;
        }
        return c;
    }
}

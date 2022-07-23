/*
 * File: BlankKarel.java
 * ---------------------
 * This class is a blank one that you can change at will.
 */

import stanford.karel.*;

public class BlankKarel extends SuperKarel {
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

		//turnLeft();
	}

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

	private void moveHalf(int y) {
		int x=y/2;
		while (x-->0){
			move();
		}
		turnLeft();
	}

	private int countRoad(){
		int c=1;
		while (frontIsClear()) {
			move();
			c++;
		}
		return c;
	}
}


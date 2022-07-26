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
			turnAround();
			while (frontIsClear())
				move();
			turnAround();

		}  else if(c%2==0 && r%2==0 && !(c==2 || r==2)){
			//doubleSplit(c,r);
			/*
			*
			*
			moveHalf(c);
			Split(r);
			moveHalf(c);
			moveHalf(r);
			Split(c);
			moveHalf(r);
			* */
			moveHalf(c-1);
			Split(r);
			turnAround();
			move();
			turnRight();
			Split(r);
			moveHalf(c-1);
			//turnAround();
			moveHalf(r-1);
			Split(c);
			turnAround();
			move();
			turnRight();
			Split(c);
			moveHalf(r-1);
		}
		else if (c==2 || r ==2){
			if(c==2) {
				while(r>0){
					if (frontIsClear()) {
						zigzagTR(1);
						if(--r==0) break;
					}
					turnAround();
					if (frontIsClear()){
						zigzagTL(1);
						if(--r==0) break;
					}

					turnAround();

				}
				pickBeeper();
			}else {
				while(c-->0) {

					zigzagTR(1);
					turnRight();
					while (frontIsClear())
						move();
					//	}\
					if (--c == 0) break;

					turnLeft();
					if (frontIsClear())
						move();


				}

				turnAround();
				if (frontIsClear())
					move();
				if (beepersPresent() && c%2==1)
					pickBeeper();
			}

		}



		//turnLeft();
	}


	private void zigzagTL(int c) {
		if(!beepersPresent())
			putBeeper();
		while(c-->0){
			if(!beepersPresent())
				putBeeper();
			if (frontIsClear())
				move();
			turnRight();
			if (frontIsClear())
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

			if (frontIsClear())
				move();
			turnLeft();
			if (frontIsClear())
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



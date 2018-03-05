package JCLD;
import robocode.*;
import java.awt.Color;

//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TeamSupport - a robot by James Domingo, Diane Margo
 */
public class TeamSupport extends Robot
{
	int i;
	public void run() {
		// Initialization of the robot should be put here
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setColors(Color.red,Color.red,Color.red); //Blue body,gun,radar
		
		//immediately rushes to a wall
		for(i = 0; i<1; i++){
		back(1000);
		}
		
		while(true) {
		ahead(50);
		turnGunRight(360);
		turnRight(60);
		back(50);
	}
}


	//Method that is called when our robot hits another robot
	public void onHitRobot(HitRobotEvent e){
      if (e.getBearing() > -90 && e.getBearing() <= 90) {
           back(100);
		   turnLeft(90);
       } else {
           ahead(100);
		   turnLeft(90);
       }
	}
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	//saves firepower if target is too far
    	if (e.getDistance() < 250) {
			fire(3);
       }
	   if(e.getDistance() >= 250 && e.getDistance() < 400){
		   fire(2);
	   }if(e.getDistance()> 400){
           fire(1.5);
       }else{
		   fire(1);
	   }
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		//makes it harder to get hit after getting shot
		back(75);
		turnRight(45);
		ahead(75);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	
	public void onHitWall(HitWallEvent e) {
		//Hovers near the wall
		ahead(50);
		turnRight(180);
		back(50);
	}
		
}
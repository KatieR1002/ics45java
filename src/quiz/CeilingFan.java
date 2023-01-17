package quiz;

public class CeilingFan {
public int speed;
public boolean isLightOn;

public CeilingFan(int s) { // ceiling fan created when powered on
speed = s; // 0=off, 1=low, 2=medium, 3=high
isLightOn = true;
}

public void speedCordPulled() { // called when user pulls speed cord
speed = (speed + 1) % 4;
}

public void lightCordPulled() { // called when user pulls light cord
isLightOn = !isLightOn;
}
}



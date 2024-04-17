package game;

public class Time implements Runnable{
	int addTime = 5, curTime = 0;
	public Time() {
	}
	@Override
	public void run() {
		try {
			while(true) {
				if(!Resource.stop) {
					if(addTime <= curTime) {
						curTime = 0;
						GameHelper.GamePanAdd();
						GameHelper.PanRepaint(Resource.nowStage);
					}
					curTime++;
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {}
	}
	
	
}
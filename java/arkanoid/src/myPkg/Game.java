package myPkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Game{
	private Paddle paddle;
	private List<Ball> balls;
	private List<Box> box;
	private List<Drop> drop;
	private ExecutorService exec;
	private int score;
	private int live;
	private boolean bonusStick;
	
	public Game(){
		setPaddle(new Paddle(425,650,200,10));
		drop = new LinkedList<Drop>();
		balls = new ArrayList<Ball>();
		box = new LinkedList<Box>();
		live = 3;
		bonusStick = false;
		
		balls.add(new Ball());
		balls.add(new Ball(400,703,7,4,-5));
			
		
		for(int i=0;i<19;i++)
			box.add(new Box(50*i + 35,50, 50,15));
		for(int i=0;i<19;i++)
			box.add(new Box(50*i + 35,65, 50,15));
		exec = Executors.newCachedThreadPool();
//		exec.execute(balls.get(0));
//		exec.execute(balls.get(1));
		for(int i=0;i<balls.size();i++)
			exec.execute(balls.get(i));
		
	}
	public void stickOn(int ballIndex, int paddleX){
		balls.get(ballIndex).pause();
		balls.get(ballIndex).setStick(true);
		balls.get(ballIndex).setPaddleX(paddleX);
	}
	public void stickOff() {
		for(int i=0; i<balls.size();i++)
			if(balls.get(i).isPaused()){
				balls.get(i).pause();
				balls.get(i).setStick(false);
			}
	
	}
	
	public void lenghtenPaddle(){
		paddle.setWidth(paddle.getWidth() + 30);
//		paddle.setR(paddle.getR() + 10);
	}
	
	public void shortenPaddle(){
		paddle.setWidth(paddle.getWidth() - 30);
//		paddle.setR(paddle.getR() - 30);
	}
	
	public void increaseSpeed(){
		for(int i=0;i<balls.size();i++){
			if(balls.get(i).getVy() > 0)
				balls.get(i).setVy(balls.get(i).getVy() + 2);
			else
				balls.get(i).setVy(balls.get(i).getVy() - 2);
		}
			
	}
	
	public void decreaseSpeed(){
		for(int i=0;i<balls.size();i++){
			if(balls.get(i).getVy() > 0)
				balls.get(i).setVy(balls.get(i).getVy() - 3);
			else
				balls.get(i).setVy(balls.get(i).getVy() + 3);
		}
			
	}
	
	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;		
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public List<Box> getBox(){
		return box;
	}

	public List<Ball> getBall() {
		return balls;
	}
	public List<Drop> getDrop() {
		return drop;
	}

	public void setDrop(List<Drop> drop) {
		this.drop = drop;
	}

	public void pause(){
		for(int i=0;i<balls.size();i++)
			balls.get(i).pause();
	}
	public void destroy(int x){
		drop.add(new Drop(box.get(x).getX(), box.get(x).getY()));
		box.remove(x);
		exec.execute(drop.get(drop.size()-1));	
	}
	public void collectDrop(Drop drop){
		
	}
	public void readGame(){
//		File file = new File("")
	
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public void subLive() {
		this.live--;		
	}
	public void addLive() {
		this.live++;
	}

	public void addScore(int i) {
		this.score += i;
		
	}
	
	public void addBall(){
		balls.add(new Ball());
		exec.execute(balls.get(balls.size()-1));
		if(balls.size() == 1){
			balls.get(0).setX(paddle.getX()+(int)((double)paddle.getWidth()/2));
			this.stickOn(0, paddle.getX());
			
		}
		
	}
	public boolean isBonusStick() {
		return bonusStick;
	}
	public void setBonusStick(boolean bonusStick) {
		this.bonusStick = bonusStick;
	}
	
	
}

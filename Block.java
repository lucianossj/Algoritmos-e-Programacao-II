package app;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Rect;
import com.senac.SimpleJava.Graphics.Sprite;

public class Block extends Sprite {

	private int lifes;
	private int points;
	private boolean alive = true;
	
	public Block(Color color, int life, int points){
		
		super(15, 8, color);
		setLifes(life);
		setPoints(points);
		
	}
	
	public void setLifes(int lifes){
		
		this.lifes = lifes;
		
	}
	
	public int getLifes(){
		
		return lifes;
		
	}
	
	public void setPoints(int points){
		
		this.points = points;
		
	}
	
	public int getPoints(){
		
		return points;
		
	}
	
	public boolean bateu(Ball ball){
		// Se o bloco nao esta vivo, nao pode bater...
		if (!alive)
			return false;
		
		Point pos=ball.getPosition();
		int raio=ball.getRaio();
		
		Rect rect=getBounds();
		int top = rect.y;
		int bottom = rect.y + rect.height;
		int left = rect.x;
		int right = rect.x + rect.width;
		
		if (pos.x-raio > right) {
			
			return false;
		}
		
		else if(pos.x+raio < left) {
		
			return false;
			
		}
		
		else if(pos.y+raio < top) {
			
			return false;
			
		}
		
		else if(pos.y-raio > bottom) {
			
			return false;
			
		} else {
		
			lifes = lifes - 1;
		
			if(lifes == 0){
			
				alive = false;
			
			}
			
		}
		
		return true;
		
	}

	@Override
	public void draw(Canvas canvas) {

		if (alive)
			super.draw(canvas);
		
	}
	
}

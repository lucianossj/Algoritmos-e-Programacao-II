package app;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Rect;
import com.senac.SimpleJava.Graphics.Sprite;

public class Paddle extends Sprite {
	
	public Paddle(int height, int width, Color color){

		super(20,3,color);
		
	}
	
	public boolean bateu(Ball ball){
		
		Point pos 	= ball.getPosition();
		int raio	= ball.getRaio();
		
		Rect rect	= getBounds();
		int top 	= rect.y;
		int left 	= rect.x;
		int right 	= rect.x + rect.width;
		
		if(pos.y+raio > top && pos.x+raio < left && pos.x-raio > right ) {
			
			return true;
			
		}
		
		if(pos.y+raio > top && pos.x+raio > left && pos.x-raio < right ) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public void draw(Canvas canvas) {
		
		super.draw(canvas);
		
	}

}

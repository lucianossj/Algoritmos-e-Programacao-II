/*
 * Trabalho - Arkanoid - Algoritmos de Porgramação II
 * 
 * Luciano da Silva Santos Junior
 * 18/09/2016 
 * 
 * */

package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {

	//Objetos da tela
	
	private Ball ball;
	private Paddle paddle;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private Wall wallL;
	private Wall wallR;
	private Wall top;
	
	//Posicao na tela
	
	private int deltaY = 1;
	private int deltaX = 1;
	
	//Pontuacao do jogo
	
	private int lifes = 6;
	private int score = 0;
	private int highScore = 0;
	
	//Dificuldade e Estágios
	private int frames = 70;
	private int stage = 1;
	private int stage1Blocks = 72;
	private int stage2Blocks = 27;
	private int stage3Blocks = 84;
	
	private String win = "YOU WIN!!";
	
	
	@Override
	protected void draw(Canvas canvas) {

		canvas.clear();
		
		for(Block block: blocks){
			
			block.draw(canvas);
			
		}
		
			ball	.draw(canvas);
			paddle	.draw(canvas);
			wallL	.draw(canvas);
			wallR	.draw(canvas);
			top		.draw(canvas);
			
			canvas.putText(10, 0, 10, "Score: " +score);
			canvas.putText(80, 0, 10, "High Score: "+highScore);
			canvas.putText(210, 0, 10, "Lifes: "+lifes);
	        canvas.putText(210, 170, 10, "Stage: "+stage);
	        
	        if(lifes == 0){
	        	
	        	blocks.clear();
	        	
	        	canvas.putText(50, 100, 10, "GAME OVER! You lost! Try again.");
	        	canvas.putText(60, 110, 10, "Press 'Enter' to continue...");
	        	
	        }
	        
	        if(stage3Blocks == 0){
	        	
	        	canvas.putText(5, 50, 50, win);
	        	
	        }
	}
	
	@Override
	protected void setup() {

		this.setFramesPerSecond(frames);
		this.setResolution(Resolution.MSX);
		
		ball = new Ball();
		ball.setPosition(100,180);
		
		paddle = new Paddle(20,3, Color.BLACK);
		paddle.setPosition(100,185);
		
		wallL 	= new Wall(Color.BLACK, 600, 1);
		wallR 	= new Wall(Color.BLACK, 600, 1);
		top 	= new Wall(Color.BLACK, 1, 600);
		
		wallL.setPosition(0,0);
		wallR.setPosition(255,0);
		top.setPosition(0,0);
		
		if(stage1Blocks > 0){
			
			stage1();
			
		} else if(stage1Blocks == 0){
			
			stage2();
			stage1Blocks = -1;
			
		} else if (stage2Blocks == 0){
			
			stage3();
			stage2Blocks = -1;
			
		} else if (stage3Blocks == 0){
			
			ball.setPosition(100,180);
			
			deltaX = 0;
			deltaY = 0;
			
			bindKeyPressed("ENTER", new KeyboardAction() {
				@Override
				public void handleEvent() {
		
					blocks.clear();
					
					deltaX = 1;
					deltaY = 1;
					
					stage1Blocks = 72;
					stage2Blocks = 27;
					stage3Blocks = 96;
					
					setup();
					
					if(score > highScore){
						
						highScore = score;
						
					}
					
					score = 0;
					lifes = 6;
					frames = 70;
					
				}
			});
			
			this.setFramesPerSecond(frames);
			
		}
		
		
		bindKeyPressed("LEFT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.move(-10, 0);
			}
		});
		bindKeyPressed("RIGHT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.move(10, 0);
			}
		});

	}

	public void stage1(){
		
		stage = 1;
		
		int positionY = 15;
		
		for(int blockRows = 0; blockRows <= 8; blockRows++){
			
			int positionX = 10;
			
			for(int blockCols = 0; blockCols < 12; blockCols++){
				
				if(positionY == 15){
					
				   Block block = new Block (Color.BLUE, 3, 100);
				   block.setPosition(positionX, positionY);
				   blocks.add(block);
				   
				}
				
				if(positionY == 25){
						
					Block block = new Block (Color.YELLOW, 2, 50);
					block.setPosition(positionX, positionY);
					blocks.add(block);
					
				}
				
				if(positionY == 35){
					
					Block block = new Block (Color.GREEN, 1, 20);
					block.setPosition(positionX, positionY);
					blocks.add(block);
					
				}
				
				if(positionY == 45){
					
					Block block = new Block (Color.BLACK, 1, 20);
					block.setPosition(positionX, positionY);
					blocks.add(block);
					
				}
				
				if(positionY == 55){
					
					Block block = new Block (Color.CYAN, 1, 20);
					block.setPosition(positionX, positionY);
					blocks.add(block);
					
				}

				if(positionY == 65){
					
					Block block = new Block (Color.RED, 1, 20);
					block.setPosition(positionX, positionY);
					blocks.add(block);
					
				}
														
				positionX = positionX + 20;
			}
			
			positionY = positionY + 10;
			
		}
		
	}

	public void stage2(){
	
		stage = 2;
		
		int positionY = 15;
		int positionX = 10;
	
		for(int blockRows = 0; blockRows < 5; blockRows++){
			
			Block block = new Block (Color.BLUE, 3, 100);
			block.setPosition(positionX, positionY);
			blocks.add(block);
				
			positionY = positionY + 10;
			
		}
		
		positionY 	= 25;
		positionX 	= positionX + 20;
		
		for(int blockRows = 0; blockRows < 4; blockRows++){
		
			Block block = new Block (Color.YELLOW, 2, 50);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionY = positionY + 10;
		
		}
		
		positionY 	= 35;
		positionX 	= positionX + 20;
		
		for(int blockRows = 0; blockRows < 3; blockRows++){
			
			Block block = new Block (Color.GREEN, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionY = positionY + 10;
		
		}
		
		positionY 	= 45;
		positionX 	= positionX + 20;
	
		for(int blockRows = 0; blockRows < 2; blockRows++){
			
			Block block = new Block (Color.CYAN, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionY = positionY + 10;
		
		}
		
		positionY 	= 55;
		positionX 	= positionX + 20;
	
		for(int blockRows = 0; blockRows < 1; blockRows++){
			
			Block block = new Block (Color.BLACK, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionY = positionY + 10;
		
		}
		
		positionY = 65;
		positionX = 10;
		
		for(int blockRows = 0; blockRows < 11; blockRows++){
			
			Block block = new Block (Color.GRAY, 5, 5);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		Block block = new Block (Color.RED, 1, 20);
		block.setPosition(positionX, positionY);
		blocks.add(block);
		
	}
	
	public void stage3(){
		
		stage = 3;
		
		int positionY = 15;
		int positionX = 10;
		
		for(int blockCols = 0; blockCols < 12; blockCols++){
				
			Block block = new Block (Color.BLUE, 3, 100);
			block.setPosition(positionX, positionY);
			blocks.add(block);
				
			positionX = positionX + 20;
				
		}
			
		positionY = 25;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 3; blockCols++){
			
			Block block = new Block (Color.GRAY, 5, 5);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionX = 70;
		
		for(int blockCols = 0; blockCols < 9; blockCols++){
			
			Block block = new Block (Color.YELLOW, 2, 50);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionY = 35;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 12; blockCols++){
			
			Block block = new Block (Color.RED, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionY = 45;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 9; blockCols++){
			
			Block block = new Block (Color.GREEN, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionX = 190;
		
		for(int blockCols = 0; blockCols < 3; blockCols++){
			
			Block block = new Block (Color.GRAY, 5, 5);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionY = 55;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 12; blockCols++){
			
			Block block = new Block (Color.CYAN, 1, 20);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionY = 65;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 3; blockCols++){
			
			Block block = new Block (Color.GRAY, 5, 5);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionX = 70;
		
		for(int blockCols = 0; blockCols < 9; blockCols++){
			
			Block block = new Block (Color.MAGENTA, 2, 50);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
		positionY = 75;
		positionX = 10;
		
		for(int blockCols = 0; blockCols < 12; blockCols++){
			
			Block block = new Block (Color.LIGHTGRAY, 2, 10);
			block.setPosition(positionX, positionY);
			blocks.add(block);
			
			positionX = positionX + 20;
			
		}
		
	}
	
	@Override
	protected void loop() {

		if(lifes == 0){
			
			blocks.clear();
			
		}
		
		//Testando os limites do eixo X e Y.
				Point pos = ball.getPosition();
				if (testeLimiteY(pos.y,0,getResolution().height)) {
					deltaY *= -1;
				}
				if (testeLimiteX(pos.x,0,getResolution().width)) {
					deltaX *= -1;
				}
				
				if(paddle.bateu(ball)){
					deltaY *= -1;
				}
				ball.move(deltaX, deltaY);
				
				for (Block bloco : blocks){
				   if (bloco.bateu(ball)) {

					   if(bloco.getLifes() == 0 && stage1Blocks > 0){
						   
						   stage1Blocks = stage1Blocks - 1;
						   
					   } else if(bloco.getLifes() == 0 && stage2Blocks > 0){
						   
						   stage2Blocks = stage2Blocks - 1;
						   
					   } else if(bloco.getLifes() == 0 && stage3Blocks > 0){
						   
						   stage3Blocks = stage3Blocks - 1;
						   
					   }   
					   
					   deltaY *= -1;
					   
					   if(bloco.getPoints() == 20){
						   
						   score = score + 20;
						   
					   } 
					   
					   if(bloco.getPoints() == 30){
						   
						   score = score + 30;
						   
					   }
					   
					   if(bloco.getPoints() == 50){
						   
						   score = score + 50;
						   
					   }
					   
					   if(bloco.getPoints() == 100){
						   
						   score = score + 100;
						   
					   }
					   
					   if(score == 100){
							
							frames = frames + 5;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 300){
							
							frames = frames + 5;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 500){
							
							frames = frames + 5;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 700){
							
							frames = frames + 5;
							this.setFramesPerSecond(frames);
							
						}

						if(score == 1000){
							
							frames = frames + 5;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 3000){
							
							frames = frames + 10;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 5000){
							
							frames = frames + 10;
							this.setFramesPerSecond(frames);
							
						}
						
						if(score == 10000){
							
							frames = frames + 20;
							this.setFramesPerSecond(frames);
							
						}
						
				   }
				   
				}
							
				if(stage1Blocks == 0){
					   
					   blocks.clear();
					   setup();
				   
				} 
				
				if(stage2Blocks == 0){
					
					blocks.clear();
					setup();
					
				}
				
				if(stage3Blocks == 0){
					
					blocks.clear();
					setup();
					
				}
				
				redraw();
				
	}

				private boolean testeLimiteX(double pos, int min, int max) {
					if(pos > max || pos < min) {
						
						
						return true;
					} else {
						return false;
					}
				}
				private boolean testeLimiteY(double pos, int min, int max) {
					if(pos > max || pos < min) {
						
						if(pos>max){
							
							lifes = lifes - 1;
							
							if(lifes > 0){
								
								ball.setPosition(100,180);
								
							} else if (lifes == 0){
								
								ball.setPosition(100,180);
								
								deltaX = 0;
								deltaY = 0;
								
								bindKeyPressed("ENTER", new KeyboardAction() {
									@Override
									public void handleEvent() {
							
										blocks.clear();
										
										deltaX = 1;
										deltaY = 1;
										
										stage1Blocks = 72;
										stage2Blocks = 27;
										stage3Blocks = 96;
										
										setup();
										
										if(score > highScore){
											
											highScore = score;
											
										}
										
										score = 0;
										lifes = 6;
										frames = 70;
										
									}
								});
								
								this.setFramesPerSecond(frames);
								
							}
						}
						return true;
						
					} else {
						return false;
					}

				}
}

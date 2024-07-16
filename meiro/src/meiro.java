import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.Vector;

public class meiro extends MyFrame {
	Reroll reroll=new Reroll();
	public void run() {
		addKeyListener(reroll);
		Makemeiro();
	}
	public void Makemeiro(){
		int[][] meiro = new int[21][21];
		Vector<String> vec = new Vector<>();
		vec.add("up");
		vec.add("down");
		vec.add("left");
		vec.add("right");
		Vector<String> vec2 = new Vector<>();
		vec2.add("down");
		vec2.add("left");
		vec2.add("right");
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				if ((i == 0) || (j == 0) || (i == 20) || (j == 20)) {
					meiro[i][j] = 1;
					if (meiro[i][j] == 1) {
						if ((j == 0) && (i == 1)) {
							setColor(0, 0, 255);
							drawString("■", 40 + (i * 19), 70 + (j * 19), 20);
							sleep(0.01);
						} else if ((j == 20) && (i == 19)) {
							setColor(255, 0, 0);
							drawString("■", 40 + (i * 19), 70 + (j * 19), 20);
							sleep(0.01);
						} else {
							setColor(0, 0, 0);
							drawString("■", 40 + (i * 19), 70 + (j * 19), 20);
							sleep(0.01);
						}
					}
				} else {
					meiro[i][j] = 0;
				}
			}
		}
		for (int i = 2; i <= 18; i++) {
			for (int j = 2; j <= 18; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					meiro[i][j] = 1;
					if (meiro[i][j] == 1) {
						setColor(0, 0, 0);
						drawString("■", 40 + (i * 19), 70 + (j * 19), 20);
						sleep(1);
					}
					Collections.shuffle(vec);
					if (j == 2) {
						switch (vec.get(0)) {
						case "right":
							meiro[i + 1][j] = 1;
							setColor(0, 0, 0);
							drawString("■", 40 + ((i + 1) * 19), 70 + (j * 19), 20);
							sleep(1);
							break;
						case "up":
							meiro[i][j - 1] = 1;
							setColor(0, 0, 0);
							drawString("■", 40 + (i * 19), 70 + ((j - 1) * 19), 20);
							sleep(1);
							break;
						case "down":
							meiro[i][j + 1] = 1;
							setColor(0, 0, 0);
							drawString("■", 40 + (i * 19), 70 + ((j + 1) * 19), 20);
							sleep(1);
							break;
						case "left":
							if (meiro[i - 1][j] == 1) {
								vec.remove(0);
								Collections.shuffle(vec);
								switch (vec.get(0)) {
								case "right":
									meiro[i + 1][j] = 1;
									setColor(0, 0, 0);
									drawString("■", 40 + ((i + 1) * 19), 70 + (j * 19), 20);
									sleep(1);
									vec.add("left");
									break;
								case "up":
									meiro[i][j - 1] = 1;
									setColor(0, 0, 0);
									drawString("■", 40 + (i * 19), 70 + ((j - 1) * 19), 20);
									sleep(1);
									vec.add("left");
									break;
								case "down":
									meiro[i][j + 1] = 1;
									setColor(0, 0, 0);
									drawString("■", 40 + (i * 19), 70 + ((j + 1) * 19), 20);
									sleep(1);
									vec.add("left");
									break;
								}
							} else {
								meiro[i - 1][j] = 1;
								setColor(0, 0, 0);
								drawString("■", 40 + ((i - 1) * 19), 70 + (j * 19), 20);
								sleep(1);
							}
							break;
						}
					} else {
						Collections.shuffle(vec2);
						switch (vec2.get(0)) {
						case "right":
							meiro[i + 1][j] = 1;
							setColor(0, 0, 0);
							drawString("■", 40 + ((i + 1) * 19), 70 + (j * 19), 20);
							sleep(1);
							break;
						case "down":
							meiro[i][j + 1] = 1;
							setColor(0, 0, 0);
							drawString("■", 40 + (i * 19), 70 + ((j + 1) * 19), 20);
							sleep(1);
							break;
						case "left":
							if (meiro[i - 1][j] == 1) {
								vec2.remove(0);
								Collections.shuffle(vec2);
								switch (vec2.get(0)) {
								case "right":
									meiro[i + 1][j] = 1;
									setColor(0, 0, 0);
									drawString("■", 40 + ((i + 1) * 19), 70 + (j * 19), 20);
									sleep(1);
									vec2.add("left");
									break;
								case "down":
									meiro[i][j + 1] = 1;
									setColor(0, 0, 0);
									drawString("■", 40 + (i * 19), 70 + ((j + 1) * 19), 20);
									sleep(1);
									vec2.add("left");
									break;
								}
							} else {
								meiro[i - 1][j] = 1;
								setColor(0, 0, 0);
								drawString("■", 40 + ((i - 1) * 19), 70 + (j * 19), 20);
								sleep(1);
							}
							break;
						}
					}
				}
			}
		}
	}
	public class Reroll implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				clear();
				Makemeiro();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
		}
		
	}
}
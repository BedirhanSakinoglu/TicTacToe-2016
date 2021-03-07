import acm.graphics.*;
import acm.program.*;
import acm.util.MediaTools;
import acm.util.RandomGenerator;
import java.awt.event.KeyEvent;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.sun.javafx.scene.control.behavior.ButtonBehavior;

public class TicTacToe extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 420;
	public static final int APPLICATION_HEIGHT = 420;

	private ArrayList<GImage> Xs;
	private ArrayList<GImage> Os;
	int g = 1;

	int ax = 0, bx = 0, cx = 0, xx = 0, yx = 0, zx = 0, kx = 0, lx = 0, mx = 0;
	int ao = 0, bo = 0, co = 0, xo = 0, yo = 0, zo = 0, ko = 0, lo = 0, mo = 0;

	int j = 0;
	int p = 0;

	GRect player = new GRect(210, 420);
	GRect bot = new GRect(210, 420);
	GLabel player1 = new GLabel("Click to Play");
	GLabel player2 = new GLabel("Against Your Friend");

	GLabel playbot1 = new GLabel("Click to Play");
	GLabel playbot2 = new GLabel("Against Computer");

	public void run() {
		
		starting();
		addMouseListeners();
		game();
		
	}
	
	public void game(){
			
		pause(200);
		removeAll();

		ax = 0;
		bx = 0;
		cx = 0;
		xx = 0;
		yx = 0;
		zx = 0;
		kx = 0;
		lx = 0;
		mx = 0;
		ao = 0;
		bo = 0;
		co = 0;
		xo = 0;
		yo = 0;
		zo = 0;
		ko = 0;
		lo = 0;
		mo = 0;

		g = 1;
		p = 0;
		j = 1;

		bot.setColor(Color.WHITE);
		bot.setFilled(true);
		add(bot, 0, 0);
		playbot1.setColor(Color.BLACK);
		playbot1.setFont("Impact-20");
		add(playbot1, 50, 190);
		playbot2.setColor(Color.BLACK);
		playbot2.setFont("Impact-20");
		add(playbot2, 35, 220);

		player.setColor(Color.RED);
		player.setFilled(true);
		add(player, 210, 0);
		player1.setColor(Color.WHITE);
		player1.setFont("Impact-20");
		add(player1, 260, 190);
		player2.setColor(Color.WHITE);
		player2.setFont("Impact-20");
		add(player2, 235, 220);

		//addMouseListeners();

		waitForClick();

		int a = 0, b = 0;

		pause(400);

		for (int i = 0; i < 3; i++) {
			b = 0;
			add(sq(a, b));
			pause(100);

			for (int k = 0; k < 3; k++) {
				add(sq(a, b));
				b += 140;
				pause(100);
			}
			a += 140;
		}

		Xs = new ArrayList<GImage>();
		Os = new ArrayList<GImage>();

		while (true) {
			// X dikey bitiþ
			if (ax == 1 && bx == 1 && cx == 1) {
				Xwins();
			} else if (xx == 1 && yx == 1 && zx == 1) {
				Xwins();
			} else if (kx == 1 && lx == 1 && mx == 1) {
				Xwins();
			}
			// X yatay bitiþ
			else if (ax == 1 && xx == 1 && kx == 1) {
				Xwins();
			} else if (bx == 1 && yx == 1 && lx == 1) {
				Xwins();
			} else if (cx == 1 && zx == 1 && mx == 1) {
				Xwins();
			}
			// X çapraz bitiþ
			else if (ax == 1 && yx == 1 && mx == 1) {
				Xwins();
			} else if (cx == 1 && yx == 1 && kx == 1) {
				Xwins();
			}

			// O dikey bitiþ
			else if (ao == 1 && bo == 1 && co == 1) {
				Owins();
			} else if (xo == 1 && yo == 1 && zo == 1) {
				Owins();
			} else if (ko == 1 && lo == 1 && mo == 1) {
				Owins();
			}
			// O yatay bitiþ
			else if (ao == 1 && xo == 1 && ko == 1) {
				Owins();
			} else if (bo == 1 && yo == 1 && lo == 1) {
				Owins();
			} else if (co == 1 && zo == 1 && mo == 1) {
				Owins();
			}
			// O çapraz bitiþ
			else if (ao == 1 && yo == 1 && mo == 1) {
				Owins();
			} else if (co == 1 && yo == 1 && ko == 1) {
				Owins();
			} else if (g == 10) {
				draw();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {

		System.out.println("Click");
		System.out.println(getElementAt(e.getX(),e.getY()));

		GImage X = new GImage("x.png");
		X.scale(0.1);
		GImage O = new GImage("o.png");
		O.scale(0.035);
		int t = 0;

		System.out.println("p = " + p);
		System.out.println("j = " + j);

		// BOT
		if (p == 2) {
			if (j == 1) {
			} else {
				// X
				if (e.getX() < 140 && g % 2 == 1) {

					if (e.getY() < 140 && ax == 0 && ao == 0) {
						add(X, 70 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						ax = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && bx == 0 && bo == 0) {
						add(X, 70 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						bx = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && cx == 0 && co == 0) {
						add(X, 70 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						cx = 1;
						g += 1;
						t = 1;
					}
				}
				if (e.getX() < 280 && e.getX() > 140 && g % 2 == 1) {

					if (e.getY() < 140 && xx == 0 && xo == 0) {
						add(X, 210 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						xx = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && yx == 0 && yo == 0) {
						add(X, 210 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						yx = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && zx == 0 && zo == 0) {
						add(X, 210 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						zx = 1;
						g += 1;
						t = 1;
					}
				}
				if (e.getX() < 420 && e.getX() > 280 && g % 2 == 1) {

					if (e.getY() < 140 && kx == 0 && ko == 0) {
						add(X, 350 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						kx = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && lx == 0 && lo == 0) {
						add(X, 350 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						lx = 1;
						g += 1;
						t = 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && mx == 0 && mo == 0) {
						add(X, 350 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						mx = 1;
						g += 1;
						t = 1;
					}
				}

				// 3 O kazanma
				// dikey
				if (t == 1) {
					if (ao == 1 && bo == 1 && cx == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}

					else if (ao == 1 && co == 1 && bx == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					}

					else if (bo == 1 && co == 1 && ax == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (xo == 1 && yo == 1 && zx == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}

					else if (xo == 1 && zo == 1 && yx == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (yo == 1 && zo == 1 && xx == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					} else if (ko == 1 && lo == 1 && mx == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (ko == 1 && mo == 1 && lx == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					}

					else if (lo == 1 && mo == 1 && kx == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}
					// yatay
					else if (ao == 1 && ko == 1 && xx == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					}

					else if (ao == 1 && xo == 1 && kx == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}

					else if (ko == 1 && xo == 1 && ax == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (bo == 1 && lo == 1 && yx == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (bo == 1 && yo == 1 && lx == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					}

					else if (lo == 1 && yo == 1 && bx == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					} else if (co == 1 && mo == 1 && zx == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}

					else if (co == 1 && zo == 1 && mx == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (zo == 1 && mo == 1 && cx == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}
					// çapraz
					else if (ao == 1 && yo == 1 && mx == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (ao == 1 && mo == 1 && yx == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (mo == 1 && yo == 1 && ax == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (co == 1 && yo == 1 && kx == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}

					else if (co == 1 && ko == 1 && yx == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (ko == 1 && yo == 1 && cx == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}

					// 3X engelleme
					// dikey
					else if (ax == 1 && bx == 1 && cx == 0 && co == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}

					else if (ax == 1 && cx == 1 && bx == 0 && bo == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					}

					else if (bx == 1 && cx == 1 && ax == 0 && ao == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					}

					else if (xx == 1 && yx == 1 && zx == 0 && zo == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}

					else if (xx == 1 && zx == 1 && yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (yx == 1 && zx == 1 && xx == 0 && xo == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					} else if (kx == 1 && lx == 1 && mx == 0 && mo == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (kx == 1 && mx == 1 && lx == 0 && lo == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					}

					else if (lx == 1 && mx == 1 && kx == 0 && ko == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}
					// yatay
					else if (ax == 1 && kx == 1 && xx == 0 && xo == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					}

					else if (ax == 1 && xx == 1 && kx == 0 && ko == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}

					else if (kx == 1 && xx == 1 && ax == 0 && ao == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (bx == 1 && lx == 1 && yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (bx == 1 && yx == 1 && lx == 0 && lo == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					}

					else if (lx == 1 && yx == 1 && bx == 0 && bo == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					} else if (cx == 1 && mx == 1 && zx == 0 && zo == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}

					else if (cx == 1 && zx == 1 && mx == 0 && mo == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (zx == 1 && mx == 1 && cx == 0 && co == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}
					// çapraz
					else if (ax == 1 && yx == 1 && mx == 0 && mo == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}

					else if (ax == 1 && mx == 1 && yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (mx == 1 && yx == 1 && ax == 0 && ao == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (cx == 1 && yx == 1 && kx == 0 && ko == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}

					else if (cx == 1 && kx == 1 && yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}

					else if (kx == 1 && yx == 1 && cx == 0 && co == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}

					// Rastgele Oynama
					else if (yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					} else if (ax == 0 && ao == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					} else if (bx == 0 && bo == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					} else if (cx == 0 && co == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					} else if (mx == 0 && mo == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					} else if (xx == 0 && xo == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					} else if (kx == 0 && ko == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					} else if (lx == 0 && lo == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					} else if (zx == 0 && zo == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}
				}
			}
		}
		// 2 Players
		if (p == 1) {
			if (j == 1) {
			} else {
				// X
				if (e.getX() < 140 && g % 2 == 1) {

					if (e.getY() < 140 && ax == 0 && ao == 0) {
						add(X, 70 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						ax = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && bx == 0 && bo == 0) {
						add(X, 70 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						bx = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && cx == 0 && co == 0) {
						add(X, 70 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						cx = 1;
						g += 1;
					}
				}
				if (e.getX() < 280 && e.getX() > 140 && g % 2 == 1) {

					if (e.getY() < 140 && xx == 0 && xo == 0) {
						add(X, 210 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						xx = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && yx == 0 && yo == 0) {
						add(X, 210 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						yx = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && zx == 0 && zo == 0) {
						add(X, 210 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						zx = 1;
						g += 1;
					}
				}
				if (e.getX() < 420 && e.getX() > 280 && g % 2 == 1) {

					if (e.getY() < 140 && kx == 0 && ko == 0) {
						add(X, 350 - X.getWidth() / 2, 70 - X.getHeight() / 2);
						kx = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && lx == 0 && lo == 0) {
						add(X, 350 - X.getWidth() / 2, 210 - X.getHeight() / 2);
						lx = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && mx == 0 && mo == 0) {
						add(X, 350 - X.getWidth() / 2, 350 - X.getHeight() / 2);
						mx = 1;
						g += 1;
					}
				}
				// O
				if (e.getX() < 140 && g % 2 == 0) {

					if (e.getY() < 140 && ax == 0 && ao == 0) {
						add(O, 70 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ao = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && bx == 0 && bo == 0) {
						add(O, 70 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						bo = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && cx == 0 && co == 0) {
						add(O, 70 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						co = 1;
						g += 1;
					}
				}
				if (e.getX() < 280 && e.getX() > 140 && g % 2 == 0) {

					if (e.getY() < 140 && xx == 0 && xo == 0) {
						add(O, 210 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						xo = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && yx == 0 && yo == 0) {
						add(O, 210 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						yo = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && zx == 0 && zo == 0) {
						add(O, 210 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						zo = 1;
						g += 1;
					}
				}
				if (e.getX() < 420 && e.getX() > 280 && g % 2 == 0) {

					if (e.getY() < 140 && kx == 0 && ko == 0) {
						add(O, 350 - O.getWidth() / 2, 70 - O.getHeight() / 2);
						ko = 1;
						g += 1;
					}
					if (e.getY() < 280 && e.getY() > 140 && lx == 0 && lo == 0) {
						add(O, 350 - O.getWidth() / 2, 210 - O.getHeight() / 2);
						lo = 1;
						g += 1;
					}
					if (e.getY() < 420 && e.getY() > 280 && mx == 0 && mo == 0) {
						add(O, 350 - O.getWidth() / 2, 350 - O.getHeight() / 2);
						mo = 1;
						g += 1;
					}
				}
			}
		}

		if (getElementAt(e.getX(), e.getY()) == player || getElementAt(e.getX(), e.getY()) == player1
				|| getElementAt(e.getX(), e.getY()) == player2) {
			p = 1;
			j = 0;
			remove(player);
			remove(player1);
			remove(player2);
			remove(bot);
			remove(playbot1);
			remove(playbot2);

		}
		// ****************************
		if (getElementAt(e.getX(), e.getY()) == bot || getElementAt(e.getX(), e.getY()) == playbot1
				|| getElementAt(e.getX(), e.getY()) == playbot2) {
			p = 2;
			j = 0;
			remove(player);
			remove(player1);
			remove(player2);
			remove(bot);
			remove(playbot1);
			remove(playbot2);
		}
	}

	private GRect sq(int x, int y) {

		GRect kare = new GRect(x, y, 140, 140);
		kare.setColor(Color.BLACK);
		return kare;
	}

	private void starting() {

		GLabel start = new GLabel("Tic Tac Toe");
		start.setFont("Impact-80");
		start.setColor(Color.RED);
		add(start, getWidth() / 2 - start.getWidth() / 2, getHeight() / 2 + start.getHeight() / 2 - 30);
		pause(2000);
		removeAll();
	}

	private void Xwins() {

		j = 1;
		p = 0;
		pause(500);
		removeAll();
		GLabel restart = new GLabel("Click to Restart");
		GLabel Xwins = new GLabel("X Wins");
		Xwins.setFont("Impact-75");
		Xwins.setColor(Color.RED);
		add(Xwins, getWidth() / 2 - Xwins.getWidth() / 2,
				getHeight() / 2 + Xwins.getHeight() / 2 - restart.getHeight() - 40);
		restart.setFont("Impact-50");
		restart.setColor(Color.BLACK);
		add(restart, getWidth() / 2 - restart.getWidth() / 2, getHeight() / 2 + restart.getHeight() / 2 + 20);
		waitForClick();
		removeAll();
		game();
	}

	private void Owins() {

		j = 1;
		p = 0;
		pause(500);
		removeAll();
		GLabel restart = new GLabel("Click to Restart");
		GLabel Xwins = new GLabel("O Wins");
		Xwins.setFont("Impact-75");
		Xwins.setColor(Color.RED);
		add(Xwins, getWidth() / 2 - Xwins.getWidth() / 2,
				getHeight() / 2 + Xwins.getHeight() / 2 - restart.getHeight() - 40);
		restart.setFont("Impact-50");
		restart.setColor(Color.BLACK);
		add(restart, getWidth() / 2 - restart.getWidth() / 2, getHeight() / 2 + restart.getHeight() / 2 + 20);
		waitForClick();
		removeAll();
		game();
	}

	private void draw() {

		j = 1;
		p = 0;
		pause(500);
		removeAll();
		GLabel restart = new GLabel("Click to Restart");
		GLabel draw = new GLabel("Draw");
		draw.setFont("Impact-75");
		draw.setColor(Color.RED);
		add(draw, getWidth() / 2 - draw.getWidth() / 2,
				getHeight() / 2 + draw.getHeight() / 2 - restart.getHeight() - 40);
		restart.setFont("Impact-50");
		restart.setColor(Color.BLACK);
		add(restart, getWidth() / 2 - restart.getWidth() / 2, getHeight() / 2 + restart.getHeight() / 2 + 20);
		waitForClick();
		removeAll();
		game();
	}
}

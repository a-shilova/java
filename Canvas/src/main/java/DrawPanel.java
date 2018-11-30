import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawPanel extends JPanel {
	private int x1;
	private int y1;
	private int y2;
	private int x2;
	private Graphics g;
	private Color color;

	public DrawPanel() {

		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			g = getGraphics();
			g.setColor(color);
			x2 = x1;
			y2 = y1;
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			x2 = x1;
			y2 = y1;
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

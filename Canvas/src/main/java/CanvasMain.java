import javax.swing.SwingUtilities;
import javax.swing.JFrame;


public class CanvasMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? "+
				SwingUtilities.isEventDispatchThread());
		Canvas canvas = new Canvas();
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.pack();
		canvas.setVisible(true);
	}
}


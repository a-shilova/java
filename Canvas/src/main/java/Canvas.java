import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JFrame {
	private JButton OKButton;
	private JButton cancelButton;
	private JPanel pageContent;
	private DrawPanel drawPanel;
	private JButton colorChangeButton;

	public Canvas() {
		setContentPane(pageContent);
		getRootPane().setDefaultButton(OKButton);
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});

		colorChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onColorChange();
			}
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		pageContent.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}

	private void onOK() {
		dispose();
	}

	private void onCancel() {
		dispose();
	}

	private void onColorChange() {
		final JDialog colorChangeFrame = new JDialog();
		final JColorChooser jcc = new JColorChooser();
		JPanel jp = new JPanel();
		jp.add(jcc);
		JButton getColorButton = new JButton("Выбрать цвет");

		getColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Color color = jcc.getColor();
				drawPanel.setColor(color);
				colorChangeButton.setForeground(color);
				colorChangeFrame.hide();
			}
		});

		jp.add(getColorButton);
		colorChangeFrame.add(jp);
		colorChangeFrame.setModal(true);
		colorChangeFrame.setVisible(true);
		colorChangeFrame.setSize(630, 390);
		colorChangeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}

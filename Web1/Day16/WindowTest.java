package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class WindowTest extends JFrame{
	public WindowTest() {
		super("Å¬·¡½º Å×½ºÆ®");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Button btn = new Button("´­·¯Áà~");
		setSize(500, 700);
		int x = (d.width - getWidth()) / 2;
		int y = (d.height - getHeight()) / 2;
		setLocation(x, y);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¾Ñ ´­·È¾î!");
				System.out.println("x : " + e.getX());
				System.out.println("y : " + e.getY());
			}
		});
		
		add(btn);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new WindowTest();
	}
}











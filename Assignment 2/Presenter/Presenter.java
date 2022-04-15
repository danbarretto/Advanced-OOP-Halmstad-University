import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;


public abstract class Presenter {

	public abstract JComponent createCenterComponent();
	
	public abstract void northButtonPressed();
	public abstract void eastButtonPressed();
	public abstract void southButtonPressed();
	public abstract void westButtonPressed();
	
	private JTextArea textArea;

	private final int FRAME_WIDTH = 1280;
	private final int FRAME_HEIGHT = 720;
	public Presenter() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setup layout manager for frame
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		
		JButton northButton = new JButton("North");
		northButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				northButtonPressed();				
			}
		});
		
		JButton eastButton = new JButton("East");
		eastButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				eastButtonPressed();				
			}
		});

		JButton southButton = new JButton("South");
		southButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				southButtonPressed();				
			}
		});
		JButton westButton = new JButton("West");
		westButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				westButtonPressed();				
			}
		});


		// add northButton to a JPanel, add that panel to frame
		JComponent centerComponent = createCenterComponent();
		
		// add centerComponent to frame
		// create other components (text component, e.g.), add them to frame
		// show frame
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(northButton, BorderLayout.PAGE_START);
		buttonPanel.add(eastButton, BorderLayout.LINE_END);
		buttonPanel.add(southButton, BorderLayout.PAGE_END);
		buttonPanel.add(westButton, BorderLayout.LINE_START);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(buttonPanel);
		bottomPanel.add(textArea);

		frame.add(centerComponent, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void showText(String text) {
		textArea.setText(text);
	}
	
}

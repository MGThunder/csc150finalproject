package edu.neumont.csc150.finalproject.group17;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ScrollBarPanel extends JPanel {

	JScrollBar vBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);
	
	public ScrollBarPanel() {
		this.setLayout(new BorderLayout());
		vBar.setPreferredSize(new Dimension(20, 3000));
		vBar.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				repaint();

			}
		});
		
		this.add(vBar, BorderLayout.EAST);
	}
	
}

package cz.zweistein.gw2.app.eventwatch.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cz.zweistein.gw2.api.dto.enums.EventState;

public class EventDialog extends JFrame implements ActionListener {
	private static final long serialVersionUID = -5505049052341677804L;

	private String selectedEvent;
	private Long selectedWorld;

	private Map<String, String> eventNames;
	private Map<Long, String> worldNames;

	private EventState eventState;

	private JLabel eventStatusLabel;

	JComboBox eventNamesComboBox;
	JComboBox worldNamesComboBox;

	public EventDialog(Map<String, String> eventNames, Map<Long, String> worldNames) {

		this.eventNames = eventNames;
		this.worldNames = worldNames;

		this.eventState = EventState.INVALID;

		JPanel content = new JPanel();
		
		content.setLayout(new GridBagLayout());

		add(content);

		eventStatusLabel = new JLabel();
		content.add(eventStatusLabel, new GridBagConstraints(0, 0, 1, 1, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		eventStatusLabel.setOpaque(true);
		updateEventState();

		
		List<CodeTableItem> eventNamesEntries = new ArrayList<CodeTableItem>();
		for (Entry<String, String> item : eventNames.entrySet()) {
			eventNamesEntries.add(new CodeTableItem(item));
		}
		Collections.sort(eventNamesEntries, new CodeTableEntryComparator());
		
		eventNamesComboBox = new JComboBox(eventNamesEntries.toArray(new CodeTableItem[eventNamesEntries.size()]));
		eventNamesComboBox.setRenderer(new CodeTableRenderer());
		eventNamesComboBox.addActionListener(this);
		content.add(eventNamesComboBox, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		
		List<CodeTableItem> worldNamesEntries = new ArrayList<CodeTableItem>();
		for (Entry<Long, String> item : worldNames.entrySet()) {
			worldNamesEntries.add(new CodeTableItem(item));
		}
		Collections.sort(worldNamesEntries, new CodeTableEntryComparator());

		worldNamesComboBox = new JComboBox(worldNamesEntries.toArray(new CodeTableItem[worldNamesEntries.size()]));
		worldNamesComboBox.setRenderer(new CodeTableRenderer());
		worldNamesComboBox.addActionListener(this);
		content.add(worldNamesComboBox, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton toggleButton = new JButton("-");
		content.add(toggleButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
		toggleButton.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		selectedEvent = (String) ((CodeTableItem) eventNamesEntries.get(0)).getItem().getKey();
		selectedWorld = (Long) ((CodeTableItem) worldNamesEntries.get(0)).getItem().getKey();
		updateTitle();
		
		setAlwaysOnTop(true);
		pack();
		setVisible(true);

	}

	public String getSelectedEvent() {
		return this.selectedEvent;
	}

	public Long getSelectedWorld() {
		return this.selectedWorld;
	}

	public void setEventState(EventState eventState) {
		this.eventState = eventState;
		updateEventState();
	}

	private void updateEventState() {
		eventStatusLabel.setText(this.eventState.toString());
		
		switch (this.eventState) {
		case INVALID:
			eventStatusLabel.setBackground(Color.PINK);
			break;
		case ACTIVE:
			eventStatusLabel.setBackground(Color.GREEN);
			break;
		case PREPARATION:
			eventStatusLabel.setBackground(Color.BLUE);
			break;
		case WARMUP:
			eventStatusLabel.setBackground(Color.YELLOW);
			break;
		case SUCCESS:
			eventStatusLabel.setBackground(Color.LIGHT_GRAY);
			break;
		case FAIL:
			eventStatusLabel.setBackground(Color.RED);
			break;
		default:
			break;
		}
	}
	
	private void updateTitle() {
		setTitle(eventNames.get(selectedEvent) + " @ " + worldNames.get(selectedWorld));

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == eventNamesComboBox) {
			selectedEvent = (String)((CodeTableItem) eventNamesComboBox.getSelectedItem()).getItem().getKey();
			this.eventState = EventState.INVALID;
		} else if (ae.getSource() == worldNamesComboBox) {
			selectedWorld = (Long)((CodeTableItem) worldNamesComboBox.getSelectedItem()).getItem().getKey();
			this.eventState = EventState.INVALID;
		} else {
			eventNamesComboBox.setVisible(!eventNamesComboBox.isVisible());
			worldNamesComboBox.setVisible(!worldNamesComboBox.isVisible());
		}
		updateEventState();
		updateTitle();
	}

}

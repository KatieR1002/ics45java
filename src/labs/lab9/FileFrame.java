package labs.lab9;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.synth.SynthSliderUI;


/**
 * A frame that is filled with two components.
 */
public class FileFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JLabel todolistLabel;
	private JLabel itemLabel1;
	private JLabel itemLabel2;
	private JLabel priorityLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JLabel yearLabel;
	private JLabel notesLabel;
	private JScrollPane scrollPane;
	private JList<String> jList;
	private JButton toggleButton;
	private JButton deleteButton;
	private JButton saveButton;
	private JButton newButton;
	private JButton button4;
	private JPanel panel;
	private JTextField itemInpuTextField;
	private JTextField priorityInpuTextField;
	private JCheckBox deadlineBox;
	private JComboBox<String> monthBox;
	private JComboBox<Integer> dayBox;
	private JComboBox<Integer> yearBox;
	private JTextArea notesArea;
	private JScrollPane noteScrollPane;
	private ArrayList<TodoItem> todoItems;
//	private 
	
	private DefaultListModel<String> dlm;
	//private JLabel label;
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 400;
	public FileFrame() {
		todoItems=new ArrayList<>();
		addMenuBar();
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	private void addMenuBar() {
		menuBar=new JMenuBar();
		menu=new JMenu("File");
		menuItem=new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int response=JOptionPane.showConfirmDialog(FileFrame.this, "Do you want to exit", "confirm", JOptionPane.YES_NO_OPTION);
				if(response==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	private void createComponents() {
		Font font=new Font("ÀŒÃÂ", 0, 12);
		panel = new JPanel();
		panel.setLayout(null);

		todolistLabel=new JLabel("ToDo List");
		todolistLabel.setFont(font);
		todolistLabel.setBounds(25,5,60,20);
		panel.add(todolistLabel);
		
		scrollPane=new JScrollPane();
		jList=new JList<String>();
		dlm = new DefaultListModel<String>();

		jList.setModel(dlm);
		jList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
			
				if(jList.getSelectedValue()!=null) {
					int selectedIndex=jList.getSelectedIndex();
			
					toggleButton.setEnabled(true);
					deleteButton.setEnabled(true);
				
					TodoItem item=todoItems.get(selectedIndex);
					itemInpuTextField.setText(item.getName());
					priorityInpuTextField.setText(Integer.toString(item.getPriority()));
					deadlineBox.setSelected(item.isDeadline());
					
					if(item.isDeadline()) {
						monthBox.setSelectedIndex(item.getMonth()-1);
						yearBox.setSelectedItem(item.getYear());
						dayBox.setSelectedItem(item.getDay());
					}
					notesArea.setText(item.getNotes());
				}
			}
		});
		scrollPane.setViewportView(jList);
		scrollPane.setBounds(25, 25, 350, 300);
		panel.add(scrollPane);
		
		toggleButton=new JButton("Toggle Done");
		toggleButton.setFont(font);
		toggleButton.setMargin(new Insets(2, 2, 2, 2));
		toggleButton.setEnabled(false);
		toggleButton.setBounds(scrollPane.getX()+scrollPane.getWidth()+5,150,80,20);
		toggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index=jList.getSelectedIndex();
				TodoItem item=todoItems.get(index);
				item.setDone(!item.isDone());
				Collections.sort(todoItems);
				dlm.clear();
				int newIndex = 0;
				for(int i=0;i<todoItems.size();i++) {
					dlm.addElement(todoItems.get(i).getName1());
					if(todoItems.get(i).getName().equals(item.getName())) {
						newIndex=i;
					}
				}
				jList.setModel(dlm);
				jList.setSelectedIndex(newIndex);
			}
		});
		panel.add(toggleButton);
		
		deleteButton=new JButton("Delete");
		deleteButton.setFont(font);
		deleteButton.setEnabled(false);
		deleteButton.setMargin(new Insets(2, 2, 2, 2));
		deleteButton.setBounds(scrollPane.getX()+scrollPane.getWidth()+5,toggleButton.getY()+toggleButton.getHeight()+5,80,20);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int index=jList.getSelectedIndex();
				todoItems.remove(index);
				resetFields();
			}
		});
		panel.add(deleteButton);
		setContentPane(panel);
		
		itemLabel1=new JLabel("Item");
		itemLabel1.setFont(font);
		itemLabel1.setBounds(toggleButton.getX()+toggleButton.getWidth()+10,todolistLabel.getY(),60,20);
		panel.add(itemLabel1);
		
		itemLabel2=new JLabel("Item:");
		itemLabel2.setFont(font);
		itemLabel2.setBounds(itemLabel1.getX()+10,itemLabel1.getY()+itemLabel1.getHeight()+10,40,20);
		panel.add(itemLabel2);
		
		itemInpuTextField=new JTextField();
		itemInpuTextField.setEditable(true);
		itemInpuTextField.setBounds(itemLabel2.getX()+itemLabel2.getWidth()+5,itemLabel2.getY(),300,20);
		panel.add(itemInpuTextField);
		
		priorityLabel=new JLabel("Priority:");
		priorityLabel.setFont(font);
		priorityLabel.setBounds(itemLabel1.getX()+10,itemLabel2.getY()+itemLabel2.getHeight()+10,60,20);
		panel.add(priorityLabel);
		
		priorityInpuTextField=new JTextField();
		priorityInpuTextField.setEditable(true);
		priorityInpuTextField.setBounds(priorityLabel.getX()+priorityLabel.getWidth()+5,priorityLabel.getY(),100,20);
		panel.add(priorityInpuTextField);
		
		
		deadlineBox=new JCheckBox("Deadline");
		deadlineBox.setBounds(itemLabel1.getX()+10, priorityLabel.getY()+priorityLabel.getHeight()+10, 100, 20);
		panel.add(deadlineBox);
		deadlineBox.setSelected(true);
		deadlineBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(deadlineBox.isSelected()) {
					monthBox.setEnabled(true);
					dayBox.setEnabled(true);
					yearBox.setEnabled(true);
				}
				else {
					monthBox.setEnabled(false);
					dayBox.setEnabled(false);
					yearBox.setEnabled(false);
				}
			}
		});
		
		monthLabel=new JLabel("Month:");
		monthLabel.setFont(font);
		monthLabel.setBounds(itemLabel1.getX()+10,deadlineBox.getY()+deadlineBox.getHeight()+10,40,20);
		panel.add(monthLabel);
		
		String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		monthBox=new JComboBox<>(months);
		
		monthBox.setBounds(monthLabel.getX()+monthLabel.getWidth()+5,monthLabel.getY(),90,20);
		monthBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange()==ItemEvent.SELECTED) {
					int month=monthBox.getSelectedIndex()+1;
					int days=getDays(month, (int)yearBox.getSelectedItem());
					dayBox.removeAllItems();;
					for(int i=0;i<days;i++) {
						dayBox.addItem(i+1);
					}
				}
			}
		});
		panel.add(monthBox);
		
		dayLabel=new JLabel("Day:");
		dayLabel.setFont(font);
		dayLabel.setBounds(monthBox.getX()+monthBox.getWidth()+10,monthLabel.getY(),30,20);
		panel.add(dayLabel);
		
		
		
		dayBox=new JComboBox<>();
		
		dayBox.setBounds(dayLabel.getX()+dayLabel.getWidth()+5,dayLabel.getY(),60,20);
		panel.add(dayBox);
		
		yearLabel=new JLabel("Year:");
		yearLabel.setFont(font);
		yearLabel.setBounds(dayBox.getX()+dayBox.getWidth()+10,monthLabel.getY(),40,20);
		panel.add(yearLabel);
		
		yearBox=new JComboBox<>();
		for(int i=0;i<10;i++) {
			yearBox.addItem(2022+i);
		}
		
		yearBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int year=(int)yearBox.getSelectedItem();
				int month=monthBox.getSelectedIndex()+1;
				int days=getDays(month,year);
				dayBox.removeAllItems();;
				for(int i=0;i<days;i++) {
					dayBox.addItem(i+1);
				}
			}
		});
		yearBox.setBounds(yearLabel.getX()+yearLabel.getWidth()+10, monthLabel.getY(), 60, 20);
		panel.add(yearBox);
		
		notesLabel=new JLabel("Notes:");
		notesLabel.setFont(font);
		notesLabel.setBounds(itemLabel1.getX()+10,yearLabel.getY()+yearLabel.getHeight()+10,40,20);
		panel.add(notesLabel);
		
		notesArea=new JTextArea();
		notesArea.setLineWrap(true);
		//notesArea.setBounds(notesLabel.getX(), notesLabel.getY()+notesLabel.getHeight(), 350, 100);
		
		noteScrollPane=new JScrollPane(notesArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		noteScrollPane.setBounds(notesLabel.getX(), notesLabel.getY()+notesLabel.getHeight(), 350, 100);
		panel.add(noteScrollPane);
		
		saveButton=new JButton("Save Item");
		saveButton.setFont(font);
		saveButton.setMargin(new Insets(2, 2, 2, 2));
		saveButton.setBounds(itemLabel1.getX()+50,noteScrollPane.getY()+noteScrollPane.getHeight()+20,80,20);
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(itemInpuTextField.getText().equals("")||priorityInpuTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(FileFrame.this, "Invalid input!","warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				int priority;
				try {
					priority=Integer.parseInt(priorityInpuTextField.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(FileFrame.this, "Invalid input!","warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(priority<0) {
					JOptionPane.showMessageDialog(FileFrame.this, "Invalid input!","warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(jList.isSelectionEmpty()) {
					for(int i=0;i<todoItems.size();i++) {
						if(todoItems.get(i).getName().equals(itemInpuTextField.getText())) {
							JOptionPane.showMessageDialog(FileFrame.this, "Invalid input!","warning",JOptionPane.WARNING_MESSAGE);
							return;
						}
					}
					TodoItem item=new TodoItem();
					item.setName(itemInpuTextField.getText());
					item.setPriority(priority);
					item.setDeadline(deadlineBox.isSelected());
					if(item.isDeadline()) {
						item.setDay((int)dayBox.getSelectedItem());
						item.setMonth(monthBox.getSelectedIndex()+1);
						item.setYear((int)yearBox.getSelectedItem());
					}
					item.setDone(false);
					item.setNotes(notesArea.getText());
					todoItems.add(item);
					resetFields();
				}
				else {
					int selectIndex=jList.getSelectedIndex();
					for(int i=0;i<todoItems.size();i++) {
						if(i==selectIndex) {
							continue;
						}
						if(todoItems.get(i).getName().equals(itemInpuTextField.getText())) {
							JOptionPane.showMessageDialog(FileFrame.this, "Invalid input!","warning",JOptionPane.WARNING_MESSAGE);
							return;
						}
					}
					todoItems.get(selectIndex).setName(itemInpuTextField.getText());
					todoItems.get(selectIndex).setPriority(priority);
					todoItems.get(selectIndex).setDeadline(deadlineBox.isSelected());
					if(todoItems.get(selectIndex).isDeadline()) {
						todoItems.get(selectIndex).setDay((int)dayBox.getSelectedItem());
						todoItems.get(selectIndex).setMonth(monthBox.getSelectedIndex()+1);
						todoItems.get(selectIndex).setYear((int)yearBox.getSelectedItem());
					}
					todoItems.get(selectIndex).setNotes(notesArea.getText());
					JOptionPane.showMessageDialog(FileFrame.this, "Item saved!","message",JOptionPane.PLAIN_MESSAGE);
					resetFields();
				}
			}
		});
		
		newButton=new JButton("New Item");
		newButton.setFont(font);
		newButton.setMargin(new Insets(2, 2, 2, 2));
		newButton.setBounds(saveButton.getX()+saveButton.getWidth()+100,noteScrollPane.getY()+noteScrollPane.getHeight()+20,80,20);
		panel.add(newButton);
		newButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				resetFields();
			}
		});
		resetFields();
	}
	private void resetFields() {
		toggleButton.setEnabled(false);
		deleteButton.setEnabled(false);
		itemInpuTextField.setText("");
		priorityInpuTextField.setText("");
		LocalDate date=LocalDate.now();
		monthBox.setSelectedIndex(date.getMonthValue()-1);
		yearBox.setSelectedIndex(0);
		int days=getDays(date.getMonthValue(), date.getYear());
		for(int i=0;i<days;i++) {
			dayBox.addItem(i+1);
		}
		dayBox.setSelectedIndex(date.getDayOfMonth()-1);
		notesArea.setText("");
		Collections.sort(todoItems);
		dlm.clear();
		for(int i=0;i<todoItems.size();i++) {
			dlm.addElement(todoItems.get(i).getName1());
		}
		jList.setModel(dlm);
		jList.clearSelection();
	}
	private int getDays(int month,int year) {
		
		if(month==4||month==6||month==9||month==11) {
			return 30;
		}
		else if(month!=2) {
			return 31;
		}
		else {
			if(year%400==0||year%4==0&&year%100!=0) {
				return 29;
			}
			else {
				return 28;
			}
		}
	}
}
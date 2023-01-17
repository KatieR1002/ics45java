package labs.lab9;

public class TodoItem implements Comparable<TodoItem>{
	private String name;
	private int priority;
	private boolean deadline;
	private int month;
	private int day;
	private int year;
	private String notes;
	private boolean done;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isDeadline() {
		return deadline;
	}
	public void setDeadline(boolean deadline) {
		this.deadline = deadline;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public int compareTo(TodoItem other) {
		// TODO Auto-generated method stub
		if(this.done==false&&other.done==true) {
			return -1;
		}
		else if(this.done==true&&other.done==false) {
			return 1;
		}
		else {
			if(this.priority!=other.priority) {
				return this.priority-other.priority;
			}
			else {
				if(this.name.compareTo(other.name)<0) {
					return -1;
				}
				else if(this.name.compareTo(other.name)>0) {
					return 1;
				}
			}
		}
		return 0;
	}
	public String getName1() {
		// TODO Auto-generated method stub
		if(done) {
			return "<html><s>"+name+"</s></html>";
		}
		else {
			return name;
		}
	}
	
}

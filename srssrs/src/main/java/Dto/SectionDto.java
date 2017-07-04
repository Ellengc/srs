package Dto;
/**
 * 
 */

import dao.main.Section;

/**
 * @author 陈炎青
 * 2017年7月1日  下午2:46:06
 */
public class SectionDto {

	private String sectionNo;
	private String name;
	private String capacity;
	private String room;
	private String time;
	private String day;
	private String teacher;
	private String credits;
	public String getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "SectionDto [sectionNo=" + sectionNo + ", name=" + name + ", capacity=" + capacity + ", room=" + room
				+ ", time=" + time + ", day=" + day + ", teacher=" + teacher + ", credits=" + credits + "]";
	}
	public SectionDto(Section section) {
		super();
		this.sectionNo = String.valueOf(section.getSectionNo());
		this.name = section.getCourse().getName();
		this.capacity = section.getEnrolledStudents().size()+"/"+String.valueOf(section.getCapacity());
		this.room = section.getRoom();
		this.time = section.getTimeOfDay();
		this.day = section.getDayOfWeek();
		this.teacher = section.getProfessor().getName()+"("+section.getProfessor().getTitle()+")";
		this.credits = String.valueOf(section.getCourse().getCredits());
	}
	
	public SectionDto() {
		super();
	}
	
}

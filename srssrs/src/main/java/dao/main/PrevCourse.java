package dao.main;

public class PrevCourse {
	private Course course;//课程
	private Course prevCourse;//先修课程
	public PrevCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PrevCourse(Course course, Course prevCourse) {
		super();
		this.course = course;
		this.prevCourse = prevCourse;
	}

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Course getPrevCourse() {
		return prevCourse;
	}
	public void setPrevCourse(Course prevCourse) {
		this.prevCourse = prevCourse;
	}
	
}

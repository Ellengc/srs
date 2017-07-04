package specification;

import dao.main.Section;
import dao.main.Student;

public interface Specification<T> {
	String validate(Student student, Section section);
}

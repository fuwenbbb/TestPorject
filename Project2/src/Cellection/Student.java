package Cellection;

import java.util.HashSet;
import java.util.Set;

/**
 * Ñ§ÉúÀà
 * @author fwb
 *
 */
public class Student {
	public String id;
	public String name;
	public Set<Course> course;
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.course = new HashSet<Course>();
	}
}

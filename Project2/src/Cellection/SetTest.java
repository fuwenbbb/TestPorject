package Cellection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年8月25日 上午10:14:53 
* 类说明
*/
public class SetTest {

	public List<Course> coursesToSelect;
	
	public SetTest(){
		this.coursesToSelect = new ArrayList<Course>();
	}
	
	public void TestAdd() {
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
//		System.out.println("添加了课程："+temp.id+"："+temp.name);
		
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
//		System.out.println("添加了课程："+temp2.id+"："+temp2.name);
		
//		coursesToSelect.add(cr1);
//		Course temp0 = (Course)coursesToSelect.get(2);
//		System.out.println("添加了课程："+temp.id+"："+temp.name);
		
		Course[] courses = {new Course("3", "汇编语言") , new Course("4", "离散数学")};
		coursesToSelect.addAll(Arrays.asList(courses));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
//		System.out.println("添加了课程："+temp3.id+"："+temp3.name+"、"+temp4.id+"："+temp4.name);
		
		Course[] courses2 = {new Course("5", "php语言") , new Course("6", "android")};
		coursesToSelect.addAll(2, Arrays.asList(courses2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
//		System.out.println("添加了课程："+temp5.id+"："+temp5.name+"、"+temp6.id+"："+temp6.name);
		
	}	
	
	/**
	 * 通过for each方法获取
	 * @param args
	 */
	public void testForEach(){
		System.out.println("有如下课程待选(通过for each获取)：");
		for(Object obj:coursesToSelect){
			Course course = (Course)obj;
			System.out.println("课程："+course.id+":"+course.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.TestAdd();
		st.testForEach();
//		创建一个学生对象
		Student student = new Student("1", "小明");
		System.out.println("欢迎学生："+student.name+"来选课！");
//		获取键盘输入
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0;i<3;i++){
			System.out.println("请输入课程ID：");
			String courseId = scanner.next();
			for(Course cr:st.coursesToSelect){
				if(cr.id.equals(courseId)){
					student.course.add(cr);
					/**
					 * 在Set中，添加某个对像，无论添加多少次，最终只会保留一个该对象（的引用），
					 * 并且保留的是第一次添加的那个
					 * 且还可以添加为空值
					 */
					student.course.add(null);
//					student.course.add(cr);
				}
			}
		}
		
		st.testForEachForSet(student);
	}
	
	public void testForEachForSet(Student student){
		for(Course cr:student.course){
			System.out.println("选择了课程："+cr.id+":"+cr.name);
		}
	}

}

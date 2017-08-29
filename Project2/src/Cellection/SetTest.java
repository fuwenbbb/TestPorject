package Cellection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��8��25�� ����10:14:53 
* ��˵��
*/
public class SetTest {

	public List<Course> coursesToSelect;
	
	public SetTest(){
		this.coursesToSelect = new ArrayList<Course>();
	}
	
	public void TestAdd() {
		Course cr1 = new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
//		System.out.println("����˿γ̣�"+temp.id+"��"+temp.name);
		
		Course cr2 = new Course("2", "C����");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
//		System.out.println("����˿γ̣�"+temp2.id+"��"+temp2.name);
		
//		coursesToSelect.add(cr1);
//		Course temp0 = (Course)coursesToSelect.get(2);
//		System.out.println("����˿γ̣�"+temp.id+"��"+temp.name);
		
		Course[] courses = {new Course("3", "�������") , new Course("4", "��ɢ��ѧ")};
		coursesToSelect.addAll(Arrays.asList(courses));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
//		System.out.println("����˿γ̣�"+temp3.id+"��"+temp3.name+"��"+temp4.id+"��"+temp4.name);
		
		Course[] courses2 = {new Course("5", "php����") , new Course("6", "android")};
		coursesToSelect.addAll(2, Arrays.asList(courses2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
//		System.out.println("����˿γ̣�"+temp5.id+"��"+temp5.name+"��"+temp6.id+"��"+temp6.name);
		
	}	
	
	/**
	 * ͨ��for each������ȡ
	 * @param args
	 */
	public void testForEach(){
		System.out.println("�����¿γ̴�ѡ(ͨ��for each��ȡ)��");
		for(Object obj:coursesToSelect){
			Course course = (Course)obj;
			System.out.println("�γ̣�"+course.id+":"+course.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.TestAdd();
		st.testForEach();
//		����һ��ѧ������
		Student student = new Student("1", "С��");
		System.out.println("��ӭѧ����"+student.name+"��ѡ�Σ�");
//		��ȡ��������
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0;i<3;i++){
			System.out.println("������γ�ID��");
			String courseId = scanner.next();
			for(Course cr:st.coursesToSelect){
				if(cr.id.equals(courseId)){
					student.course.add(cr);
					/**
					 * ��Set�У����ĳ������������Ӷ��ٴΣ�����ֻ�ᱣ��һ���ö��󣨵����ã���
					 * ���ұ������ǵ�һ����ӵ��Ǹ�
					 * �һ��������Ϊ��ֵ
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
			System.out.println("ѡ���˿γ̣�"+cr.id+":"+cr.name);
		}
	}

}

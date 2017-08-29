package Cellection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ListTest {

	public List coursesToSelect;
	
	public ListTest() {
		this.coursesToSelect = new ArrayList();
	}
	
	public void TestAdd() {
		Course cr1 = new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("����˿γ̣�"+temp.id+"��"+temp.name);
		
		Course cr2 = new Course("2", "C����");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("����˿γ̣�"+temp2.id+"��"+temp2.name);
		
		coursesToSelect.add(cr1);
		Course temp0 = (Course)coursesToSelect.get(2);
		System.out.println("����˿γ̣�"+temp.id+"��"+temp.name);
		
		Course[] courses = {new Course("3", "�������") , new Course("4", "��ɢ��ѧ")};
		coursesToSelect.addAll(Arrays.asList(courses));
		Course temp3 = (Course) coursesToSelect.get(3);
		Course temp4 = (Course) coursesToSelect.get(4);
		System.out.println("����˿γ̣�"+temp3.id+"��"+temp3.name+"��"+temp4.id+"��"+temp4.name);
		
		Course[] courses2 = {new Course("5", "php����") , new Course("6", "android")};
		coursesToSelect.addAll(2, Arrays.asList(courses2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("����˿γ̣�"+temp5.id+"��"+temp5.name+"��"+temp6.id+"��"+temp6.name);
		
	}	
	
	/**
	 * ȡ��list�е�Ԫ��
	 * @param args
	 */
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("�����¿γ̴�ѡ��");
		for(int i=0 ; i<size;i++){
			Course cr = (Course) coursesToSelect.get(i);
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
			
		}
	}
	
	/**
	 * ͨ��������������list
	 * @param args
	 */
	public void testIerator(){
		Iterator it = coursesToSelect.iterator();
		System.out.println("�����¿γ̴�ѡ(ͨ����������ȡ)��");
		while (it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
			
		}
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
	
	/**
	 * �޸�list��Ԫ��
	 * @param args
	 */
	public void testModify(){
		coursesToSelect.set(4, new Course("7", "ë��"));
	}
	
	/**
	 * ɾ��list��Ԫ��
	 * @param args
	 */
	public void testRemove(){
//		Course course = (Course) coursesToSelect.get(4);
		System.out.println("����ɾ��4��5�Ŀγ�");
		Course[] course ={(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(course));
//		coursesToSelect.remove(course);
		System.out.println("�ɹ�ɾ��!");
		testForEach();
	}
	
	public static void  main(String[] args) {
		ListTest p = new ListTest();
		p.TestAdd();
		p.testGet();
		p.testIerator();
		p.testForEach();
		p.testModify();
		p.testForEach();
		p.testRemove();
	}
}

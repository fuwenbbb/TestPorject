package Cellection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthStyle;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��8��24�� ����6:40:12 
* ��˵��
*/
public class TestGeneric {
	
	/**
	 * ����Course��list��������
	 */
	public List<Course> course;
	
	/**
	 * ���Է���
	 * @param args
	 */
	public TestGeneric(){
		this.course= new  ArrayList<Course>();
	}
	
	/**
	 * �������
	 * @param args
	 */
	public void testAdd(){
		Course cr1 = new Course("1", "��ѧ����");
		course.add(cr1);
//		���ͼ����У�������ӷ��͹涨�����ͼ�������������Ķ��󣬷���ᱨ��!
//		course.add("�����һЩ��ֵĶ����أ���");
		Course cr2 = new Course("2", "��ѧ��ѧ");
		course.add(cr2);
	}
	
	/**
	 * ���Ա���
	 * @param args
	 */
	public void testForEach(){
		for(Course cr : course){
			System.out.println(cr.id+cr.name);
		}
	}
	
	/**
	 * ���ͼ��Ͽ�����ӷ��͵������͵Ķ���ʵ��
	 * @param args
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name="���������͵Ŀγ̶���ʵ��~~";
		course.add(ccr);
	}
	
	/**
	 * ���Ͳ���ʹ�û�������
	 * @param args
	 */
	public void testBasicType(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("��������ʹ�����װ�࣡"+list.get(0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}

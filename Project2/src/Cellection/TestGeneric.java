package Cellection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthStyle;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年8月24日 下午6:40:12 
* 类说明
*/
public class TestGeneric {
	
	/**
	 * 带有Course的list类型属性
	 */
	public List<Course> course;
	
	/**
	 * 测试泛型
	 * @param args
	 */
	public TestGeneric(){
		this.course= new  ArrayList<Course>();
	}
	
	/**
	 * 测试添加
	 * @param args
	 */
	public void testAdd(){
		Course cr1 = new Course("1", "大学语文");
		course.add(cr1);
//		泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则会报错!
//		course.add("能添加一些奇怪的东西呢？？");
		Course cr2 = new Course("2", "大学数学");
		course.add(cr2);
	}
	
	/**
	 * 测试遍历
	 * @param args
	 */
	public void testForEach(){
		for(Course cr : course){
			System.out.println(cr.id+cr.name);
		}
	}
	
	/**
	 * 泛型集合可以添加泛型的子类型的对象实例
	 * @param args
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name="我是子类型的课程对象实例~~";
		course.add(ccr);
	}
	
	/**
	 * 泛型不能使用基本类型
	 * @param args
	 */
	public void testBasicType(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("基本类型使用其包装类！"+list.get(0));
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

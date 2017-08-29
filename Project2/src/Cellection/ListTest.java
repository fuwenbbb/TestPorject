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
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("添加了课程："+temp.id+"："+temp.name);
		
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("添加了课程："+temp2.id+"："+temp2.name);
		
		coursesToSelect.add(cr1);
		Course temp0 = (Course)coursesToSelect.get(2);
		System.out.println("添加了课程："+temp.id+"："+temp.name);
		
		Course[] courses = {new Course("3", "汇编语言") , new Course("4", "离散数学")};
		coursesToSelect.addAll(Arrays.asList(courses));
		Course temp3 = (Course) coursesToSelect.get(3);
		Course temp4 = (Course) coursesToSelect.get(4);
		System.out.println("添加了课程："+temp3.id+"："+temp3.name+"、"+temp4.id+"："+temp4.name);
		
		Course[] courses2 = {new Course("5", "php语言") , new Course("6", "android")};
		coursesToSelect.addAll(2, Arrays.asList(courses2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("添加了课程："+temp5.id+"："+temp5.name+"、"+temp6.id+"："+temp6.name);
		
	}	
	
	/**
	 * 取得list中的元素
	 * @param args
	 */
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i=0 ; i<size;i++){
			Course cr = (Course) coursesToSelect.get(i);
			System.out.println("课程："+cr.id+":"+cr.name);
			
		}
	}
	
	/**
	 * 通过迭代器来遍历list
	 * @param args
	 */
	public void testIerator(){
		Iterator it = coursesToSelect.iterator();
		System.out.println("有如下课程待选(通过迭代器获取)：");
		while (it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("课程："+cr.id+":"+cr.name);
			
		}
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
	
	/**
	 * 修改list中元素
	 * @param args
	 */
	public void testModify(){
		coursesToSelect.set(4, new Course("7", "毛概"));
	}
	
	/**
	 * 删除list中元素
	 * @param args
	 */
	public void testRemove(){
//		Course course = (Course) coursesToSelect.get(4);
		System.out.println("即将删除4和5的课程");
		Course[] course ={(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(course));
//		coursesToSelect.remove(course);
		System.out.println("成功删除!");
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

package Collection;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月11日 下午2:38:02 
* 类说明
* 1.通过Cellections.sort()方法，对Integer泛型的list进行排序
* 2.对String泛型的List进行排序
* 3.对其他类型泛型的List进行排序，比如Strdents
*/
public class CollectionsTest {

	/**
	 * 1.通过Cellections.sort()方法，对Integer泛型的list进行排序
	 * @param args
	 */
	public void testSort1(){
		List<Integer> integersList = new ArrayList<Integer>();
		Integer k;
		Random random = new Random();
		for(int i=0;i<10;i++){
			do {
				k = random.nextInt(100);
			} while (integersList.contains(k));
			integersList.add(k);
			System.out.println("添加元素："+k);
		}
		System.out.println("--------排序前--------");
		for (Integer integer : integersList) {
			System.out.println("元素："+integer);
		}
		Collections.sort(integersList);
		System.out.println("--------排序后--------");
		for (Integer integer : integersList) {
			System.out.println("元素："+integer);
		}
	}
	
	/**
	 * 2.对String泛型的List进行排序
	 * @param args
	 */
	public void testSort2(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("sina");
		System.out.println("-------排序前-------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("-------排序后-------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
	}
	
	/**
	 * 3.对其他类型泛型的List进行排序，比如Strdents
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000)+"","Mike"));
		studentList.add(new Student(random.nextInt(1000)+"","Lucy"));
		studentList.add(new Student(random.nextInt(1000)+"","Bear"));
		System.out.println("-------排序前-------");
		for (Student Student : studentList) {
			System.out.println("元素："+Student.id+"."+Student.name);
		}
		Collections.sort(studentList);
		System.out.println("-------排序后-------");
		for (Student Student : studentList) {
			System.out.println("元素："+Student.id+"."+Student.name);
		}
		//Comparator接口的临时比较
		Collections.sort(studentList, new StudentComparator());
		System.out.println("-------按照姓名排序后-------");
		for (Student Student : studentList) {
			System.out.println("元素："+Student.id+"."+Student.name);
		}
	}
	
	/**
	 * 随机练习
	 * 1.定义一个10以内的字符串
	 * 2.字符串内字符可以重复，但字符串不可以重复
	 * 3.
	 * @param args
	 */
	public void testSort4() {
		List<String> stringlist = new ArrayList<String>();
		String name = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String stringName;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			//定义一个可修改自身对象的StringBuilder类
			StringBuilder sb = new StringBuilder();
			do {
				
				int k = (int) Math.round(Math.random() * (9));
				for (int j = 0; j < k; j++) {
					//把随机整数添加为字符串
					int x = random.nextInt(name.length());
					sb.append(name.charAt(x));
				}
				//把StringBuilder类转成String类
				stringName = sb.toString();
			} while (stringlist.contains(stringName));
			System.out.println("添加元素："+stringName);
			stringlist.add(stringName);
		}
		System.out.println("-------排序前-------");
		for (String string : stringlist) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringlist);
		System.out.println("-------排序后-------");
		for (String string : stringlist) {
			System.out.println("元素："+string);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSort4();
		ct.testSort3();
	}

}

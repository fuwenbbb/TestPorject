package Collection;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��9��11�� ����2:38:02 
* ��˵��
* 1.ͨ��Cellections.sort()��������Integer���͵�list��������
* 2.��String���͵�List��������
* 3.���������ͷ��͵�List�������򣬱���Strdents
*/
public class CollectionsTest {

	/**
	 * 1.ͨ��Cellections.sort()��������Integer���͵�list��������
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
			System.out.println("���Ԫ�أ�"+k);
		}
		System.out.println("--------����ǰ--------");
		for (Integer integer : integersList) {
			System.out.println("Ԫ�أ�"+integer);
		}
		Collections.sort(integersList);
		System.out.println("--------�����--------");
		for (Integer integer : integersList) {
			System.out.println("Ԫ�أ�"+integer);
		}
	}
	
	/**
	 * 2.��String���͵�List��������
	 * @param args
	 */
	public void testSort2(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("sina");
		System.out.println("-------����ǰ-------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
		Collections.sort(stringList);
		System.out.println("-------�����-------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
	}
	
	/**
	 * 3.���������ͷ��͵�List�������򣬱���Strdents
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1+"","С��"));
		studentList.add(new Student(2+"","С��"));
		studentList.add(new Student(3+"","С��"));
		System.out.println("-------����ǰ-------");
		for (Student Student : studentList) {
			System.out.println("Ԫ�أ�"+Student);
		}
		//�����⣬student�ޱȽϹ���
//		Collections.sort(studentList);
		System.out.println("-------�����-------");
		for (Student Student : studentList) {
			System.out.println("Ԫ�أ�"+Student);
		}
	}
	
	/**
	 * �����ϰ
	 * 1.����һ��10���ڵ��ַ���
	 * 2.�ַ������ַ������ظ������ַ����������ظ�
	 * 3.
	 * @param args
	 */
	public void testSort4() {
		List<String> stringlist = new ArrayList<String>();
		String name = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String stringName;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			//����һ�����޸���������StringBuilder��
			StringBuilder sb = new StringBuilder();
			do {
				
				int k = (int) Math.round(Math.random() * (9));
				for (int j = 0; j < k; j++) {
					//������������Ϊ�ַ���
					int x = random.nextInt(name.length());
					sb.append(name.charAt(x));
				}
				//��StringBuilder��ת��String��
				stringName = sb.toString();
			} while (stringlist.contains(stringName));
			System.out.println("���Ԫ�أ�"+stringName);
			stringlist.add(stringName);
		}
		System.out.println("-------����ǰ-------");
		for (String string : stringlist) {
			System.out.println("Ԫ�أ�"+string);
		}
		Collections.sort(stringlist);
		System.out.println("-------�����-------");
		for (String string : stringlist) {
			System.out.println("Ԫ�أ�"+string);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
		ct.testSort4();
	}

}

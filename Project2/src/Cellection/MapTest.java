package Cellection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年8月25日 上午11:09:04 
* 类说明
*/
public class MapTest {

	/**
	 * 用来承装学生类型对象
	 */
	public Map<String, Student> students;
	
	/**
	 * 在构造器中初始化studens属性
	 * @param args
	 */
	public MapTest(){
		this.students = new HashMap<String,Student>();
	}
	
	/**
	 * 测试添加：输入学生ID，判断是否被占用
	 * 若未被占用，则输入姓名，创建新学生对象
	 * 并且，添加到students中
	 */
	public void testPut(){
		//创建一个scanner对象，用例获取输入学生的ID和姓名
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while (i<3) {
			System.out.println("请输入学生ID");
			String ID = scanner.next();
			//判断该ID是否被占用
			Student st = students.get(ID);
			if(st == null){
				//提示输入学生姓名
				System.out.println("请输入学生姓名");
				String name = scanner.next();
				//创建新的学生对象
				Student newstudent = new Student(ID, name);
				//通过调用students的put方法，添加ID-学生映射
				students.put(ID, newstudent);
				System.out.println("成功输入学生："+students.get(ID).name);
				i++;
			}else{
				System.out.println("该ID已被占用!");
				continue;
			}
		}
	}
	
	/**
	 * 测试Map的KeySet方法
	 * @param args
	 */
	public void testKeySet(){
		//通过KeySet方法，返回Map中的所有”键”的Set集合
		Set<String> KeySet = students.keySet();
		//取得students的容量
		System.out.println("总共有"+students.size()+"个学生。");
		//遍历KeySet，取得每一个键，在调用get方法取得每个键对应的value
		for(String stuId :KeySet){
			Student st = students.get(stuId);
			if(st!=null){
				System.out.println("学生："+st.name);
			}
		}
	}
	
	/**
	 * 测试删除
	 * @param args
	 */
	public void testRemove(){
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入要删除学生ID");
			String ID = scanner.next();
			//判断该ID是否被占用
			Student st = students.get(ID);
			if(st==null){
				System.out.println("该ID已被占用!");
				continue;
			}
			students.remove(ID);
			System.out.println("成功删除"+st.name);
			break;
		}
	}
	
	/**
	 * 通过entrySet方法来遍历Map
	 * @param args
	 */
	public void testEntrySet(){
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for(Entry<String, Student>entry :entrySet){
			System.out.println("取得键："+entry.getKey());
			System.out.println("对应的值为："+entry.getValue().name);
		}
	}
	
	/**
	 * 利用put方法修改Map中的value值（已有映射）
	 * @param args
	 */
	public void testModify(){
		System.out.println("请输入要修改的学生ID：");
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String stuId = scanner.next();
			if(stuId == null){
				System.out.println("该ID不存在，请重新输入!");
				continue;
			}
			System.out.println("该学生是："+stuId+"、"+students.get(stuId).name);
			System.out.println("请输入要修改的学生姓名：");
			String name = scanner.next();
			Student newstudent = new Student(stuId, name);
			students.put(stuId, newstudent);
			break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
//		mt.testRemove();
//		mt.testEntrySet();
		mt.testModify();
		mt.testEntrySet();
	}

}

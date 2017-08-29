package Cellection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��8��25�� ����11:09:04 
* ��˵��
*/
public class MapTest {

	/**
	 * ������װѧ�����Ͷ���
	 */
	public Map<String, Student> students;
	
	/**
	 * �ڹ������г�ʼ��studens����
	 * @param args
	 */
	public MapTest(){
		this.students = new HashMap<String,Student>();
	}
	
	/**
	 * ������ӣ�����ѧ��ID���ж��Ƿ�ռ��
	 * ��δ��ռ�ã�������������������ѧ������
	 * ���ң���ӵ�students��
	 */
	public void testPut(){
		//����һ��scanner����������ȡ����ѧ����ID������
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while (i<3) {
			System.out.println("������ѧ��ID");
			String ID = scanner.next();
			//�жϸ�ID�Ƿ�ռ��
			Student st = students.get(ID);
			if(st == null){
				//��ʾ����ѧ������
				System.out.println("������ѧ������");
				String name = scanner.next();
				//�����µ�ѧ������
				Student newstudent = new Student(ID, name);
				//ͨ������students��put���������ID-ѧ��ӳ��
				students.put(ID, newstudent);
				System.out.println("�ɹ�����ѧ����"+students.get(ID).name);
				i++;
			}else{
				System.out.println("��ID�ѱ�ռ��!");
				continue;
			}
		}
	}
	
	/**
	 * ����Map��KeySet����
	 * @param args
	 */
	public void testKeySet(){
		//ͨ��KeySet����������Map�е����С�������Set����
		Set<String> KeySet = students.keySet();
		//ȡ��students������
		System.out.println("�ܹ���"+students.size()+"��ѧ����");
		//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
		for(String stuId :KeySet){
			Student st = students.get(stuId);
			if(st!=null){
				System.out.println("ѧ����"+st.name);
			}
		}
	}
	
	/**
	 * ����ɾ��
	 * @param args
	 */
	public void testRemove(){
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("������Ҫɾ��ѧ��ID");
			String ID = scanner.next();
			//�жϸ�ID�Ƿ�ռ��
			Student st = students.get(ID);
			if(st==null){
				System.out.println("��ID�ѱ�ռ��!");
				continue;
			}
			students.remove(ID);
			System.out.println("�ɹ�ɾ��"+st.name);
			break;
		}
	}
	
	/**
	 * ͨ��entrySet����������Map
	 * @param args
	 */
	public void testEntrySet(){
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for(Entry<String, Student>entry :entrySet){
			System.out.println("ȡ�ü���"+entry.getKey());
			System.out.println("��Ӧ��ֵΪ��"+entry.getValue().name);
		}
	}
	
	/**
	 * ����put�����޸�Map�е�valueֵ������ӳ�䣩
	 * @param args
	 */
	public void testModify(){
		System.out.println("������Ҫ�޸ĵ�ѧ��ID��");
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String stuId = scanner.next();
			if(stuId == null){
				System.out.println("��ID�����ڣ�����������!");
				continue;
			}
			System.out.println("��ѧ���ǣ�"+stuId+"��"+students.get(stuId).name);
			System.out.println("������Ҫ�޸ĵ�ѧ��������");
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

package Collection;

import java.util.Comparator;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��9��12�� ����10:42:50 
* ��˵��
*/
public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		return arg0.name.compareTo(arg1.name);
	}

}

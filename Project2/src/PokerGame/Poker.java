package PokerGame;
/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��9��12�� ����11:03:15 
* ��˵��
*/
public class Poker {
	
	//�����˿���
	public String name;
	public String id;
	public Poker(String name,String id){
		this.id=id;
		this.name=name;
	}
	
	public Poker(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Poker))
			return false;
		Poker other = (Poker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

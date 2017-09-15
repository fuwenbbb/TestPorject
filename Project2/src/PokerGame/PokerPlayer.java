package PokerGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月12日 上午11:12:52 
* 类说明
*/
public class PokerPlayer {

	//定义玩家
	public String name;
	public String id;
//	public Set<Poker> poker;
	List<Poker> pokerPlayerList = new ArrayList<Poker>();
	public PokerPlayer(String id,String name){
		this.id=id;
		this.name=name;
//		this.poker= new HashSet<Poker>();
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((poker == null) ? 0 : poker.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof PokerPlayer))
//			return false;
//		PokerPlayer other = (PokerPlayer) obj;
//		if (poker == null) {
//			if (other.poker != null)
//				return false;
//		} else if (!poker.equals(other.poker))
//			return false;
//		return true;
//	}
	
}

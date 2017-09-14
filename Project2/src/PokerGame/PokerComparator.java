package PokerGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月14日 下午6:21:22 
* 类说明
*/
public class PokerComparator implements Comparator<Poker> {
	public final String PokerName [] ={"黑桃","红桃","梅花","方块"};
	public final String PokerId [] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

	@Override
	public int compare(Poker o1, Poker o2) {
		// TODO Auto-generated method stub
		List<Poker> Poker1 = new ArrayList<Poker>();
		List<Poker> Poker2 = new ArrayList<Poker>();
		
		
		return 0;
	}

}

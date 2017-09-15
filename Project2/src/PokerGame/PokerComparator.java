package PokerGame;

import java.util.Comparator;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月14日 下午6:21:22 
* 类说明
*/
public class PokerComparator implements Comparator<Poker> {
	
	@Override
	public int compare(Poker o1, Poker o2) {
		// TODO Auto-generated method stub
		final String PokerName [] ={"黑桃","红桃","梅花","方块"};
		final String PokerId [] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		int n1=0,n2=0;
		for(int i = 0;i<PokerId.length;i++){
			if(o1.id==PokerId[i])
				n1=i;
			if(o2.id==PokerId[i])
				n2=i;
		}
		if(n1==n2){
			int c1=0,c2=0;
			for(int j= 0;j<PokerName.length;j++){
				if(o1.name==PokerId[j])
					c1=j;
				if(o2.name==PokerId[j])
					c2=j;
			}
			if(c1>c2){
				return -1;
			}else {
				return 1;
			}
		}
		if(n1>n2)
			return -1;
		else
			return 1;
	}

}

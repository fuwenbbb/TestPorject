package PokerGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月12日 上午11:35:44 
* 类说明
*/
public class Game {
	/**
	 * 用来承装选手类型对象
	 */
	public Map<String, PokerPlayer> pokerPlayer;
	public List<Poker> pokerToSelect;
//	public PokerPlayer pokerPlayer2;
	public Scanner scanner;
	public final String Pokertype [] ={"黑桃","红桃","梅花","方块"};
	public final String Pokernum [] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	
	/**
	 * 在构造器中初始化pokerPlayer属性
	 * @param args
	 */
	public Game(){
		this.pokerPlayer = new HashMap<String,PokerPlayer>();
		this.pokerToSelect = new ArrayList<Poker>();
	}
	
	/**
	 * 创建扑克牌
	 */
	public void createdPoker(){
		for(int i = 0;i < Pokertype.length;i++){
			for(int j = 0;j <Pokernum.length;j++){
				pokerToSelect.add(new Poker(Pokertype[i], Pokernum[j]));
			}
		}
//		for (Poker string : pokersList) {
//			System.out.println(string.name+string.id);
//		}
		System.out.println("--------创建扑克牌成功！----------");
		System.out.println("--------洗扑克牌成功！----------");
	}
	
	/**
	 * 创建玩家
	 * @param args
	 */
	public void createdPokerPlayer(){
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while (i<2) {
			System.out.println("请输入第"+(i+1)+"位玩家ID：");
			String ID = scanner.next();
			//判断该ID是否被占用
			PokerPlayer pp = pokerPlayer.get(ID);
			if(pp == null){
				//提示输入玩家姓名
				System.out.println("请输入"+(i+1)+"位玩家姓名：");
				String name = scanner.next();
				//创建新的玩家对象
				PokerPlayer newpokerPlayer = new PokerPlayer(ID, name);
				//通过调用PokerPlayer的put方法，添加ID-玩家映射
				pokerPlayer.put(ID, newpokerPlayer);
				System.out.println("成功输入玩家："+pokerPlayer.get(ID).name);
				i++;
			}else{
				System.out.println("该ID已被占用!");
				continue;
			}
		}
		/*
		 * 遍历pokerPlayer中的玩家
		 */
		Set<String> KeySet = pokerPlayer.keySet();
		//取得pokerPlayer的容量
		System.out.println("总共有"+pokerPlayer.size()+"个玩家。");
		//遍历KeySet，取得每一个键，在调用get方法取得每个键对应的value
		for(String stuId :KeySet){
			PokerPlayer player = pokerPlayer.get(stuId);
			if(player!=null){
				System.out.println("---欢迎玩家："+player.name);
			}
		}
	}
	
	/**
	 * 发牌
	 * @param args
	 */
	public void dealPoker(){
		System.out.println("--------开始发牌...--------");
		PokerPlayer player;
		for(int i=0;i<2;i++){
			Set<String> KeySet = pokerPlayer.keySet();
			//遍历KeySet，取得每一个键，在调用get方法取得每个键对应的value
			for(String playerId :KeySet){
				player = pokerPlayer.get(playerId);
				Random random = new Random();
				Poker pokerID  = (Poker) pokerToSelect.get(random.nextInt(pokerToSelect.size()));
				if(player!=null){
					for (Poker p : pokerToSelect) {
						if(p.id.equals(pokerID.id)&&p.name.equals(pokerID.name)){
							player.poker.add(p);
						}
					}
				}
				System.out.println("---玩家："+player.name+"-拿牌");
				for (Poker string : player.poker) {
					 System.out.println(string.name+"."+string.id);
				}
			}
		}
		System.out.println("--------发牌结束！--------");
	}
	
	/**
	 * 开始游戏
	 * @param args
	 */
	public void startGame(){
		System.out.println("--------开始游戏！--------");
		PokerPlayer player;
		Set<String> KeySet = pokerPlayer.keySet();
		//遍历KeySet，取得每一个键，在调用get方法取得每个键对应的value
		for(String playerId :KeySet){
			player = pokerPlayer.get(playerId);
			for (Poker string : player.poker) {
				
				if(player!=null){
					System.out.println(player.name+":"+string.name+"."+string.id);
					
				}
				
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.createdPoker();
		game.createdPokerPlayer();
		game.dealPoker();
		game.startGame();
	}

}

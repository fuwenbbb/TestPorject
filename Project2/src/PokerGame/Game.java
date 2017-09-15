package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import Collection.Student;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��9��12�� ����11:35:44 
* ��˵��
*/
public class Game {
	/**
	 * ������װѡ�����Ͷ���
	 */
	public Map<String, PokerPlayer> pokerPlayer;
	public List<Poker> pokerToSelect;
//	public PokerPlayer pokerPlayer2;
	public Scanner scanner;
	public final String Pokertype [] ={"����","����","÷��","����"};
	public final String Pokernum [] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	
	/**
	 * �ڹ������г�ʼ��pokerPlayer����
	 * @param args
	 */
	public Game(){
		this.pokerPlayer = new HashMap<String,PokerPlayer>();
		this.pokerToSelect = new ArrayList<Poker>();
	}
	
	/**
	 * �����˿���
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
		System.out.println("--------�����˿��Ƴɹ���----------");
//		System.out.println("--------ϴ�˿��Ƴɹ���----------");
	}
	
	/**
	 * �������
	 * @param args
	 */
	public void createdPokerPlayer(){
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while (i<2) {
			System.out.println("�������"+(i+1)+"λ���ID��");
			String ID = scanner.next();
			//�жϸ�ID�Ƿ�ռ��
			PokerPlayer pp = pokerPlayer.get(ID);
			if(pp == null){
				//��ʾ�����������
				System.out.println("������"+(i+1)+"λ���������");
				String name = scanner.next();
				//�����µ���Ҷ���
				PokerPlayer newpokerPlayer = new PokerPlayer(ID, name);
				//ͨ������PokerPlayer��put���������ID-���ӳ��
				pokerPlayer.put(ID, newpokerPlayer);
				System.out.println("�ɹ�������ң�"+pokerPlayer.get(ID).name);
				i++;
			}else{
				System.out.println("��ID�ѱ�ռ��!");
				continue;
			}
		}
		/*
		 * ����pokerPlayer�е����
		 */
		Set<String> KeySet = pokerPlayer.keySet();
		//ȡ��pokerPlayer������
		System.out.println("�ܹ���"+pokerPlayer.size()+"����ҡ�");
		//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
		for(String stuId :KeySet){
			PokerPlayer player = pokerPlayer.get(stuId);
			if(player!=null){
				System.out.println("---��ӭ��ң�"+player.name);
			}
		}
	}
	
//	/**
//	 * ϴ�ƺͷ���--�ϰ�
//	 * @param args
//	 */
//	public void dealPoker(){
//		System.out.println("--------��ʼ����...--------");
//		PokerPlayer player;
//		for(int i=0;i<2;i++){
//			Set<String> KeySet = pokerPlayer.keySet();
//			//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
//			for(String playerId :KeySet){
//				player = pokerPlayer.get(playerId);
//				Random random = new Random();
//				Poker pokerID  = (Poker) pokerToSelect.get(random.nextInt(pokerToSelect.size()));
//				if(player!=null){
//					for (Poker p : pokerToSelect) {
//						if(p.id.equals(pokerID.id)&&p.name.equals(pokerID.name)){
//							player.poker.add(p);
//						}
//					}
//				}
//				System.out.println("---��ң�"+player.name+"-����");
//				for (Poker string : player.poker) {
//					 System.out.println(string.name+"."+string.id);
//				}
//			}
//		}
//		System.out.println("--------���ƽ�����--------");
//	}
	
	
	/**
	 * ϴ��
	 * @param args
	 */
	public void shuffedPoker(){
		Collections.shuffle(pokerToSelect);
		System.out.println("--------ϴ�˿��Ƴɹ���----------");
	}
	
	/**
	 * ����
	 */
	public void sendPoker(){
		System.out.println("--------��ʼ����...--------");
		//���һ������
		System.out.println("---��ң�"+pokerPlayer.get("1").name+"-����");
		pokerPlayer.get("1").pokerPlayerList.add(pokerToSelect.get(0));
		System.out.println("---��ң�"+pokerPlayer.get("2").name+"-����");
		pokerPlayer.get("2").pokerPlayerList.add(pokerToSelect.get(1));
		//��Ҷ�������
		System.out.println("---��ң�"+pokerPlayer.get("1").name+"-����");
		pokerPlayer.get("1").pokerPlayerList.add(pokerToSelect.get(2));
		System.out.println("---��ң�"+pokerPlayer.get("2").name+"-����");
		pokerPlayer.get("2").pokerPlayerList.add(pokerToSelect.get(3));
//		Set<String> KeySet = pokerPlayer.keySet();
		//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
//		for(String pokerPlayerId :KeySet){
//			PokerPlayer st = pokerPlayer.get(pokerPlayerId);
//			if(st!=null){
//				
//				System.out.println("---��ң�"+pokerPlayer.get(pokerPlayerId).name+"-����");
//				pokerPlayer.get(pokerPlayerId).pokerPlayerList.add(pokerToSelect.get(0));
//				System.out.println("---��ң�"+pokerPlayer.get(pokerPlayerId).name+"-����");
//				pokerPlayer.get(pokerPlayerId).pokerPlayerList.add(pokerToSelect.get(1));
//			}
//		}
//		
		
		
		System.out.println("--------���ƽ�����--------");
	}

	
	/**
	 * ��ʼ��Ϸ
	 * @param args
	 */
	public void startGame(){
		System.out.println("--------��ʼ��Ϸ��--------");
		PokerComparator pokerComparator = new PokerComparator();
		List<Poker> p1 = new ArrayList<Poker>();
		List<Poker> p2 = new ArrayList<Poker>();
		//���һ�ĵ�һ����
		p1.add(0, pokerPlayer.get("1").pokerPlayerList.get(0));
		//���һ�ĵڶ�����
		p1.add(1, pokerPlayer.get("1").pokerPlayerList.get(1));
		//��Ҷ��ĵ�һ����
		p2.add(0, pokerPlayer.get("2").pokerPlayerList.get(0));
		//��Ҷ��ĵڶ�����
		p2.add(1, pokerPlayer.get("2").pokerPlayerList.get(1));
		//�Ƚ���Ҹ��Ե����ƴ�С
		int a = pokerComparator.compare(p1.get(0), p1.get(1));
		int b = pokerComparator.compare(p2.get(0), p2.get(1));
		if(a>0){
			if(b>0){
				int c =pokerComparator.compare(p1.get(1), p2.get(1));
				if(c>0){
					System.out.println("--------��ʤ����"+pokerPlayer.get("2").name);
				}else{
					System.out.println("--------��ʤ����"+pokerPlayer.get("1").name);
				}
			}else{
				int c =pokerComparator.compare(p1.get(1), p2.get(0));
				if(c>0){
					System.out.println("--------��ʤ����"+pokerPlayer.get("2").name);
				}else{
					System.out.println("--------��ʤ����"+pokerPlayer.get("1").name);
				}
			}
		}else {
			if(b>0){
				int c =pokerComparator.compare(p1.get(0), p2.get(1));
				if(c>0){
					System.out.println("--------��ʤ����"+pokerPlayer.get("2").name);
				}else{
					System.out.println("--------��ʤ����"+pokerPlayer.get("1").name);
				}
			}else{
				int c =pokerComparator.compare(p1.get(0), p2.get(0));
				if(c>0){
					System.out.println("--------��ʤ����"+pokerPlayer.get("2").name);
				}else{
					System.out.println("--------��ʤ����"+pokerPlayer.get("1").name);
				}
			}
		}
		
	}
	
	/**
	 * չʾ�������
	 * @param args
	 */
	public void showPlayerPoker(){
//		Set<String> KeySet = pokerPlayer.keySet();
		for (String pl  : pokerPlayer.keySet()) {
			 System.out.println("---��ң�"+pokerPlayer.get(pl).name+"-����:");
			 for (Poker poker :pokerPlayer.get(pl).pokerPlayerList ) {
				 System.out.println(poker.name+"."+poker.id);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.createdPoker();
		game.createdPokerPlayer();
//		game.dealPoker();
		game.shuffedPoker();
		game.sendPoker();
		game.startGame();
		game.showPlayerPoker();
	}

}

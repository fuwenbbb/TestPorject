package PokerGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
		System.out.println("--------ϴ�˿��Ƴɹ���----------");
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
	
	/**
	 * ����
	 * @param args
	 */
	public void dealPoker(){
		System.out.println("--------��ʼ����...--------");
		PokerPlayer player;
		for(int i=0;i<2;i++){
			Set<String> KeySet = pokerPlayer.keySet();
			//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
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
				System.out.println("---��ң�"+player.name+"-����");
				for (Poker string : player.poker) {
					 System.out.println(string.name+"."+string.id);
				}
			}
		}
		System.out.println("--------���ƽ�����--------");
	}
	
	/**
	 * ��ʼ��Ϸ
	 * @param args
	 */
	public void startGame(){
		System.out.println("--------��ʼ��Ϸ��--------");
		PokerPlayer player;
		Set<String> KeySet = pokerPlayer.keySet();
		//����KeySet��ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
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

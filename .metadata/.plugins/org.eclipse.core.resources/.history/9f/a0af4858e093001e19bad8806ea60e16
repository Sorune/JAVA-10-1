package Test;

import java.util.*;

public class Game {
	public static class Player {
		String name = "";
		int hp = 100;
		int action = 0;
		int deffence = 10;
		int attackDmg = 10;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String keepGoing = "y";
		int pUp;
		while (keepGoing.equals("y")) {
			Player player1 = new Player();
			Player player2 = new Player();
			
			
			System.out.println("-----------------------------------");
			System.out.println("게임을 시작합니다.");
			
			while (!(player1.hp <= 0 || player2.hp <= 0)) {

				
				System.out.println("-----------------------------------");
				System.out.println("player2의 차례입니다.");
				System.out.println("행동을 결정해주세요");
				System.out.println("1. 공격 \t 2. 방어");
				System.out.println("3. 파워업 \t 4. 가만히 있기");
				System.out.println("-----------------------------------");
				System.out.print(">>> ");
				player2.action = in.nextInt();
				

				if (player1.action == 2 && player2.action==1) {
					if (player2.attackDmg <= player1.deffence) {
					System.out.println("player2이 공격 방어에 성공하였습니다.");
					} else {
						player1.hp += (player1.deffence - player2.attackDmg);
						System.out.printf("player2이 공격 방어에 실패하였습니다.\n");
						System.out.printf("player1의 남은 체력은 %d입니다.\n",player1.hp);
					}
				}
					
				
				if (player1.action != 2 && player2.action == 1) {
					System.out.println("player1이 공격당했습니다.");
					player1.hp -= player2.attackDmg;
					System.out.printf("player1의 남은 체력은 %d입니다.\n",player1.hp);
				} 
				
				if (player1.action == 3) {
					pUp = randomUp();
					player1.attackDmg+=pUp;
					System.out.printf("player1의 공격 데미지 %d증가!\n",pUp);
				}
				
				if (player2.action == 2 && player1.action == 1) {
					if (player1.attackDmg <= player2.deffence) {
					System.out.println("player2이 공격 방어에 성공하였습니다.");
					} else {
						player2.hp += (player2.deffence - player1.attackDmg);
						System.out.printf("player2이 공격 방어에 실패하였습니다.\n");
						System.out.printf("player1의 남은 체력은 %d입니다.\n",player2.hp);
					}
					
				}
				
				if (player2.action != 2 && player1.action == 1) {
					System.out.println("player2이 공격당했습니다.");
					player2.hp -= player1.attackDmg;
					System.out.printf("player2의 남은 체력은 %d입니다.\n",player2.hp);
				}
				
				if (player2.action == 3) {
					pUp = randomUp();
					player2.attackDmg+=pUp;
					System.out.printf("player2의 공격 데미지 %d증가!\n",pUp);
				}
				
			}
			if (player1.hp > player2.hp) {
				System.out.println("player1 승리!");
			} else if (player2.hp > player1.hp) {
				System.out.println("player2 승리!");
			}
			System.out.println("계속하시겠습니까? 계속하시려면 y를 눌러주세요");
			keepGoing = in.next();
		}
	}
	
	public static int randomUp() {
		return  (int) (Math.random()*6);
	}

	
}

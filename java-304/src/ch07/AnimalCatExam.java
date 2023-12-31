package ch07;

import java.util.Scanner;

public class AnimalCatExam {

   public static void main(String[] args) {
      // AnimalCat 인스턴스를 불러와 메인메서드에서 실행하자
      Scanner in = new Scanner(System.in);
      AnimalCat aCat = new AnimalCat(); // 인스턴스 사용시 객체생성 및 aCat변수에 저장
      // 변수선언
      
      int[] test;
      
      // 인스턴스의 필드(변수)를 불러와 메인메서드에 출력
      System.out.println("이 고양이의 이름은 : " + aCat.name + "입니다.");
      System.out.println("이 고양이의 색깔은 : " + aCat.color + "입니다.");
      System.out.println("이 고양이의 나이는 : " + aCat.age + "살 입니다.");

      System.out.println("시간을 입력하면 고양이가 무슨 행동을 하는지 알 수 있어요!(8시, 12시, 18시 중에 입력-숫자만)");
      for (int i = 0; i < aCat.action.length; i++) {
         System.out.println("시간을 입력해주세요 : 번 >>> ");
         aCat.action[i] = in.nextInt();
      } // 입력용 for문 종료
      
      for (int i = 0; i < aCat.action.length; i++) {
         System.out.println("입력받은 시간은 : " + aCat.action[i]);
         // 인스턴스의 메서드(동작)을 불러와 메인메서드에 출력
         if (aCat.action[i] == 8) {
            aCat.eat();
         } else if (aCat.action[i] == 12) {
            aCat.scratch();
         } else if (aCat.action[i] == 16) {
            aCat.meow();
         } else {
            System.out.println("고양이는 잠만 잡니다... 쿨쿨쿨zzz");
         }
      } // 출력용 for문 종료
   } // main() 종료
} // class 종료
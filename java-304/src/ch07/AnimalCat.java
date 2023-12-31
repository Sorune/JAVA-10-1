package ch07;

public class AnimalCat {
   // field
   String name; // 고양이의 이름
   String color; // 고양이의 색깔
   int age;     // 고양이의 나이
   int[] action;     // 고양이의 하루의 시간의 행동
   

   
   // create
   AnimalCat() {
      name = "breed";
      color = "회색";
      age = 2;
      action = new int[3]; // 고양이의 시간 3가지 배열로 입력
   }
   
   // Method
   void eat() {
      System.out.println("고양이는 밥을 먹습니다.");
   }

   void scratch() {
      System.out.println("고양이는 득득이를 합니다.");
   }

   void meow() {
      System.out.println("고양이는 야옹~ 하고 웁니다.");
   }
}
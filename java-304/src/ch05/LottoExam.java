package ch05;

import java.util.*;

public class LottoExam {

	public static int Lotto(int number, int num1, int num2,int num3,int num4,int num5,int num6,int num7) {

		int correct = 0;
	
		if (number == num1) {correct ++;}
		if (number == num2) {correct ++;}
		if (number == num3) {correct ++;}
		if (number == num4) {correct ++;}
		if (number == num5) {correct ++;}
		if (number == num6) {correct ++;}
		if (number == num7) {correct ++;}
		
		return correct;
			
		}
	
	public static void main(String[] args) {
		//로또 당첨 프로그램
		//랜덤값으로 1~45의 숫자를 맞추세요
		Scanner input = new Scanner(System.in);
		
		while (true) {
//			try {

				int num1 = (int)(Math.random()*45)+1;
				int num2 = (int)(Math.random()*45)+1;
				int num3 = (int)(Math.random()*45)+1;
				int num4 = (int)(Math.random()*45)+1;
				int num5 = (int)(Math.random()*45)+1;
				int num6 = (int)(Math.random()*45)+1;
				int num7 = (int)(Math.random()*45)+1;
				
				int correct = 0;

				System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
				int number1 = input.nextInt();
				
				
				if ((number1>45)||(number1<1)) {
					System.out.println("1~45 사이의 숫자만 입력해주세요.");
				} else { 
					correct += Lotto(number1, num1,num2,num3,num4,num5,num6,num7);

					System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
					int number2 = input.nextInt();
					
					if ((number2>45)||(number2<1)) {
						System.out.println("1~45 사이의 숫자만 입력해주세요.");
					} else { 
						correct += Lotto(number2, num1,num2,num3,num4,num5,num6,num7);
						
						System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
						int number3 = input.nextInt();
						
						if ((number3>45)||(number3<1)) {
							System.out.println("1~45 사이의 숫자만 입력해주세요.");
						} else { 
							correct += Lotto(number3, num1,num2,num3,num4,num5,num6,num7);
							
							System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
							int number4 = input.nextInt();
							
							if ((number4>45)||(number4<1)) {
								System.out.println("1~45 사이의 숫자만 입력해주세요.");
							} else { 
								correct += Lotto(number4, num1,num2,num3,num4,num5,num6,num7);

								System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
								int number5 = input.nextInt();
								
								if ((number5>45)||(number5<1)) {
									System.out.println("1~45 사이의 숫자만 입력해주세요.");
								} else { 
									correct += Lotto(number5, num1,num2,num3,num4,num5,num6,num7);

									System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
									int number6 = input.nextInt();
									
									if ((number6>45)||(number6<1)) {
										System.out.println("1~45 사이의 숫자만 입력해주세요.");
									} else { 
										correct += Lotto(number6, num1,num2,num3,num4,num5,num6,num7);

										System.out.print("숫자를 입력하세요(종료는 아무문자나 입력해주세요) : ");
										int number7 = input.nextInt();
										
										if ((number7>45)||(number7<1)) {
											System.out.println("1~45 사이의 숫자만 입력해주세요.");
										} else { 
											correct += Lotto(number7, num1,num2,num3,num4,num5,num6,num7);

											System.out.printf("%d %d %d %d %d %d %d \n",num1,num2,num3,num4,num5,num6,num7);
											System.out.println(correct);
											
											if (correct > 0) {
												if (correct > 1) {
													if (correct > 2) {
														if (correct > 3) {
															if (correct > 4) {
																if (correct > 5) {
																	if (correct > 6) {
																		System.out.println("축하드립니다. 1등에 당첩되셨습니다.");
																	} else {
																		System.out.println("축하드립니다. 2등에 당첨되셨습니다.");
																	}
																} else {
																System.out.println("축하드립니다. 3등에 당첨되셨습니다.");
															}
														} else {
															System.out.println("축하드립니다. 4등에 당첨되셨습니다.");
														}
													} else {
														System.out.println("축하드립니다. 5등에 당첨되셨습니다.");
													}
												} else {
													System.out.println("축하드립니다. 당첨되셨습니다.");
												}
												}
											continue;
											} else {
											System.out.println("안타깝네요. 다음 기회에~");
											continue;
											}
										}
									}
								}
							}
						}
					}

				
				}

//			} finally {
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}
		}
			
	}
}

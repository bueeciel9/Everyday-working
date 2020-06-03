package animalGame;

import java.util.Scanner;

public class AnimalMain {
	public static void main(String[] args) {
		//���� 3���� Ŭ���� �迭�� ����
		AnimalField[] animals = {
			new AnimalField("�ٵ���", "����", 4.5, 5, 5),
			new AnimalField("�ܲ���", "������", 9.9, 8, 2),
			new AnimalField("�ؼ���", "����", 7.5, 3, 7)
		};
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int choice = 0;
		int menu_choice = 0;
		
		while(true) {
			boolean check = false;
			
			System.out.println("[�𿩶� ���� ����!]");
			for (i = 0; i < animals.length; i++) {
				System.out.println(i+1 + "." + animals[i].name);
			}
			System.out.println(i+1 + ".������");
			choice = sc.nextInt();
			
			if(choice == i+1) {
				break;
			}
			
			while(true) {
				System.out.println("1.��Ա�\n2.��å�ϱ�\n3.���ڱ�\n4.ĳ���� ����â");
				menu_choice = sc.nextInt();
				
				if(menu_choice == 4) {break;}
				
				switch(menu_choice) {
				//��Ա�
				case 1:
					animals[choice-1].eat();
					if(animals[choice-1].weight >= 100){
						animals[choice-1].sleep();
//						check = true;
					}
					break;
				//��å�ϱ�
				case 2:
					animals[choice-1].walk();
					if(animals[choice-1].hp == 0) {
						animals[choice-1].sleep();
//						check = true;
					}
					break;
				//���ڱ�
				case 3:
					animals[choice-1].sleep();
					break;
				}
				
//				if(check) {
//					System.out.println(animals[choice-1].name + " �ȳ�~");
//					AnimalField[] arTemp = {
//							new AnimalField("�ٵ���", "����", 4.5, 5, 5),
//							new AnimalField("�ܲ���", "������", 9.9, 8, 2),
//							new AnimalField("�ؼ���", "����", 7.5, 3, 7)
//					};
//					animals[choice-1] = arTemp[choice-1];
//					break;
//				}
			}
		}
	}
}







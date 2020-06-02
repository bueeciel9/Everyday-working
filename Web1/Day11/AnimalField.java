package animalGame;

import java.util.Random;
import java.util.Scanner;

/*
 * 모여라 셀럽 동물(유아용 게임)
 */
public class AnimalField {
	static String[] questions = {
			"Q.다음 중 나쁜 어린이는?\n"
			+ "1.철수 : 엄마 지갑을 훔쳤어요.\n"
			+ "2.영희 : 할머니 어깨를 주물러 드렸어요.\n"
			+ "3.민수 : 동생 장난감을 고쳐줬어요.\n"
			+ "4.타노스 : 친구에게 책을 빌려줬어요.",
			"Q.영희가 핫도그 3개를 먹었어요.\n철수는 영희가 먹은 핫도그보다\n"
			+ "3개 더 먹었어요. 먹은 핫도그는 몇 개 일까요?\n"
					+ "1.5개\n"
					+ "2.6개\n"
					+ "3.9개\n"
					+ "4.100개",
			};
	static int[] answers = {1, 3};
	
	//이름, 먹이, 몸무게, 먹이개수, 체력
	String name;
	String feed;
	double weight;
	int feed_cnt;
	int hp;
	//기본생성자()
	public AnimalField() {}
	//초기화 생성자(5개)
	public AnimalField(String name, String feed, double weight, int feed_cnt, int hp) {
		this.name = name;
		this.feed = feed;
		this.weight = weight;
		this.feed_cnt = feed_cnt;
		this.hp = hp;
	}
	//먹기()
	//체력 1증가 먹이개수1감소(먹이가 0개면 막아주기)
	//먹을 때마다 몸무게 10kg증가, 100kg이면 하늘나라
	void eat() {
		if(feed_cnt == 0) {
			System.out.println(feed + "이(가) 부족해요T^T\n우리 산책하러 가요.");
		}else {
			feed_cnt--;
			hp++;
			weight += 10;
			System.out.println("냠냠 맛있어^^");
			System.out.println("체력 : " + hp);
			System.out.println("남은 "+ feed + " 개수 : " + feed_cnt);
			System.out.println("몸무게 : " + weight);
		}
	}
	
	//산책하기()
	//체력 1감소
	//랜덤한 문제 출제 후 오답시 체력 1 감소
	//정답시 먹이 개수 2증가
	void walk(){
		if(hp > 1) {
			hp--;
			
			Random r = new Random();
			int idx = r.nextInt(2);
			int choice = 0;
			
			System.out.println(questions[idx]);
			choice = new Scanner(System.in).nextInt();
			
			if(choice == answers[idx]) {
				System.out.println("와우~ 정답이에요!!! 똑똑하네요~");
				feed_cnt+=2;
			}else {
				hp--;
				System.out.println("잘가 다음에 봐~ " + name);
			}
		}else {
			System.out.println("체력이 부족해요~ 잠을 자고 오세요!!");
		}
	}
	
	//잠자기()
	//3초에 체력 1씩 증가
}










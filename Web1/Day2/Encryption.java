package day02;

public class Encryption {
	public static void main(String[] args) {
		//���� pw
		String pw = "a1b2c3";
		//��ȣȭ�� pw
		String en_pw = "";
		//��ȣȭ�� pw
		String de_pw = "";
		
		//KEY��
		int key = 3;
		
		//��ȣȭ
		for (int i = 0; i < pw.length(); i++) {
			//����*���� = ���� (�ڵ� ����ȯ)
			//(char)(����*����) = ���� (���� ����ȯ)
			en_pw += (char)(pw.charAt(i) * key); 
		}
		//��ȣȭ
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / key); 
		}
		
		System.out.printf("���� :  %s\n", pw);
		System.out.printf("��ȣȭ :  %s\n", en_pw);
		System.out.printf("��ȣȭ :  %s\n", de_pw);
	}
}

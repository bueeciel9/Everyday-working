package day17;

public class TV {
	//�ִϸ��̼����� �ƴ��� �˻��ϴ� �޼ҵ� ����
	
	//000�� �ִϸ��̼��Դϴ�.
	//000�� �ִϸ��̼��� �ƴմϴ�.
	void checkAni(Video[] arVideo) {
		for (int i = 0; i < arVideo.length; i++) {
			if(arVideo[i] instanceof AnimationMarker) {
				System.out.println(arVideo[i] + "��(��) �ִϸ��̼��Դϴ�.");
			}else {
				System.out.println(arVideo[i] + "��(��) �ִϸ��̼��� �ƴմϴ�.");
			}
		}
	}
	
	public static void main(String[] args) {
		Video[] arVideo = {new Ddolbi(), new Digimon(), new Frozen(), new Avengers()};
		new TV().checkAni(arVideo);
	}
}






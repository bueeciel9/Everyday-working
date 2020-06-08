package day17;

public class TV {
	//애니메이션인지 아닌지 검사하는 메소드 선언
	
	//000은 애니메이션입니다.
	//000은 애니메이션이 아닙니다.
	void checkAni(Video[] arVideo) {
		for (int i = 0; i < arVideo.length; i++) {
			if(arVideo[i] instanceof AnimationMarker) {
				System.out.println(arVideo[i] + "은(는) 애니메이션입니다.");
			}else {
				System.out.println(arVideo[i] + "은(는) 애니메이션이 아닙니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		Video[] arVideo = {new Ddolbi(), new Digimon(), new Frozen(), new Avengers()};
		new TV().checkAni(arVideo);
	}
}






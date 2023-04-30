package board.dto;

import lombok.Data;

@Data									// 모든 필드이 getter, setter, toString, hashCode, equals 메서드를 생성 
public class BoardDto {					// setter의 경우, final로 선언되지 않은 필드에만 적용
										// https://projectlombok.org/features/
	private int boardIdx;		   
		private String title;
		private String contents;
		private int hitCnt;
		private String createdDt;
		private String createdId;
		private String updatedDt;
		private String updatedId;

}

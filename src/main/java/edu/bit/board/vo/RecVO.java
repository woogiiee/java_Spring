package edu.bit.board.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor//����Ʈ ������
@Getter
@Setter
public class RecVO {
	private double width;
	private double height;
	
	public double getArea() {
		return width*height;
	}
}

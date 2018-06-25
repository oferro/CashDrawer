package com.cookies.ar;

public class Line {

	private String first = null;
	private String second = null;

	// --------------------------------- Constractor 

	Line(String first, String second) {
		super();
		setFirst(first);
		setSecond(second);
	}

	// --------------------------------- Getter and Setter 

	String getFirst() {
		return first;
	}

	void setFirst(String first) {
		this.first = first;
	}

	String getSecond() {
		return second;
	}

	void setSecond(String second) {
		this.second = second;
	}

}

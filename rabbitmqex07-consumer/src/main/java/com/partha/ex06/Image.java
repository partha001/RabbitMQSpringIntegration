package com.partha.ex06;

public class Image {

	private String imageName;
	private String type;
	private Integer size;
	

	public Image() {
		super();
	}

	public Image(String imageName, String type, Integer size) {
		super();
		this.imageName = imageName;
		this.type = type;
		this.size = size;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Image [imageName=" + imageName + ", type=" + type + ", size=" + size + "]";
	}
	
	
	
}

package me.yangjun.modules.frame.xml解析.dom4j;

public class IcbcHostBean {
	private String title;
	private String author;
	private String year;
	private String price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "IcbcHost:[" + "title:" + title + "author:" + author + year + "year:" + price + "price:" + "]";
	}

}

package level5;

import java.io.Serializable;

public class BookDto implements Serializable{

	/** ID */
	private String id;

	/** 書籍名 */
	private String name;

	/** 価格 */
	private int price;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 空のコンストラクタ
	 */
	public BookDto() {
	}

	/**
	 * コンストラクタ
	 * @param id ID
	 * @param name 書籍名
	 * @param price 価格
	 */
	public BookDto(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}



}

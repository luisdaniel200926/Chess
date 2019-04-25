package Game;

public class Player {

	private String name;
	private String color;
	
	
	
	/**
	 * @param name
	 * @param color
	 */
	public Player(String name,String color) {
		setName(name);
		setColor(color);
	}
	
	
	/**
	 * @return the name
	 */
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	/**
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the color
	 */
	/**
	 * @return
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	/**
	 * @param color
	 */
	private void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
}

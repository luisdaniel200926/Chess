package Game;

public interface ILimited {

	
	/**
	 * @param i
	 * @return
	 */
	public boolean boarderLimitationRight( int i);
	
	/**
	 * @param i
	 * @return
	 */
	public boolean boarderLimitationLeft( int i);
	
	/**
	 * @param i
	 * @return
	 */
	public boolean boarderLimitationTop( int i);
	
	/**
	 * @param i
	 * @return
	 */
	public boolean boarderLimitationBottom( int i);
	
}

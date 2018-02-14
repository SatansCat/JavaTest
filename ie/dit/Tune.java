package ie.dit;



public class Tune
{
	private int x;
	private String title;
	private String altTitle;
	private String notation;


	public int getX()
	{
		return x;
	}

	public void setX(int inX)
	{
		x = inX;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String inTitle)
	{
		title = inTitle;
	}

	public String getAltTitle()
	{
		return altTitle;
	}

	public void setAltTitle(String inAltTitle)
	{
		altTitle = inAltTitle;
	}

	public String getNotation()
	{
		return notation;
	}

	public void setNotation(String inNotation)
	{
		notation = inNotation;
	}


	public String toString()
	{
		
		if (altTitle == null)
		{
			return "" + x + ", " + title;
		}
		else
		{
			return "" + x + ", " + title + ", " + altTitle;
		}
	}
}
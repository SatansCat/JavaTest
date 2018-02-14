package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class TuneBook
{
	ArrayList<Tune> tunes = new ArrayList<Tune>();

	TuneBook(String ref)
	{
		BufferedReader inputStream = null;
		try
		{
			inputStream = new BufferedReader(new FileReader(ref));

			String l;
			boolean isATune = false;
			boolean titleFound = false;
			String All = "";
			int x = 0;
			String title = "";
			String altTitle = "";
			while ((l = inputStream.readLine()) != null)
			{
				
				while (!((l = inputStream.readLine()).startsWith("\n")))
				{
					if(l.startsWith("X:"))
					{
						isATune = true;
						
						x = Integer.parseInt(l.substring(3));
					}
					if(l.startsWith("T:"))
					{
						if(titleFound)
						{
							
							altTitle = l.substring(3);
						}
						else
						{
							title = l.substring(3);
							titleFound = true;
						}
					}
					All = All + l;
				}
				if(isATune)
				{
					Tune t = new Tune();
					t.setX(x);
					t.setAltTitle(altTitle);
					t.setTitle(title);
					t.setNotation(All);
					tunes.add(t);
					isATune = false;
				}
				All = "";
				//System.out.println(l);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (inputStream != null)
			{
				try
				{
					inputStream.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for(Tune tune:tunes)
		{
			System.out.println(tune.toString());
			sb.append(tune.toString() + "\n");
		}
		return sb.toString();
	}
}
package Search;
public class Globe
{
 int latitude1;
 int latitude2;
	
	void setValue(int a[])
	{ 
		this.latitude1=a[0];
		this.latitude2=a[1];
	}
	public int returnLatitude1()
	{
		return latitude1;
	}
	public int returnLatitude2()
	{
		return latitude2;
	}

}
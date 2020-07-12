package config;

public class TonKho {
	private String pname;
	private int pqty;
	
	
	public TonKho(String pname, int pqty)
	{
		this.pname = pname;
		this.pqty = pqty;
		
	}
	
	public String getPName()
	{
		return pname;
	}
	
	public void setPName(String pname)
	{
		this.pname = pname;
	}
	
	public int getPQty()
	{
		return pqty;
	}
	


}

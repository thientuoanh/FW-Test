package config;

public class TonKho2 {
	private String pname;
	private int pqty;
	private int pqty2;
	private int pqty3;
	
	public TonKho2(String pname, int pqty, int pqty2, int pqty3)
	{
		this.pname = pname;
		this.pqty = pqty;
		this.pqty2 = pqty2;
		this.pqty3 = pqty3;
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
	
	public int getPQty2()
	{
		return pqty2;
	}
	
	public int getPQty3()
	{
		return pqty3;
	}

}

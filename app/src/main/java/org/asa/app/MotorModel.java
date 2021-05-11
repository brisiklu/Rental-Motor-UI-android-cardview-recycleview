package org.asa.app;
import java.io.Serializable;

public class MotorModel implements Serializable
{
    private String hargaSewaMotor;
    private String namaMotor;
    private String potoMotor;
    private int cardViewMotor;
	public Outlet outletAdapter;

    public MotorModel(String namaMotor, String hargaMotor , String potoMotor , int cardViewMotor)
    {
        this.namaMotor = namaMotor;
        this.hargaSewaMotor= hargaMotor;
        this.cardViewMotor=cardViewMotor;
        this.potoMotor = potoMotor;
    }
    
    public MotorModel(){
        
    }

	public void setOutletAdapter(Outlet outletAdapter)
	{
		this.outletAdapter = outletAdapter;
	}

	public Outlet getOutletAdapter()
	{
		return outletAdapter;
	}

    public void setCardViewMotor(int cardViewMotor)
    {
        this.cardViewMotor = cardViewMotor;
    }

    public int getCardViewMotor()
    {
        return cardViewMotor;
    }
    

    public void setHargaSewaMotor(String hargaMotor)
    {
        this.hargaSewaMotor = hargaMotor;
    }

    public String getHargaSewaMotor()
    {
        return hargaSewaMotor;
    }

    public void setPotoMotor(String potoMotor)
    {
        this.potoMotor = potoMotor;
    }

    public String getPotoMotor()
    {
        return potoMotor;
    }

;


    public void setNamaMotor(String namaMotor)
    {
        this.namaMotor = namaMotor;
    }

    public String getNamaMotor()
    {
        return namaMotor;
    }}

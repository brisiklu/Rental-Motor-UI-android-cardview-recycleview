package org.asa.app;
import java.io.Serializable;

public class MotorModel implements Serializable
{
    private String hargaSewaMotor;
    private String namaMotor;
    private int potoMotor;
    private int cardViewMotor;

    public MotorModel(String namaMotor, String hargaMotor , int potoMotor , int cardViewMotor)
    {
        this.namaMotor = namaMotor;
        this.hargaSewaMotor= hargaMotor;
        this.cardViewMotor=cardViewMotor;
        this.potoMotor = potoMotor;
    }
    
    public MotorModel(){
        
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

    public void setPotoMotor(int potoMotor)
    {
        this.potoMotor = potoMotor;
    }

    public int getPotoMotor()
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

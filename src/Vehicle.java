abstract class Vehicle{   
	//instance variables declared
    private String iDPlate;
    private String brand;
    private double entryTime;
    private int Date;
    private int slotNo;
    
    //getters and setters are set
	public String getiDPlate() {
		return iDPlate;
	}
	public void setiDPlate(String iDPlate) {
		this.iDPlate = iDPlate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(double entryTime) {
		this.entryTime = entryTime;
	}
	public int getDate() {
		return Date;
	}
	public void setDate(int date) {
		Date = date;
	}
    public int getslotNo() {
		return slotNo;
	}
	public void setslotNo(int slotNo) {
		this.slotNo = slotNo;
	}
}

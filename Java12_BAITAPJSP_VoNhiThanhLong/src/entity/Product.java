package entity;

public class Product {
	private String tenSanPham;
	private int soLuong;
	private float giaBan;
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public Product(String tenSanPham, int soLuong, float giaBan) {
		
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}
	
	
}

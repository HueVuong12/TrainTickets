package entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

public class HoaDon {
	private String maHoaDon;
	private LocalDateTime ngayLapHoaDon;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ChiTietHoaDon chiTiet;
	private Boolean daHoanVe ;
	private Boolean daHoanTien;

	public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, NhanVien nhanVien, KhachHang khachHang,
			ChiTietHoaDon chiTiet, Boolean daHoanVe, Boolean daHoanTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTiet = chiTiet;
		this.daHoanVe = daHoanVe;
		this.daHoanTien = daHoanTien;
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		String ktMaHoaDon = "^\\d{2}\\d{2}\\d{2}NV\\d{3}\\d{5}$";
		if (ktMaHoaDon.matches(ktMaHoaDon))
			this.maHoaDon = maHoaDon;
		else
			throw new IllegalArgumentException("Mã hóa đơn không hợp lệ!");
	}

	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		if (ngayLapHoaDon.toLocalDate().isEqual(LocalDate.now()))
			this.ngayLapHoaDon = ngayLapHoaDon;
		else
			throw new IllegalArgumentException("Ngày lập hóa đơn phải là ngày hiện tại!");
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		//Kiểm tra tồn tại
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		//Kiểm tra tồn tại
	}

	public ChiTietHoaDon getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(ChiTietHoaDon chiTiet) {
		this.chiTiet = chiTiet;
		//Kiểm tra tồn tại
	}

	public Boolean getDaHoanVe() {
		return daHoanVe;
	}

	public void setDaHoanVe(Boolean daHoanVe) {
		this.daHoanVe = daHoanVe;
	}

	public Boolean getDaHoanTien() {
		return daHoanTien;
	}

	public void setDaHoanTien(Boolean daHoanTien) {
		this.daHoanTien = daHoanTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", chiTiet=" + chiTiet + ", daHoanVe=" + daHoanVe + ", daHoanTien="
				+ daHoanTien + "]";
	}

	public float tongTien() {
		return this.chiTiet.tinhTien();
	}
	
	public float tinhTienHoan() {
		int size = this.chiTiet.getDsVe().size();
		long thoiGian = Duration.between(chiTiet.getDsVe().get(0).getGioDi(), LocalTime.now()).toHours();
		if (size == 1) {
			if (thoiGian >= 24)
				return chiTiet.tinhTien()*0.9f;
			else if (thoiGian >= 4)
				return chiTiet.tinhTien()*0.8f;
		} else {
			if (thoiGian >= 72)
				return chiTiet.tinhTien()*0.9f;
			else if (thoiGian >= 24)
				return chiTiet.tinhTien()*0.8f; 
		}
		return 0;
	}
	
	public void xuatHoaDon(String pdfPath) {
    	try {

            // Tạo file PDF
            PdfWriter writer = new PdfWriter(new FileOutputStream(pdfPath));
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            
            // Thêm hình ảnh vào đầu tài liệu
            String imagePath = getClass().getResource("/img/LogoDepHonDen.png").getPath(); // Đường dẫn đến hình ảnh
            Image img = new Image(ImageDataFactory.create(imagePath));
            img.setWidth(120); // Đặt chiều rộng cho hình ảnh

            // Tạo bảng tiêu đề chiếm toàn bộ chiều rộng của trang
            Table headerTable = new Table(3);
            headerTable.setWidth(500); // Chiều rộng cụ thể của bảng tiêu đề

            // Thêm các ô vào bảng mà không có border
            headerTable.addCell(new Cell(2,1).add(img)
                    .setBorder(Border.NO_BORDER));  // Tắt border cho ô tiêu đề
            headerTable.addCell(new Cell().add(new Paragraph("HÓA ĐƠN")
                    .setBold().setFontSize(18).setTextAlignment(TextAlignment.CENTER))
                    .setBorder(Border.NO_BORDER));  // Tắt border cho ô tiêu đề
            headerTable.addCell(new Cell().add(new Paragraph("Ma Hoa Don: 000001")
                    .setTextAlignment(TextAlignment.RIGHT))
                    .setBorder(Border.NO_BORDER));  // Tắt border cho ô số hóa đơn
            headerTable.addCell(new Cell(1,3).add(new Paragraph("Ngay xx, thang xx, nam 20xx")
            		.setTextAlignment(TextAlignment.LEFT))
            		.setBorder(Border.NO_BORDER));  // Tắt border cho ô số hóa đơn

            // Thêm bảng vào tài liệu
            document.add(headerTable);
         
            // Thêm thông tin khách hàng và địa chỉ
            UnitValue[] columnWidths1 = {
                    UnitValue.createPercentValue(20), // Cột 1 chiếm 20% chiều rộng
                    UnitValue.createPercentValue(30), // Cột 2 chiếm 50% chiều rộng
                    UnitValue.createPercentValue(20),  // Cột 3 chiếm 30% chiều rộng
                    UnitValue.createPercentValue(30)  // Cột 4 chiếm 30% chiều rộng
                };
                
            // Tạo bảng với mảng độ rộng cột
            Table tableKH = new Table(columnWidths1);
            tableKH.setWidth(500);
            tableKH.addCell(new Cell().add(new Paragraph("Don vi ban ve: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Nhà ga ĐTHP")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Dien thoai: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("0123456789")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Ma nhan vien: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell(1,3).add(new Paragraph("NV001")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Ma khach hang: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("KH0001")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Ten khach hang: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("Le Tan Phong")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell().add(new Paragraph("SDT khach hang: ")).setBorder(Border.NO_BORDER));
            tableKH.addCell(new Cell(1,3).add(new Paragraph("0919128639")).setBorder(Border.NO_BORDER));
            
            document.add(tableKH);

            // Tạo bảng cho các mục trong hóa đơn
            UnitValue[] columnWidths2 = {
                    UnitValue.createPercentValue(5),
                    UnitValue.createPercentValue(10),
                    UnitValue.createPercentValue(30),
                    UnitValue.createPercentValue(5),
                    UnitValue.createPercentValue(10),
                    UnitValue.createPercentValue(10),
                    UnitValue.createPercentValue(10),
                    UnitValue.createPercentValue(10),
                    UnitValue.createPercentValue(10)
                };
            Table table = new Table(columnWidths2);
            table.setWidth(500);
            
            // Tiêu đề
            table.addCell(new Cell().add(new Paragraph("STT").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Ma ve").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Ten dich vu").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("So luong").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Don gia").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Thanh tien chua thue").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Thue suat").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Thue GTGT").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("Thanh tien co thue").setTextAlignment(TextAlignment.CENTER)));

            // Cách tính
            table.addCell(new Cell().add(new Paragraph("a").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("b").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("c").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("d").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("e").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("f=d*e").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("g").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("h=f*g").setTextAlignment(TextAlignment.CENTER)));
            table.addCell(new Cell().add(new Paragraph("i=f+h").setTextAlignment(TextAlignment.CENTER)));
            
            // Thêm các dòng trong bảng
            int tongcothue = 0;
            int tongkhongthue = 0;
            int tongthue = 0;
            for (int i = 1; i <= 4; i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(i))));
                table.addCell(new Cell().add(new Paragraph("VE00" + i)));
                table.addCell(new Cell().add(new Paragraph("Ten san pham " + i)));
                table.addCell(new Cell().add(new Paragraph(i+"")));
                table.addCell(new Cell().add(new Paragraph(i+"000")));
                table.addCell(new Cell().add(new Paragraph(i*i+"000")));
                table.addCell(new Cell().add(new Paragraph("10%")));
                table.addCell(new Cell().add(new Paragraph(i*i+"00")));
                table.addCell(new Cell().add(new Paragraph((i*i*1100)+"")));
                tongcothue += i*i*1100;
                tongkhongthue += i*i*1000;
                tongthue += i*i*100;
            }

            // Thêm tổng cộng
            table.addCell(new Cell(1, 5).add(new Paragraph("Tong cong:")));
            table.addCell(new Cell().add(new Paragraph(tongkhongthue+"")));
            table.addCell(new Cell().add(new Paragraph("")));
            table.addCell(new Cell().add(new Paragraph(tongthue+"")));
            table.addCell(new Cell().add(new Paragraph(tongcothue+"")));
            table.addCell(new Cell(1,9).add(new Paragraph("Cong thanh tien (Viet bang chu): ba muoi ba nghin dong")));
            
            document.add(table);

            document.add(new Paragraph("\nGhi chu:........................................................................................................................................."));
            
            // Thêm phần ký tên
            Table tableKyTen = new Table(2);
            tableKyTen.setWidth(500);
            tableKyTen.addCell(new Cell().add(new Paragraph("Khach hang")
                    .setBold().setTextAlignment(TextAlignment.CENTER))
                    .setBorder(Border.NO_BORDER));
            tableKyTen.addCell(new Cell().add(new Paragraph("Nguoi ban hang")
            		.setBold().setTextAlignment(TextAlignment.CENTER))
            		.setBorder(Border.NO_BORDER));
            tableKyTen.addCell(new Cell().add(new Paragraph("(Ky, ghi ro ho ten)")
            		.setItalic().setTextAlignment(TextAlignment.CENTER))
            		.setBorder(Border.NO_BORDER));
            tableKyTen.addCell(new Cell().add(new Paragraph("(Ky, ghi ro ho ten)")
            		.setItalic().setTextAlignment(TextAlignment.CENTER))
            		.setBorder(Border.NO_BORDER));
            
            document.add(tableKyTen);
            
            document.add(new Paragraph("\n\n\n\n\n"));
            
            document.add(new Paragraph("*Kiem tra doi chieu ky truoc khi nhan hoa don")
            		.setItalic().setFontSize(10).setTextAlignment(TextAlignment.LEFT));
            
            // Đóng tài liệu PDF
            document.close();
            System.out.println("Đã tạo hóa đơn và lưu vào file PDF: " + pdfPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}

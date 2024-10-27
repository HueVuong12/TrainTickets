-- Tạo database DTHP
CREATE DATABASE DTHP
COLLATE Vietnamese_CI_AS;
GO

-- Sử dụng database DTHP
USE DTHP;
GO

-- Tạo bảng Ga
CREATE TABLE Ga (
    maGa VARCHAR(50) PRIMARY KEY,
    tenGa NVARCHAR(100) NOT NULL,
    diaChi NVARCHAR(200) NOT NULL,
    chiSoKm INT NOT NULL,
    trangThai BIT NOT NULL
);

-- Tạo bảng ChuyenTau
CREATE TABLE ChuyenTau (
    maTau VARCHAR(50) PRIMARY KEY,
	gaDi VARCHAR(50) NOT NULL,
    gaDen VARCHAR(50) NOT NULL,
    ngayDi DATE NOT NULL,
    gioDi TIME NOT NULL,
    FOREIGN KEY (gaDen) REFERENCES Ga(maGa)
);

-- Bảng trung gian giữa Ga và ChuyenTau (n-n)
CREATE TABLE ChuyenTau_Ga (
    maTau VARCHAR(50),
    maGa VARCHAR(50),
    PRIMARY KEY (maTau, maGa),
    FOREIGN KEY (maTau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (maGa) REFERENCES Ga(maGa)
);

CREATE TABLE Toa (
    maToa VARCHAR(50) PRIMARY KEY,
    loaiToa NVARCHAR(50) NOT NULL,
    maTau VARCHAR(50) NOT NULL,
    FOREIGN KEY (maTau) REFERENCES ChuyenTau(maTau)
);

-- Tạo bảng Ghe
CREATE TABLE Ghe (
    soGhe INT NOT NULL,
    maToa VARCHAR(50) NOT NULL,
    trangThai BIT NOT NULL,
    PRIMARY KEY (soGhe, maToa),
    FOREIGN KEY (maToa) REFERENCES Toa(maToa)
);

-- Tạo bảng Ca
CREATE TABLE Ca (
    maCa VARCHAR(50) PRIMARY KEY,
    tenCa NVARCHAR(100) NOT NULL,
    thoiGianBatDau TIME NOT NULL,
    thoiGianKetThuc TIME NOT NULL
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    maNV VARCHAR(50) PRIMARY KEY,
    tenNV NVARCHAR(100) NOT NULL,
    ngaySinh DATE,
    gioiTinh BIT,
	ca VARCHAR(50) NOT NULL,
	cccd VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(20),
    trangThai BIT,
    chucVu INT NOT NULL,
	FOREIGN KEY (ca) REFERENCES Ca(maCa)
);

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKH VARCHAR(50) PRIMARY KEY,
    tenKH NVARCHAR(100) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(20) NOT NULL,
    cccd VARCHAR(20)
);

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    maHoaDon VARCHAR(50) PRIMARY KEY,
    ngayLapHoaDon DATETIME NOT NULL,
    nhanVien VARCHAR(50) NOT NULL,
    khachHang VARCHAR(50) NOT NULL,
    daHoanVe BIT NOT NULL,
	daHoanTien BIT NOT NULL,
    FOREIGN KEY (nhanVien) REFERENCES NhanVien(maNV),
    FOREIGN KEY (khachHang) REFERENCES KhachHang(maKH)
);

-- Tạo bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon (
    maChiTiet VARCHAR(50) PRIMARY KEY,
    hoaDon VARCHAR(50) NOT NULL,
    soLuong INT NOT NULL,
    thue FLOAT,
    FOREIGN KEY (hoaDon) REFERENCES HoaDon(maHoaDon)
);

-- Tạo bảng Ve
CREATE TABLE Ve (
    maVe VARCHAR(50) PRIMARY KEY,
    tau VARCHAR(50) NOT NULL,
    toa VARCHAR(50) NOT NULL,
    soGhe INT NOT NULL,
    khachHang VARCHAR(50) NOT NULL,
    ngayDi DATE NOT NULL,
    gioDi TIME NOT NULL,
	gaDi VARCHAR(50) NOT NULL,
    gaDen VARCHAR(50) NOT NULL,
	hang VARCHAR(100) NOT NULL,
	khuyenMai VARCHAR(100) NOT NULL,
    trangThai BIT,
	chiTiet VARCHAR(50) NOT NULL,
    FOREIGN KEY (tau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (toa) REFERENCES Toa(maToa),
    FOREIGN KEY (soGhe, toa) REFERENCES Ghe(soGhe, maToa),
    FOREIGN KEY (khachHang) REFERENCES KhachHang(maKH),
    FOREIGN KEY (gaDen) REFERENCES Ga(maGa),
	FOREIGN KEY (chiTiet) REFERENCES ChiTietHoaDon(maChiTiet)
);

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
    maTaiKhoan VARCHAR(50) PRIMARY KEY,
    matKhau VARCHAR(50) NOT NULL,
    phanQuyen INT NOT NULL,
    nhanVien VARCHAR(50),
    FOREIGN KEY (nhanVien) REFERENCES NhanVien(maNV)
);

-- Thêm 3 ca vào bảng Ca
INSERT INTO Ca (maCa, tenCa, thoiGianBatDau, thoiGianKetThuc) VALUES
('CA01', N'Ca 1', '06:00:00', '13:59:00'),
('CA02', N'Ca 2', '14:00:00', '21:59:00'),
('CA03', N'Ca 3', '22:00:00', '05:59:00');

-- Thêm 3 nhân viên vào bảng NhanVien
INSERT INTO NhanVien (maNV, tenNV, ngaySinh, gioiTinh, ca, cccd, email, sdt, trangThai, chucVu) VALUES
('NV001', N'Lê Tấn Phong', '2004-03-30', 0, 'CA01', '049204013502', 'letanphong400@gmail.com', '0919128639', 1, 1),
('NV002', N'Vương Ngọc Huệ', '2003-08-12', 1, 'CA02', '049203000000', 'ngochue12@gmail.com', '0987654321', 0, 2);

-- Thêm 2 tài khoản vào bảng TaiKhoan
INSERT INTO TaiKhoan (maTaiKhoan, matKhau, phanQuyen, nhanVien) VALUES
('TKQL001', 'password1', 1, 'NV001'), 
('TKNV001', 'password2', 2, 'NV002');

-- Thêm 35 ga vào bảng Ga
INSERT INTO Ga (maGa, tenGa, diaChi, chiSoKm, trangThai) VALUES
('GA001', N'Ga Sài Gòn', N'Sài Gòn', 0, 1),
('GA002', N'Ga Dĩ An', N'Dĩ An', 19, 1),
('GA003', N'Ga Biên Hòa', N'Biên Hòa', 29, 1),
('GA004', N'Ga Long Khánh', N'Long Khánh', 77, 1),
('GA005', N'Ga Suối Kiết', N'Suối Kiết', 123, 1),
('GA006', N'Ga Bình Thuận', N'Bình Thuận', 175, 1),
('GA007', N'Ga Sông Mao', N'Sông Mao', 218, 1),
('GA008', N'Ga Tháp Chàm', N'Tháp Chàm', 318, 1),
('GA009', N'Ga Nha Trang', N'Nha Trang', 411, 1),
('GA010', N'Ga Ninh Hòa', N'Ninh Hòa', 445, 1),
('GA011', N'Ga Tuy Hòa', N'Tuy Hòa', 528, 1),
('GA012', N'Ga Diêu Trì', N'Diêu Trì', 630, 1),
('GA013', N'Ga Bồng Sơn', N'Bồng Sơn', 709, 1),
('GA014', N'Ga Đức Phổ', N'Đức Phổ', 758, 1),
('GA015', N'Ga Quảng Ngãi', N'Quảng Ngãi', 798, 1),
('GA016', N'Ga Núi Thành', N'Núi Thành', 836, 1),
('GA017', N'Ga Tam Kỳ', N'Tam Kỳ', 861, 1),
('GA018', N'Ga Trà Kiệu', N'Trà Kiệu', 888, 1),
('GA019', N'Ga Đà Nẵng', N'Đà Nẵng', 935, 1),
('GA020', N'Ga Huế', N'Huế', 1038, 1),
('GA021', N'Ga Đông Hà', N'Đông Hà', 1104, 1),
('GA022', N'Ga Mỹ Trạch', N'Mỹ Trạch', 1161, 1),
('GA023', N'Ga Đồng Hới', N'Đồng Hới', 1202, 1),
('GA024', N'Ga Đồng Lê', N'Đồng Lê', 1290, 1),
('GA025', N'Ga Hương Phố', N'Hương Phố', 1339, 1),
('GA026', N'Ga Yên Trung', N'Yên Trung', 1386, 1),
('GA027', N'Ga Vinh', N'Vinh', 1407, 1),
('GA028', N'Ga Chợ Sy', N'Chợ Sy', 1447, 1),
('GA029', N'Ga Minh Khôi', N'Minh Khôi', 1529, 1),
('GA030', N'Ga Thanh Hóa', N'Thanh Hóa', 1551, 1),
('GA031', N'Ga Bỉm Sơn', N'Bỉm Sơn', 1585, 1),
('GA032', N'Ga Ninh Bình', N'Ninh Bình', 1611, 1),
('GA033', N'Ga Nam Định', N'Nam Định', 1639, 1),
('GA034', N'Ga Phủ Lý', N'Phủ Lý', 1670, 1),
('GA035', N'Ga Hà Nội', N'Hà Nội', 1726, 1);

-- Thêm 3 chuyến tàu
INSERT INTO ChuyenTau (maTau, gaDi, gaDen, ngayDi, gioDi) VALUES
('TA001', 'GA001', 'GA035', '2024-10-21', '08:00:00'),
('TA002', 'GA001', 'GA035', '2024-10-22', '09:00:00'),
('TA003', 'GA001', 'GA035', '2024-10-23', '10:00:00');

-- Thêm các trạm dừng cho 3 chuyến tàu
INSERT INTO ChuyenTau_Ga (maTau, maGa) VALUES
('TA001', 'GA016'), -- Núi Thành
('TA001', 'GA020'), -- Huế
('TA002', 'GA016'), -- Núi Thành
('TA002', 'GA020'), -- Huế
('TA003', 'GA016'), -- Núi Thành
('TA003', 'GA020'); -- Huế

-- Thêm các toa cho mỗi chuyến tàu
-- Chuyến tàu TA001
INSERT INTO Toa (maToa, loaiToa, maTau) VALUES
('TA001_01', N'Giường nằm', 'TA001'),
('TA001_02', N'Giường nằm', 'TA001'),
('TA001_03', N'Ghế mềm', 'TA001'),
('TA001_04', N'Ghế mềm', 'TA001'),
('TA001_05', N'VIP', 'TA001');

-- Chuyến tàu TA002
INSERT INTO Toa (maToa, loaiToa, maTau) VALUES
('TA002_01', N'Giường nằm', 'TA002'),
('TA002_02', N'Giường nằm', 'TA002'),
('TA002_03', N'Ghế mềm', 'TA002'),
('TA002_04', N'Ghế mềm', 'TA002'),
('TA002_05', N'VIP', 'TA002');

-- Chuyến tàu TA003
INSERT INTO Toa (maToa, loaiToa, maTau) VALUES
('TA003_01', N'Giường nằm', 'TA003'),
('TA003_02', N'Giường nằm', 'TA003'),
('TA003_03', N'Ghế mềm', 'TA003'),
('TA003_04', N'Ghế mềm', 'TA003'),
('TA003_05', N'VIP', 'TA003');

-- Thêm các ghế cho mỗi toa tàu
-- Toa Giường nằm có 32 ghế, Ghế mềm có 64 ghế, toa VIP có 20 ghế
-- Thêm ghế cho TA001
DECLARE @i INT;
SET @i = 1;
WHILE @i <= 32 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA001_01', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA001_02', 1);
    SET @i = @i + 1;
END;

SET @i = 1;
WHILE @i <= 64 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA001_03', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA001_04', 1);
    SET @i = @i + 1;
END;

SET @i = 1;
WHILE @i <= 20 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA001_05', 1);
    SET @i = @i + 1;
END;

-- Tương tự cho TA002 và TA003
-- Toa Giường nằm cho TA002 và TA003
SET @i = 1;
WHILE @i <= 32 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA002_01', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA002_02', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA003_01', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA003_02', 1);
    SET @i = @i + 1;
END;

-- Toa Ghế mềm cho TA002 và TA003
SET @i = 1;
WHILE @i <= 64 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA002_03', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA002_04', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA003_03', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA003_04', 1);
    SET @i = @i + 1;
END;

-- Toa VIP cho TA002 và TA003
SET @i = 1;
WHILE @i <= 20 BEGIN
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA002_05', 1);
    INSERT INTO Ghe (soGhe, maToa, trangThai) VALUES (@i, 'TA003_05', 1);
    SET @i = @i + 1;
END;

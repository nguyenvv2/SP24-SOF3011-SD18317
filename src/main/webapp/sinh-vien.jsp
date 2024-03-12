<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 09/03/2024
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<h1>Day la trang sinh vien</h1>
<h1>Ma sinh vien: ${sinhVien.getMaSinhVien()}</h1>
<h1>Ho ten sinh vien: ${sinhVien.getTenSinhVien()}</h1>
<h1>Dia chi sinh vien: ${sinhVien.diaChi}</h1>


<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>Ma Sinh Vien</td>
        <td>Ten Sinh Vien</td>
        <td>Dia Chi</td>
        <td>Tuoi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sinhVien" items="${list}" varStatus="i">
        <tr>
            <td>${i.index +1 }</td>
            <td>${sinhVien.maSinhVien}</td>
            <td>${sinhVien.tenSinhVien}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.tuoi}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

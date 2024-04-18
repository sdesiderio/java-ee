<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.sistemi.informativi.dto.StudentDTO" %>
<html>
<head>
<meta charset="UTF-8">
<title>Success Registration</title>
</head>
<% 
StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO"); %>
<body>
<%= "Welcome " + studentDTO.getLastName() %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>님은 권한 없어요</h3>
<h2>${SPRING_SECURITY_403_EXCEPTION.getMessage()}</h2>
<h2>${msg}</h2>
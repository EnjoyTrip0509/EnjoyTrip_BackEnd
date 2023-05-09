<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/common/header.jsp" %>
<%@ include file="/common/nav.jsp" %>
<c:set var="cnt" value="0"/>
<h1 class = "d-flex flex-row justify-content-center mt-3 ">전체 회원 목록</h1>
<hr>
<div class = "container mt-3">
<c:forEach var = "user" items = "${users}">
<c:if test="${cnt%3 eq 0}"><hr class = "border border-4 border-dark"></c:if>
<div class = "border border-3 bg-light mt-2 mb-2 " style = "margin-left: 70px; display:inline-block; height: 180px; width: 300px;">
<div>&nbsp;회원 유형 : 
<c:if test ="${user.isAdmin eq true}">관리자&nbsp;</c:if>
<c:if test ="${user.isAdmin eq false}">일반 회원&nbsp;</c:if>
</div>
<div>&nbsp;회원 이름 : ${user.name}&nbsp;</div>
<div>&nbsp;회원 아이디 : ${user.id}&nbsp;</div>
<div>&nbsp;회원 비밀번호 : ${user.password}&nbsp;</div>
<div>&nbsp;회원 이메일 : ${user.email}&nbsp;</div>
</div>
<c:set var="cnt" value="${cnt + 1}"/>
</c:forEach>
</div> 
<%@ include file="/common/footer.jsp" %>
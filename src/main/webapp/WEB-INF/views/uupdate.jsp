<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glyphicon-edit"></span>유저 수정</label>
    </div>

    <div class="col-xs-12">
        <form action="/userupdateProc" method="post">
          <div class="form-group">
            <label for="upw">password</label>
            <input type="text" class="form-control" id="upw" name="upw" value="${udetail.upw}">
          </div>
          <div class="form-group">
            <label for="email">이메일</label>
            <input type="text" class="form-control" id="email" name="email" value="${udetail.email}">
          </div>
          <div class="form-group">
            <label for="googleid">구글 ID</label>
            <input type="text" class="form-control" id="googleid" name="googleid" value="${udetail.googleid}">
          </div>
          <div class="form-group">
            <label for="naverid">네이버 ID</label>
            <input type="text" class="form-control" id="naverid" name="naverid" value="${udetail.naverid}">
          </div>
          <div class="form-group">
            <label for="nickname">닉네임</label>
            <input type="text" class="form-control" id="nickname" name="nickname" value="${udetail.nickname}">
          </div>

          <input type="hidden" id="uid" name="uid" value="${udetail.uid}"/>
          <button type="submit" class="btn btn-primary btn-sm" style="float:right;">수정</button>
        </form>
    </div>
</div>

</body>
</html>
</layoutTag:layout>
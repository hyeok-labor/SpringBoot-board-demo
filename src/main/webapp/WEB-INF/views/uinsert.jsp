<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Create Form</title>
</head>
<body>


<div class="container">
    <div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glyphicon-edit"></span>유저 생성</label>
    </div>

    <div class="col-xs-12">
        <form action="/uinsertProc" method="post" enctype="multipart/form-data"> <!-- 추가 -->
          <div class="form-group">
            <label for="uid">ID</label>
            <input type="text" class="form-control" id="uid" name="uid" placeholder="ID를 입력하세요.">
          </div>
          <div class="form-group">
            <label for="upw">password</label>
            <input type="text" class="form-control" id="upw" name="upw" placeholder="비밀번호를 입력하세요.">
          </div>
          <div class="form-group">
            <label for="uname">이름</label>
            <input type="text" class="form-control" id="uname" name="uname" placeholder="이름을 입력하세요.">
          </div>
          <div class="form-group">
            <label for="Email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="이메일을 입력하세요.">
          </div>
          <div class="form-group">
            <label for="googleid">google ID</label>
            <input type="text" class="form-control" id="googleid" name="googleid" placeholder="구글 아이디를 입력하세요.">
          </div>
          <div class="form-group">
            <label for="naverid">naver ID</label>
            <input type="text" class="form-control" id="naverid" name="naverid" placeholder="네이버 아이디를 입력하세요.">
          </div>
          <div class="form-group">
            <label for="nickname">닉네임</label>
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="사용할 닉네임을 입력하세요.">
          </div>

          <button type="submit" class="btn btn-primary btn-sm" style="float:right;">등록</button>

        </form>
    </div>
</div>


</body>
</html>
</layoutTag:layout>
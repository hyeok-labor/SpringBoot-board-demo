<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>

<div class="container">
    <div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>유저 상세</label>
    </div>

    <div class="col-xs-12">
        <form action="/uinsertProc" method="post">
            <dl class="dl-horizontal">
              <dt>ID</dt>
              <dd>${udetail.uid}</dd>

              <dt>password</dt>
              <dd>${udetail.upw}</dd>

              <dt>이름</dt>
              <dd>${udetail.uname}</dd>

              <dt>이메일</dt>
              <dd>${udetail.email}</dd>

              <dt>구글ID</dt>
              <dd>${udetail.googleid}</dd>

              <dt>네이버ID</dt>
              <dd>${udetail.naverid}</dd>

              <dt>닉네임</dt>
              <dd>${udetail.nickname}</dd>
            </dl>
        </form>
        <div class="btn-group btn-group-sm" role="group" style="float:right;">
          <button type="button" class="btn btn-default" onclick="location.href='/udelete/${udetail.uid}'">삭제</button>
          <button type="button" class="btn btn-default" onclick="location.href='/uupdate/${udetail.uid}'">수정</button>
          <button type="button" class="btn btn-default" onclick="location.href='/ulist'"> 유저목록 </button>
        </div>
    </div>
</div>
</layoutTag:layout>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>글수정 화면</title>

<link rel="stylesheet" type="text/css"
	href="/resources/include/dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/include/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {

		/* 수정 버튼 클릭 시 처리 이벤트 */
		$("#inquiryUpdateBtn").click(function() {
			//입력값 체크
			if (!chkSubmit($('#q_title'), "제목을"))
				return;
			else if (!chkSubmit($('#q_content'), "작성할 내용을"))
				return;
			else {
				
				$("#q_writeForm").attr({
					"method" : "POST",
					"action" : "/inquiry/inquiryUpdate"
				});
				$("#q_writeForm").submit();
			}
		});

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#inquiryListBtn").click(function() {
			location.href = "/inquiry/inquiryList";
		});
	});
</script>
</head>
<body>
	<div class="contentContainer">
		<div class="contentTit">
			<h3>문의게시판 글수정</h3>
		</div>

		<div class="contentTB">
			<form id="q_writeForm" name="q_writeForm" method="post">
				<input type="hidden" id="q_no" name="q_no" value="${updateData.q_no}" /> 
				<table>
					<colgroup>
						<col width="17%" />
						<col width="33%" />
						<col width="17%" />
						<col width="33%" />
					</colgroup>
					<tbody>
						<tr>
							<td class="ac">글번호</td>
							<td>${updateData.q_no}</td>
							<td class="ac">작성일</td>
							<td>${updateData.q_regdate}</td>
						</tr>
						<tr>
							<td class="ac">작성자</td>
							<td colspan="3">${updateData.m_id}</td>
						</tr>
						<tr>
							<td class="ac">글제목</td>
							<td colspan="3">
								<input type="text" name="q_title" id="q_title" value="${updateData.q_title}" /></td>
						</tr>
						<tr>
							<td class="ac vm">내용</td>
							<td colspan="3"><textarea name="q_content" id="q_content">${updateData.q_content}</textarea></td>
						</tr>
				</table>
			</form>
		</div>

		<div class="contentBtn">
			<input type="button" value="수정" id="inquiryUpdateBtn"> <input
				type="button" value="목록" id="inquiryListBtn">
		</div>
	</div>
</body>
</html>
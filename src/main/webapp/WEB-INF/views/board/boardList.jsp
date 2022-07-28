<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardList</title>
</head>
<script type="text/javascript">

	$j(document).ready(function() {
		
		// 체크박스 전체 체크, 해제( 나머지 체크하면 전체가 해제된다.)
		$j('#allCheck').click(function() {
			if($j('#allCheck').prop('checked')) {
				$j('input[type='checkbox']').prop('checked', true);
			} else {
				$j('input[type='checkbox']').prop('checked', false);
			}
		});
		
		// 전체 제외, 나머지 checkbox
		$j('.searchKey').on('click', function() {
			if($j('.searchKey:checked').length == 4) {
				$j('#allCheck').prop('checked', true);
			} else {
				$j('#allCheck').prop('checked', false);
			}
		});
		
		$j('#search').click(function() {
			
			var arr = [];
			
			$j('.searchKey:checked').each(function(i) {
				arr.push($j(this).val());
			});
			console.log( "test", {
				searchKey : arr,
				pageNo ; 1
			});
			
			$j.ajax({
				url : "/board/boardList.do",
				traditional : true,
				type : "get",
				data : {
					searchKey : arr,
					pageNo ; 1
				},
				success : function( data, textStatus, jqXHR )
				{
					$j('#boardTable').empty();
					
					var html = $j('<div>').html(data);
					var contents = html.find('#boardSearch').html();
					$j('#boardTable').html(contents);
				},
				error : function( jqXHR, textStatus, errorThrown)
				{
				 alert("게시글 조회 에러 발생");	
				}
			});
		});
	});
</script>
<body>
	<table align="center" id="boardTable">
	<tr>
		<td>
		</td>
	</tr>
	<tr>
		<td align="right" id="totalCnt">
			total : ${totalCnt}
		</td>
	</tr>
	<tr>
		<td>
			<table border="1">
				<tr>
					<td width="80" align="center">
						Type
					</td>
					<td width="40" align="center">
						No
					</td>
					<td width="300" align="center">
						Title
					</td>
				</tr>
				<c:forEach items="${boardList}" var="list">
					<tr>
						<td>
							${list.boardTypeNm}
						</td>
						<td>
							${list.boardNum}
						</td>
						<td>
							<a href="/board/${list.boardType}/${list.boardNum}/boardView.do?pangeNo=${pageNo}">${list.boardTitle}</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
	</table>
	<div style="display: table; margin-left: auto; margin-right: auto;">
		<div align="left">
			<input type="checkbox" name="TypeCheck" value="all" id="allCheck"/>전체
			<c:forEach items="${codeList}" var="code" varStatus="status">
				<input class="searchKey" type="checkbox" value="${code.codeId}" name="searchKey"/>${code.codeName}
			</c:forEach>
			<input type="button" id="search" value="조회" />
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardView</title>
<script type="text/javascript">

	$j(document).ready(function() {
		
		function deleteAjax() {
			var param = {
					boardNum = '${board.boardNum}',
					boardType = '${board.boardType}'
			}
			
			$j.ajax({
				url : "/board/boardDeleteAction.do",
				dataType : "json",
				Type : "POST",
				data : param,
				success : function( data, textStatus, jqXHR)
				{
					alert( "삭제완료" );
					location.href = "/board/boardList.do?pageNo=1";
				},
				error : function( jqXHR, textStatus, errorThrown) 
				{
					alert( "실패" );	
				}
			})
		}
	});
</script>
</head>
<body>
<table align="center">
	<tr>
		<td>
			<table border ="1">
				<tr>
					<td width="120" align="center">
						Title
					</td>
					<td width="400">
						${board.boardTitle}
					</td>
				</tr>
				<tr>
					<td height="300" align="center">
						Comment
					</td>
					<td>
						${board.boardComment}
					</td>
				</tr>
				<tr>
					<td align="center">
					Writer
					</td>
					<td>	
					</td>
				</tr>
			</table>
		</td>
	</tr>	
	<tr>
		<td align="right">
			<a href="/board/boardList.do">List</a>
			<a href="javascript:void(0);" onclick="deleteAjax();">삭제</a>
			<a href="/board/${board.boardType}/${board.boardNum}/boardUpdate.do">수정</a>
		</td>
	</tr>
</table>	
</body>
</html>
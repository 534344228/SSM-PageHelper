<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页插件</title>
<style type="text/css">
table {
	width: 60%;
}

td {
	text-align: center;
}

tr {
	text-align: center;
}
</style>
</head>
<body>
<form action="${path }/queryUser.action" method="post">
	<table border="1" align="center">
		<tr>
			<th colspan="3"><input type="text" name="password"> <input
				type="submit" value="查询"></th>
		</tr>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
		</tr>
		<c:forEach items="${pageInfo.list }" var="user" varStatus="status">
			<tr>
				<td>${(status.index+1)+(pageInfo.pageNum-1)*5 }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<table border="1" align="center">
		<tr>
			<!-- hasPreviousPage:是否包含上一页(Boolean) -->
			<c:if test="${pageInfo.hasPreviousPage }">
				<td><a
					href="${path }/queryUser.action.action.action.action.action?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}&password=${queryParam.password}">上一页</a></td>
			</c:if>
			<!-- navigatepageNums:页码信息(int[]) -->
			<c:forEach items="${pageInfo.navigatepageNums}" var="nav">
				<c:if test="${nav == pageInfo.pageNum}">
					<td>${nav}</td>
				</c:if>
				<c:if test="${nav != pageInfo.pageNum}">
					<td><a
						href="${path }/queryUser.action.action.action.action.action.action?page=${nav}&rows=${pageInfo.pageSize}&password=${queryParam.password}">${nav}</a></td>
				</c:if>
			</c:forEach>
			<!-- hasNextPage:是否包含下一页(Boolean) -->
			<c:if test="${pageInfo.hasNextPage }">
				<td><a
					href="${path }/queryUser.action.action.action.action.action?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}&password=${queryParam.password}">下一页</a></td>
			</c:if>
			<td>第${pageInfo.pageNum }页/共${pageInfo.pages }页</td>
		</tr>
	</table>

</body>
</html>
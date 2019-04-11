<%@ page contentType="text/html;charset=UTF-8"%>
获取url上的参数
<br>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/demo006_01_resp/222"
	method="post">
	<table align="center">
		<tr>
			<td>编号</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>

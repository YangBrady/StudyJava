<%@ page contentType="text/html;charset=UTF-8"%>
传统web参数
<br>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/redirect1"
	method="post">
	<table border="1">
		<tr>
			<td>message：</td>
			<td><input type="text" name="message"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/redirect2"
	method="post">
	<table border="1">
		<tr>
			<td>message：</td>
			<td><input type="text" name="message"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/dispatcher1"
	method="post">
	<table border="1">
		<tr>
			<td>message：</td>
			<td><input type="text" name="message"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/dispatcher2"
	method="post">
	<table border="1">
		<tr>
			<td>message：</td>
			<td><input type="text" name="message"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
<br>



获取url上的参数
<br>
<form
	action="${pageContext.request.contextPath}/frame/spring/demo/mvc/demo006_01_resp/222"
	method="post">
	<table border="1">
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

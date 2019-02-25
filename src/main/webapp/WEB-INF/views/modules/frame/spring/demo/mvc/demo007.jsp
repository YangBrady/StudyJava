<%@ page contentType="text/html;charset=UTF-8" %>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/demo007_resp" method="post">
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
            <td>爱好</td>
            <td><input type="checkbox" name="hobby" value="1">篮球</td>
            <td><input type="checkbox" name="hobby" value="2">足球</td>
            <td><input type="checkbox" name="hobby" value="3">排球</td>
            <td><input type="checkbox" name="hobby" value="4">羽毛球</td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
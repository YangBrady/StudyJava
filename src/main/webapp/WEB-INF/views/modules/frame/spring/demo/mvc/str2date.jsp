<%@ page contentType="text/html;charset=UTF-8" %>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/str2date/demo001_resp" method="post">
    <table align="center">
        <tr>
            <td>食物名称</td>
            <td><input type="text" name="username" value="哈哈"></td>
        </tr>
        <tr>
            <td>季节：</td>
            <td><input type="text" name="season" value="春"></td>
        </tr>
        <tr>
            <td>生产日期：</td>
            <td><input type="text" name="productDate" value="2019-02-26"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
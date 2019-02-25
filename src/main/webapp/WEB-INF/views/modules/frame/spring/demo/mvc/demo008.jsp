<%@ page contentType="text/html;charset=UTF-8" %>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/demo008_resp" method="post">
    <table align="center">
        <tr>
            <td><input type="text" name="users[0].id" value="1"/></td>
            <td><input type="text" name="users[0].username" value="哼哼"/></td>
        </tr>
        <tr>
            <td><input type="text" name="users[1].id" value="2"/></td>
            <td><input type="text" name="users[1].username" value="哈哈"/></td>
        </tr>
        <tr>
            <td><input type="text" name="users[2].id" value="3"/></td>
            <td><input type="text" name="users[2].username" value="嘿嘿"/></td>
        </tr>
        <tr>
            <td><input type="text" name="users[3].id" value="4"/></td>
            <td><input type="text" name="users[3].username" value="嘻嘻"/></td>
        </tr>
        <tr>
            <td><input type="text" name="users[4].id" value="5"/></td>
            <td><input type="text" name="users[4].username" value="略略"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
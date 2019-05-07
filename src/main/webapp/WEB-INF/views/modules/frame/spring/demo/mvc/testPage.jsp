<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h3>接收数组</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveArray" method="post">
    <label>编号: <input type="text" name="id"/></label><br>
    <label>用户名: <input type="text" name="username"/></label><br>
    <label>爱好</label>
    <label><input type="checkbox" name="hobby" value="1">篮球</label>
    <label><input type="checkbox" name="hobby" value="2">足球</label>
    <label><input type="checkbox" name="hobby" value="3">排球</label>
    <label><input type="checkbox" name="hobby" value="4">羽毛球</label>
    <input type="submit" value="提交">
</form>


<h3>接收List</h3>
<form action="${pageContext.request.contextPath}/frame/spring/demo/mvc/receiveList" method="post">
    <label>用户1</label><br>
    <label><input type="text" name="users[0].id" value="1"/></label>
    <label><input type="text" name="users[0].username" value="哼哼"/></label><br>
    <label>用户2</label><br>
    <label><input type="text" name="users[1].id" value="2"/></label>
    <label><input type="text" name="users[1].username" value="哈哈"/></label><br>
    <label>用户3</label><br>
    <label><input type="text" name="users[2].id" value="3"/></label>
    <label><input type="text" name="users[2].username" value="嘿嘿"/></label><br>
    <label>用户4</label><br>
    <label><input type="text" name="users[3].id" value="4"/></label>
    <label><input type="text" name="users[3].username" value="嘻嘻"/></label><br>
    <label>用户5</label><br>
    <label><input type="text" name="users[4].id" value="5"/></label>
    <label><input type="text" name="users[4].username" value="略略"/></label><br>
    <label><input type="submit" value="提交"/></label>
</form>

</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form  class="form-signin" action="/login/form" method="post">
    <h2 class="form-signin-heading">用户登录</h2>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"  class="form-control"  placeholder="请输入用户名"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"  class="form-control" placeholder="请输入密码" /></td>
        </tr>
        <tr>

            <td colspan="2">
                <button type="submit"  class="btn btn-lg btn-primary btn-block" >登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>